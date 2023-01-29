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
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author sahar
 */
@WebServlet(name = "AddListServlet", urlPatterns = {"/AddListServlet"})
public class AddListServlet extends HttpServlet {
    private final static String FILE_USERS = "E:\\school\\year3\\A\\programing ahmad\\HW1\\Users\\Users.txt";//לתת מיקום לשמירת קובץ המשתמשים
    private final static String FILE_TASK ="E:\\school\\year3\\A\\programing ahmad\\HW1\\tasks\\";// לתת מיקום לשמירת קבצי המשימות
    
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
        
        String TASK_FILE = FILE_TASK + user.getFirstName() + "_tasks.txt";
        ArrayList<taskList> my_list = taskList.getlists(TASK_FILE);
        String list = request.getParameter("lname");
        int i;
        
        for(i = 0; i < my_list.size() ; i++){
            if(my_list.get(i).listName.compareTo(list)==0){
                break;
            }
        }
        
        if(i != my_list.size()){
            try ( PrintWriter out = response.getWriter()) {
                out.println(MakePages.MessegePage("There Is a List Under That Name Already", user.getFirstName() , "red", "To_Menu_List_again"));
            }
        }
        
        else{
            taskList tasklist = new taskList(list);
            my_list.add(tasklist);
            taskList.writeList(my_list, TASK_FILE);
            try ( PrintWriter out = response.getWriter()) {
                out.println(MakePages.MessegePage("List "+ list + " was added successfully", user.getFirstName() , "green", "To_Menu_Task"));
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
