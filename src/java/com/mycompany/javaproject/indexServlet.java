package com.mycompany.javaproject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
/**
 *
 * @author sahar
 */
@WebServlet(urlPatterns = {"/indexServlet"})
public class indexServlet extends HttpServlet {

 

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String ses_str = (String)(session.getAttribute("email"));
        if(ses_str != null){
            response.sendError(response.SC_NOT_FOUND,"you are already logged in");
        }
        else{
            response.sendRedirect("index.html");
        }
        
//        try ( PrintWriter out = response.getWriter()) {
//            out.println(index.html);
//        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
