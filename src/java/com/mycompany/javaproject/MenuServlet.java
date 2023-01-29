package com.mycompany.javaproject;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 *
 * @author sahar
 */
@WebServlet(name = "MenuServlet", urlPatterns = {"/MenuServlet"})
public class MenuServlet extends HttpServlet {
         
    protected void add_list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String email = (String)(session.getAttribute("email"));
        
        try ( PrintWriter out = response.getWriter()) {
            User user = User.loadUserbyEmail(email);
            out.println(MakePages.AddNewList(user.getFirstName()));
        }
    }
    public void add_task(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String email = (String)(session.getAttribute("email"));
        String res_list = "";
        if(request.getQueryString().split("=").length > 2){
            if(request.getQueryString().split("=")[2] != null){
                String temp_res_list = request.getParameter("messege");
                String temp[] = temp_res_list.split(" ");
                for(int i = 1 ; i < temp.length - 3; i++){
                    res_list += temp[i] + " ";
                }
            }
        }
        try ( PrintWriter out = response.getWriter()) {
            User user = User.loadUserbyEmail(email);
            out.println(MakePages.AddNewTask(user.getFirstName(),res_list));
        }
    }
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
        if(ses_str == null){
            response.sendError(response.SC_NOT_FOUND,"you must be signed in");
        }
        String splited[] = request.getQueryString().split("=");
        String splited2[] = splited[1].split("&");
        if(splited[1].split("&")[0].equals("add_task")){
            add_task(request, response);
        }
        else if(((request.getQueryString().split("="))[1]).equals("add_list")){
            add_list(request, response);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
