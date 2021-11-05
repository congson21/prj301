/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.student;

import dal.ClassificationDBContext;
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
import model.Student;

/**
 *
 * @author Asus
 */
public class SearchController extends HttpServlet {

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
        String raw_id = request.getParameter("id");
        String raw_student_code = request.getParameter("student_code");
        String raw_name = request.getParameter("name");
        String raw_user_name = request.getParameter("user_name");
        String raw_gender = request.getParameter("gender");
        String raw_from = request.getParameter("from");
        String raw_to = request.getParameter("to");
        String raw_cid = request.getParameter("cid");
        
        if(raw_id == null || raw_id.length() ==0)
            raw_id = "-1";
        if(raw_cid == null || raw_cid.length() ==0)
            raw_cid = "-1";
        if(raw_gender ==null || raw_gender.length() ==0)
            raw_gender = "all";
        
        int id = Integer.parseInt(raw_id);
        int cid = Integer.parseInt(raw_cid);
        Boolean gender = raw_gender.equals("all")?null:raw_gender.equals("male");
        Date from = (raw_from ==null ||raw_from.length() ==0)?null : Date.valueOf(raw_from);
        Date to = (raw_to ==null ||raw_to.length() ==0)?null : Date.valueOf(raw_to);
        String student_code = raw_student_code;
        String name = raw_name;
        String user_name = raw_user_name;
        
        
        StudentDBContext sDB = new StudentDBContext();
        ArrayList<Student> students = sDB.search(id, student_code, name, user_name, gender, from, to, cid);
        
        ClassificationDBContext cDB = new ClassificationDBContext();
        ArrayList<Classification> classifications = cDB.getClassifications();
        
        request.setAttribute("students", students);
        request.setAttribute("classifications", classifications);
        request.getRequestDispatcher("../view/search.jsp").forward(request, response);
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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
