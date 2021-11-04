/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import model.Classification;
import model.Room;
import model.Student_Room;

/**
 *
 * @author Asus
 */
public class StudentDBContext extends DBContext {

    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "SELECT id,student_code,name,user_name,dob,gender,c.cid,cname FROM\n"
                    + "Student s INNER JOIN Classification c\n"
                    + "ON s.cid = c.cid";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery(); //thuc hien cac cau query truy van //rs la 1 con tro, doc tung row tung row
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setStudent_code(rs.getString("student_code"));
                s.setName(rs.getString("name"));
                s.setUser_name(rs.getString("user_name"));
                s.setDob(rs.getDate("dob"));
                s.setGender(rs.getBoolean("gender"));

                Classification c = new Classification();
                c.setId(rs.getInt("cid"));
                c.setName(rs.getString("cname"));
                s.setClassi(c);
                students.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

    public Student getStudent(int id) {
        try {
            String sql = "SELECT s.id,s.student_code,s.name,s.user_name,s.dob,s.gender,c.cid,c.cname,r.rid,r.name as rname FROM Student s\n"
                    + "INNER JOIN Classification c\n"
                    + "ON s.cid = c.cid\n"
                    + "LEFT JOIN Student_Room sr\n"
                    + "ON s.id = sr.sid\n"
                    + "LEFT JOIN Room r\n"
                    + "ON sr.rid = r.rid\n"
                    + "WHERE s.id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery(); //thuc hien cac cau query truy van //rs la 1 con tro, doc tung row tung row
            Student s = null;
            while (rs.next()) {
                if (s == null) {
                    s = new Student();
                    s.setId(rs.getInt("id"));
                    s.setStudent_code(rs.getString("student_code"));
                    s.setName(rs.getString("name"));
                    s.setUser_name(rs.getString("user_name"));
                    s.setDob(rs.getDate("dob"));
                    s.setGender(rs.getBoolean("gender"));

                    Classification c = new Classification();
                    c.setId(rs.getInt("cid"));
                    c.setName(rs.getString("cname"));
                    s.setClassi(c);
                }

                int rid = rs.getInt("rid");
                if (rid != 0) {
                    Student_Room sr = new Student_Room();
                    Room r = new Room();
                    r.setId(rid);
                    r.setName(rs.getString("rname"));
                    sr.setRoom(r);
                    sr.setStudent(s);
                    s.getRooms().add(sr);
                }
            }
            return s;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insert(Student s) {
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO [Student]\n"
                    + "           ([student_code]\n"
                    + "           ,[name]\n"
                    + "           ,[user_name]\n"
                    + "           ,[dob]\n"
                    + "           ,[gender]\n"
                    + "           ,[cid])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, s.getStudent_code());
            stm.setString(2, s.getName());
            stm.setString(3, s.getUser_name());
            stm.setDate(4, s.getDob());
            stm.setBoolean(5, s.isGender());
            stm.setInt(6, s.getClassi().getId());
            stm.executeUpdate();

            String sql_get_id = "SELECT @@IDENTITY as sid";
            PreparedStatement stm_get_sid = connection.prepareStatement(sql_get_id);
            stm_get_sid.executeQuery();
            ResultSet rs = stm_get_sid.executeQuery();
            if (rs.next()) {
                s.setId(rs.getInt("sid"));
            }
            for (Student_Room room : s.getRooms()) {
                String sql_insert_room = "INSERT INTO [Student_Room]\n"
                        + "           ([sid]\n"
                        + "           ,[rid])\n"
                        + "     VALUES\n"
                        + "           (?\n"
                        + "           ,?)";
                PreparedStatement stm_insert_room = connection.prepareStatement(sql_insert_room);
                stm_insert_room.setInt(1, s.getId());
                stm_insert_room.setInt(2, room.getRoom().getId());
                stm_insert_room.executeUpdate();
            }

            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void update(Student s) {
        try {
             connection.setAutoCommit(false);
            String sql = "UPDATE [Student]\n"
                    + "   SET [student_code] = ?\n"
                    + "      ,[name] = ?\n"
                    + "      ,[user_name] = ?\n"
                    + "      ,[dob] = ?\n"
                    + "      ,[gender] = ?\n"
                    + "      ,[cid] = ?\n"
                    + " WHERE id=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, s.getStudent_code());
            stm.setString(2, s.getName());
            stm.setString(3, s.getUser_name());
            stm.setDate(4, s.getDob());
            stm.setBoolean(5, s.isGender());
            stm.setInt(6, s.getClassi().getId());
            stm.setInt(7, s.getId());
            stm.executeUpdate();
            
            String sql_remove_rooms = "DELETE Student_Room WHERE sid = ?";
            PreparedStatement stm_remove_rooms = connection.prepareStatement(sql_remove_rooms);
            stm_remove_rooms.setInt(1, s.getId());
            stm_remove_rooms.executeUpdate();
            
            for (Student_Room room : s.getRooms()) {
                String sql_insert_room = "INSERT INTO [Student_Room]\n"
                        + "           ([sid]\n"
                        + "           ,[rid])\n"
                        + "     VALUES\n"
                        + "           (?\n"
                        + "           ,?)";
                PreparedStatement stm_insert_room = connection.prepareStatement(sql_insert_room);
                stm_insert_room.setInt(1, s.getId());
                stm_insert_room.setInt(2, room.getRoom().getId());
                stm_insert_room.executeUpdate();
            }
            
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void delete(int id) {
        try {
            String sql = "DELETE Student WHERE id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
