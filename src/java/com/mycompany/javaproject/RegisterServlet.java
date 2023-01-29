package com.mycompany.javaproject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author sahar
 */
@WebServlet(urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
    }
protected void signup(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
                String firstname = request.getParameter("ufname");              
                String lastname = request.getParameter("ulname");
                String email = request.getParameter("uemail");              
                String password = request.getParameter("password");
                if(!User.signUp(email,password,firstname,lastname)){
                    out.println(MakePages.MessegePage("Something went wrong, This email already in the system", "user", "red", "back_home"));
                }
                else{
                    User user = User.loadUserbyEmail(email);
                    HttpSession session = request.getSession();
                    session.setAttribute("email", email);
                    out.println(MakePages.MessegePage("You are succesfully logged in", user.getFirstName() , "green","To_Menu"));
                }
        }
    }
    protected void buildMenupage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String email = (String)(session.getAttribute("email"));
            if(email == null){
                response.sendError(response.SC_NOT_FOUND,"you must be signed in");
            }
            User user = User.loadUserbyEmail(email);
            out.println(MakePages.MenuPage(user.getFirstName()));
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String ses_str = (String)(session.getAttribute("email"));
        
        if(((request.getQueryString().split("="))[1]).equals("registered")){
            buildMenupage(request,response);
        }
        else{
            if (ses_str != null){
                response.sendError(response.SC_NOT_FOUND,"you already signed ins");
            }
            signup(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
