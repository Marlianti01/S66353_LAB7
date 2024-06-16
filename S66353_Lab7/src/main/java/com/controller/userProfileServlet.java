/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller;

import com.DAO.userProfileDAO;
import com.model.userProfile;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class userProfileServlet extends HttpServlet {

    private static String INSERT = "/EntryForm.jsp";
    private static String LIST_USER = "/profileList.jsp";
    private userProfileDAO dao;
    
    public userProfileServlet() throws ClassNotFoundException{
        super();
        dao = new userProfileDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String forward = "";
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("profileList")){
            forward = LIST_USER;
            request.setAttribute("userProfiles", dao.getAllUsers());
        }
        else if(action.equalsIgnoreCase("insert")){
            forward=INSERT;
        }
       RequestDispatcher view = request.getRequestDispatcher(forward);
       view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        userProfile userp = new userProfile();
        userp.setUsername(request.getParameter("username"));
        userp.setIcno(request.getParameter("icno"));
        userp.setFirstname(request.getParameter("firstname"));
        
        if(action.equalsIgnoreCase("insert")){
            dao.addUser(userp);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("userProfiles", dao.getAllUsers());
        view.forward(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
