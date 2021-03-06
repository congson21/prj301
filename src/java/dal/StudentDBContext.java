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
            String sql = "SELECT id,student_code,name,user_name,dob,gender,c.cid,cname FROM\n"
                    + "Student s INNER JOIN Classification c\n"
                    + "ON s.cid = c.cid WHERE id=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery(); //thuc hien cac cau query truy van //rs la 1 con tro, doc tung row tung row
            if(rs.next()) {
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
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insert(Student s) {
        try {
            String sql="INSERT INTO [Student]\n" +
                    "           ([student_code]\n" +
                    "           ,[name]\n" +
                    "           ,[user_name]\n" +
                    "           ,[dob]\n" +
                    "           ,[gender]\n" +
                    "           ,[cid])\n" +
                    "     VALUES\n" +
                    "           (?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?)";
            PreparedStatement stm=connection.prepareStatement(sql);
            stm.setString(1, s.getStudent_code());
            stm.setString(2, s.getName());
            stm.setString(3, s.getUser_name());
            stm.setDate(4, s.getDob());
            stm.setBoolean(5, s.isGender());
            stm.setInt(6, s.getClassi().getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Student s) {
       try {
            String sql="UPDATE [Student]\n" +
                        "   SET [student_code] = ?\n" +
                        "      ,[name] = ?\n" +
                        "      ,[user_name] = ?\n" +
                        "      ,[dob] = ?\n" +
                        "      ,[gender] = ?\n" +
                        "      ,[cid] = ?\n" +
                        " WHERE id=?";
            PreparedStatement stm=connection.prepareStatement(sql);
            stm.setString(1, s.getStudent_code());
            stm.setString(2, s.getName());
            stm.setString(3, s.getUser_name());
            stm.setDate(4, s.getDob());
            stm.setBoolean(5, s.isGender());
            stm.setInt(6, s.getClassi().getId());
            stm.setInt(7, s.getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int id) {
       try {
            String sql="DELETE Student WHERE id = ?"                        ;
            PreparedStatement stm=connection.prepareStatement(sql);
            stm.setInt(1,id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
