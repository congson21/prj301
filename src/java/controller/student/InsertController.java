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
public class InsertController extends BaseRequiredAuthController {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ClassificationDBContext csDB = new ClassificationDBContext();
        ArrayList<Classification> classifications = csDB.getClassifications();
        request.setAttribute("classifications", classifications);

        RoomDBContext rDB = new RoomDBContext();
        ArrayList<Room> rooms = rDB.getRooms();
        request.setAttribute("rooms", rooms);

        request.getRequestDispatcher("../view/insert.jsp").forward(request, response);
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
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Student s = new Student();
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
        db.insert(s);
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
