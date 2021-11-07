/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.student;

import controller.authentication.BaseRequiredAuthController;
import dal.ClassificationDBContext;
import dal.RoomDBContext;
import dal.StudentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Classification;
import model.Room;
import model.Student;
import model.Student_Room;

/**
 *
 * @author Asus
 */
public class UpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        StudentDBContext student_db = new StudentDBContext();
        Student student = student_db.getStudent(id);           
        request.setAttribute("student", student);
        
        ClassificationDBContext classification_db = new ClassificationDBContext();
        ArrayList<Classification> classifications = classification_db.getClassifications();
        request.setAttribute("classifications", classifications);
        
        RoomDBContext room_db = new RoomDBContext();
        ArrayList<Room> rooms = room_db.getRooms();
        request.setAttribute("rooms", rooms);
        
        request.getRequestDispatcher("../update.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      Student s = new Student();
      s.setId(Integer.parseInt(request.getParameter("id")));
        s.setStudent_code(request.getParameter("student_code"));
        s.setName(request.getParameter("name"));
        s.setUser_name(request.getParameter("user_name"));
        s.setGender(request.getParameter("gender").equals("male"));
        s.setDob(Date.valueOf(request.getParameter("dob")));
        
        Classification c = new Classification();
        c.setId(Integer.parseInt(request.getParameter("cid")));
        s.setClassi(c);
        
        String[] rids = request.getParameterValues("rid");
        if (rids != null) {
            for (String rid : rids) {
                Student_Room sr = new Student_Room();
                sr.setStudent(s);
                Room r = new Room();
                r.setId(Integer.parseInt(rid));
                sr.setRoom(r);
                s.getRooms().add(sr);
            }
        }
        
        StudentDBContext db = new StudentDBContext();
        db.update(s);
        response.sendRedirect("list");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
