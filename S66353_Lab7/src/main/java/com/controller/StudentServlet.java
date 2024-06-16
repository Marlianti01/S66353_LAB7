/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.model.Student;
import jakarta.servlet.http.HttpSession;
/**
 *
 * @author marli
 */
public class StudentServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String studid = request.getParameter("studid");
        String name = request.getParameter("name");
        
        Student stud = new Student();
        stud.setStudentid(studid);
        stud.setName(name);
                
        HttpSession session = request.getSession();
        session.setAttribute("student", stud);
        
        response.sendRedirect("comfirmRegister.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
