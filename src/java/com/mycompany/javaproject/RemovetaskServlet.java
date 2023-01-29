/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.javaproject;
import static com.mycompany.javaproject.ShowListServlet.makePageshowList;
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
@WebServlet(name = "RemovetaskServlet", urlPatterns = {"/RemovetaskServlet"})
public class RemovetaskServlet extends HttpServlet {
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
        String TASK_FILE = FILE_TASK + user.getFirstName() + "_tasks.txt";
        ArrayList<taskList> my_list = taskList.getlists(TASK_FILE);
        if(ses_str == null){
            response.sendError(response.SC_NOT_FOUND,"you must be signed in");
        }
        String name = request.getParameter("name");
        String task_name = request.getParameter("task_name");
        String list_name = request.getParameter("list_name");
        for(int i = 0 ; i < my_list.size(); i++){
            if(my_list.get(i).listName.equals(list_name)){
                for(int j = 0 ; j < my_list.get(i).yourList.size() ; i++ ){
                    if(my_list.get(i).yourList.get(j).taskName.equals(task_name)){
                        my_list.get(i).yourList.remove(j);
                        taskList.writeList(my_list, TASK_FILE);
                        break;
                    }
                }
                break;
            }
        }
        try ( PrintWriter out = response.getWriter()) {
            out.println(ShowListServlet.makePageshowList(ses_str,my_list));
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
