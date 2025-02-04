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

import com.DAO.userDAO;
import com.model.User;
import jakarta.servlet.RequestDispatcher;

public class UserController extends HttpServlet {

    private static String INSERT = "/user.jsp";
    private static String EDIT = "/editUser.jsp";
    private static String LIST_USER = "/listUser.jsp";
    private userDAO dao;

    public UserController() throws ClassNotFoundException {
        super();
        dao = new userDAO();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String forward="";
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("delete")){
            String userid = request.getParameter("userid");
            dao.deleteUser(userid);
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());
        }
        else if(action.equalsIgnoreCase("edit")){
            forward = EDIT;
            String userid = request.getParameter("userid");
            User user = dao.getUserById(userid);
            request.setAttribute("user", user);
        }
        
        else if(action.equalsIgnoreCase("listUser")){
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());
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
        
        User user = new User();
        user.setUserid(request.getParameter("userid"));
        user.setFirstname(request.getParameter("firstname"));
        user.setLastname(request.getParameter("lastname"));
        
        if(action.equalsIgnoreCase("edit")){
            dao.updateUser(user);
        }
        else{
            dao.addUser(user);
        }
        
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("users", dao.getAllUsers());
        view.forward(request,response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
