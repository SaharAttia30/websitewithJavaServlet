/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.javaproject;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
/**
 *
 * @author sahar
 */
@WebServlet(name = "AddTaskServlet", urlPatterns = {"/AddTaskServlet"})
public class AddTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String ses_str = (String)(session.getAttribute("email"));
        User user = User.loadUserbyEmail(ses_str);
        if(ses_str == null){
            response.sendError(response.SC_NOT_FOUND,"you must be signed in");
        }
        response.setContentType("text/html;charset=UTF-8");
        String email = (String)(session.getAttribute("email"));   
        String Uname = user.getFirstName();
        String list = request.getParameter("tlname");
        String taskname = request.getParameter("tname");
        String taskdetails = request.getParameter("tdesc");
        String taskpriority = request.getParameter("tpriority");
        boolean isdone = false;
        String endDate = request.getParameter("ubdate");
        String res = Task.add_task(email, Uname, list ,taskname ,taskdetails,taskpriority , isdone, endDate);
        
        try ( PrintWriter out = response.getWriter()) {
            if(res.equals("false")){
                out.println(MakePages.MessegePage("Task Name Already Exists ", user.getFirstName() , "red","To_Menu_Task_again")); /// need to make links on the buttom of the page
            }
            else
                out.println(MakePages.MessegePage("Task Was Added Succesfully. " + res, user.getFirstName() , "green","To_Menu_Task")); /// need to make links on the buttom of the page
        }
    }
    

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
