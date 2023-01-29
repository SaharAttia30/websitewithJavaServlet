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

@WebServlet(name = "ShowListServlet", urlPatterns = {"/ShowListServlet"})
public class ShowListServlet extends HttpServlet {
    private final static String FILE_USERS = "E:\\school\\year3\\A\\programing ahmad\\HW1\\Users\\Users.txt";//לתת מיקום לשמירת קובץ המשתמשים
    private final static String FILE_TASK ="E:\\school\\year3\\A\\programing ahmad\\HW1\\tasks\\";// לתת מיקום לשמירת קבצי המשימות
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    public static String makePageshowList(String email , ArrayList<taskList> my_list1)
            throws ServletException, IOException {
        
        User user = User.loadUserbyEmail(email);
        ArrayList<taskList> my_list = my_list1;
        int i;
        String res = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    <title>Show List Page</title>\n" +
            "    <link rel=\"stylesheet\" href=\"CSS/style.css\">\n" +
            "    <link rel=\"stylesheet\" href=\"CSS/styleshowlist.css\">\n" +
            "    <script src=\"JS/allhover.js\" defer></script>\n" +
            "    <script src=\"JS/showlistjs.js\" defer></script>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <div id=\"header\">\n" +
            "        <a href=\"index.html\">\n" +
            "        <img src=\"IMG/logo2.jpg\" alt=\"logo\"></a>\n" +
            "        <h1>This Is My Site</h1>\n" +
            "        <h2>Hello " + user.getFirstName() + "</h2>\n"
             + "<form action=\"logOutServlet\" method=\"post\" style=\"padding:0 0 0 0 ; margin:0 0 0 0 ; border:0; background-color: aqua;\">\n" +
                "            <button type=\"submit\" style=\"margin-top:50px;\">logout</button>\n" +
                "        </form>" +
            "    </div>\n" +
            "   \n" +
            "    <h1 class=\"login\">Show Lists Page</h1>\n" +
            "    <h2>Here You Will See The Tasks In Your lists</h2>\n" ;
        for( i = 0; i < my_list.size() ; i++){
            res +="<form action=\"ShowListServlet?cmd=remove_list&name=" + my_list.get(i).listName +
                    "\" method=\"post\"> <h1>" + my_list.get(i).listName + "</h1>" +
                    "<button type=\"submit\" style=\"width:50%\">delete table</button>"+
                    "</form>"+
                    "<div id=\"table\">\n" +
                    "<div class=\"row\">\n" +
            "                <div class=\"table_head\">Name Of Tasm</div>\n" +
            "                <div class=\"table_head\">Description Of Task</div>\n" +
            "                <div class=\"table_head\">Priority</div>\n" +
            "                <div class=\"table_head\">Date</div>\n" +
            "                <div class=\"table_head\">Is Done</div>\n" +
            "                <div class=\"table_head\">Delete Task</div>\n" +
            "            </div>\n" ;
            for(int j = 0 ; j < my_list.get(i).yourList.size() ; j++){
                res += "<div class=\"row\">\n" +
                        "<div class=\"table_cell\">"+ my_list.get(i).yourList.get(j).taskName+ "</div>\n" +
                        "<div class=\"table_cell\">"+ my_list.get(i).yourList.get(j).taskDetails+ "</div>\n" +
                        "<div class=\"table_cell\">"+ my_list.get(i).yourList.get(j).priority+ "</div>\n" +
                        "<div class=\"table_cell\"><input type=\"date\" value=\""+ my_list.get(i).yourList.get(j).date+ "\"></div>\n" +
                        "<div class=\"table_cell\"><input type=\"checkbox\"  id=\"checkbox"+ (i*my_list.size() +j)+  "\" name=\"Isdone\" value=\"is done\" onclick=\"myfunc(" + (i*my_list.size() +j) + ")\" "; // +
                if(my_list.get(i).yourList.get(j).isDone){
                    res += "checked></div>";
                }
                else{
                    res += "></div>\n";
                }//                        
                res += "<div class=\"table_cell\"><form action=\"RemovetaskServlet?name=" + user.getFirstName() + "&task_name=" + my_list.get(i).yourList.get(j).taskName+ "&list_name=" + 
                        my_list.get(i).listName+
                        "\" method=\"post\" style=\"padding:0; margin:0; border:0;\"><button type=\"submit\">remove</button></form></div>"
                        + "</div>";
            }
            res += "</div>"+
                    "</div>"     ;
          
        }
        res += "    <footer>\n" +
            "        <div id = \"footer\">\n" +
            "            Sahar Attia <a href=\"https://www.netanya.ac.il/\" target=\"_blank\">Press For Natanya College</a>\n" +
            "        </div>\n" +
            "    </footer>\n" +
            "    \n" +
            "</body>\n" +
            "</html>";
        return res;
    }
    public void removeList(String name_of_list, String username){
        String TASK_FILE = FILE_TASK + username + "_tasks.txt";
        ArrayList<taskList> my_list = taskList.getlists(TASK_FILE);
        System.out.println("Enter the list name");
        String list = name_of_list;
        int i;
        for(i = 0; i < my_list.size() ; i++){
            if(my_list.get(i).listName.compareTo(list)==0){
                my_list.remove(i);
                taskList.writeList(my_list, TASK_FILE);
                break;
            }
        }
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
        User user = User.loadUserbyEmail(ses_str);
        String TASK_FILE = FILE_TASK + user.getFirstName() + "_tasks.txt";
        ArrayList<taskList> my_list = taskList.getlists(TASK_FILE);
        String cmd_str = request.getParameter("cmd");
        if(cmd_str.equals("remove_list")){
            String name_list = request.getParameter("name");
            String username = user.getFirstName();
            removeList(name_list,username);
        }
        try ( PrintWriter out = response.getWriter()) {
            out.println(makePageshowList(ses_str,my_list));
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
