/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaproject;

/**
 *
 * @author sahar
 */
public class MakePages {
    
    
    public static String AddNewList(String username){
        String name = username;
        if (name.equals("")){
            name = "user";
        }
        String res = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    <title>Add List Page</title>\n" +
            "    <link rel=\"stylesheet\" href=\"CSS/styleaddlist.css\">\n" +
            "    <link rel=\"stylesheet\" href=\"CSS/style.css\">\n" +
            "    <script src=\"JS/allhover.js\" defer></script>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <div id=\"header\">\n" +
            "        <a href=\"index.html\">\n" +
            "        <img src=\"IMG/logo2.jpg\" alt=\"logo\"></a>\n" +
            "        <h1>This Is My Site</h1>\n" +
            "        <h2>Hello " + name + "</h2>\n"
            + "<form action=\"logOutServlet\" method=\"post\" style=\"padding:0 0 0 0 ; margin:0 0 0 0 ; border:0; background-color: aqua;\">\n" +
                "            <button type=\"submit\" style=\"margin-top:50px;\">logout</button>\n" +
                "        </form>" +
            "    </div>\n" +
            "   \n" +
            "        <h1 class=\"login\">Add List Page</h1>\n" +
            "        <h2>Fill Out To Add New List</h2>\n" +
            "        <form action=\"AddListServlet\" method=\"post\">\n" +
            "            <div class=\"imgcontainer\">\n" +
            "              <img src=\"IMG/cyber.jpg\" alt=\"cyber\" class=\"avatar\">\n" +
            "            </div>\n" +
            "            <div class=\"container\">\n" +
            "                <label for=\"lname\"><b>List Name</b></label>\n" +
            "                <input type=\"text\" placeholder=\"Enter List Name\" name=\"lname\" required>\n" +
            "                <button type=\"submit\">Add List</button>\n" +
            "            </div>\n" +
            "        </form>\n" +
            "    <footer>\n" +
            "        <div id = \"footer\">\n" +
            "            Sahar Attia <a href=\"https://www.netanya.ac.il/\" target=\"_blank\">Press For Natanya College</a>\n" +
            "        </div>\n" +
            "    </footer>\n" +
            "</body>\n" +
            "</html>";
        return res; 
     }
    public static String AddNewTask(String username, String list_name){
        String name = username;
        if (name.equals("")){
            name = "user";
        }
        String res ="<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    <title>Add Task Page</title>\n" +
            "    <link rel=\"stylesheet\" href=\"CSS/styleaddtask.css\">\n" +
            "    <link rel=\"stylesheet\" href=\"CSS/style.css\">\n" +
            "    <script src=\"JS/allhover.js\" defer></script>\n" +
            "    <script>\n" +
            "        function clearData(){\n" +
            "            let inputs = document.querySelectorAll('input');\n" +
            "            inputs.forEach(element => {\n" +
            "                element.value = '';\n" +
            "            });\n" +
            "        }\n" +
            "    </script>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <div id=\"header\">\n" +
            "        <a href=\"index.html\">\n" +
            "        <img src=\"IMG/logo2.jpg\" alt=\"logo\"></a>\n" +
            "        <h1>This Is My Site</h1>\n" +
            "        <h2>Hello " + name + "</h2>\n"
             + "<form action=\"logOutServlet\" method=\"post\" style=\"padding:0 0 0 0 ; margin:0 0 0 0 ; border:0; background-color: aqua;\">\n" +
                "            <button type=\"submit\" style=\"margin-top:50px;\">logout</button>\n" +
                "        </form>" +
            "    </div>\n" +
            "        <h1 class=\"login\">Add Tasks Page</h1>\n" +
            "        <h2>Fill Out To Add New Task</h2>\n" +
            "        <form action=\"AddTaskServlet\" method=\"post\">\n" +
            "            <div class=\"imgcontainer\">\n" +
            "              <img src=\"IMG/cyber.jpg\" alt=\"cyber\" class=\"avatar\">\n" +
            "            </div>\n" +
            "            <div class=\"container\">\n" +
            "                <label for=\"tname\"><b>List Name To Enter Task</b></label>\n";
            if(list_name.equals("")){
                res +="<input type=\"text\" placeholder=\"Enter List Name\" name=\"tlname\" required>\n";
            }
            else{
                res +="<input type=\"text\" placeholder=\"Enter List Name\" name=\"tlname\" value=\""+list_name+"\" readonly=\"readonly\"required>\n";
                 
            }
            res +="<label for=\"tname\"><b>Task Name</b></label>\n" +
            "                <input type=\"text\" placeholder=\"Enter Task Name\" name=\"tname\" required>\n" +
            "\n" +
            "                <label for=\"tdesc\"><b>Description</b></label>\n" +
            "                <input type=\"text\" placeholder=\"Enter Description Max 100\" name=\"tdesc\" maxlength=\"100\" required>\n" +
            "\n" +
            "                <label for=\"tpriority\"><b>Priority</b></label>\n" +
            "                <input type=\"number\" min=\"1\" max=\"3\" placeholder=\"Enter The Priority Of The Task From 1-3\" name=\"tpriority\" required>\n" +
            "\n" +
            "                <label for=\"ubdate\"><b>Finish Date</b></label>\n" +
            "                <input type=\"date\" placeholder=\"Enter Your Birth Date\" name=\"ubdate\" min=\"2022-12-08\" max=\"2030-12-08\" required>\n" +
            "                <button type=\"submit\">Add Task</button>" +
            "            </div>\n" +
            "        </form>\n" +
            "    <footer>\n" +
            "        <div id = \"footer\">\n" +
            "            Sahar Attia <a href=\"https://www.netanya.ac.il/\" target=\"_blank\">Press For Natanya College</a>\n" +
            "        </div>\n" +
            "    </footer>\n" +
            "</body>\n" +
            "</html>";
        
        
        return res;
        
    }
    public static String MenuPage(String name){
        String res = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    <title>Menu Page</title>\n" +
            "    <link rel=\"stylesheet\" href=\"CSS/stylemenu.css\">\n" +
            "    <link rel=\"stylesheet\" href=\"CSS/style.css\">\n" +
            "    <script src=\"JS/allhover.js\" defer></script>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <div id=\"header\">\n" +
            "        <a href=\"index.html\">\n" +
            "        <img src=\"IMG/logo2.jpg\" alt=\"logo\"></a>\n" +
            "        <h1>This Is My Site</h1>\n" +
            "        <h2>Hello " + name + "</h2>\n"
             + "<form action=\"logOutServlet\" method=\"post\" style=\"padding:0 0 0 0 ; margin:0 0 0 0 ; border:0; background-color: aqua;\">\n" +
                "            <button type=\"submit\" style=\"margin-top:50px; margin-right:15px;\">logout</button>\n" +
                "        </form>" +
            "         \n" +
            "    </div>\n" +
            "    <h1 class=\"title\">Welcome To Our Website</h1>\n" +
            "    <h2 id=\"sectitle\"> This Is The Menu To Our Website, Make Your Choice Below</h2>\n" +
            "    <div style=\"display: flex; padding: 0 15% 0 15%\">\n" +
            "        <form action=\"MenuServlet?cmd=add_task\" method=\"post\">\n" +
            "            <div class=\"gallery\">\n" +
            "                    <img src=\"IMG/tasks.png\" alt=\"signup\">\n" +
            "                <div class=\"desc\">To Add New Task Press Here</div>\n" +
            "            </div>\n" +
            "            <button type=\"submit\">GO</button>\n" +
            "        </form>\n" +
            "        \n" +
            "        <form action=\"MenuServlet?cmd=add_list\" method=\"post\">\n" +
            "            <div class=\"gallery\">\n" +
            "                <img src=\"IMG/addlists.jpg\" alt=\"login\">            \n" +
            "                <div class=\"desc\">To Add New List Press Here</div>\n" +
            "            </div>\n" +
            "            <button type=\"submit\">GO</button>\n" +
            "        </form>\n" +
            "        \n" +
            "        <form action=\"ShowListServlet?cmd=show_list\" method=\"post\">\n" +
            "            <div class=\"gallery\">\n" +
            "                <img src=\"IMG/lists.png\" alt=\"login\">\n" +
            "                <div class=\"desc\">To Show Lists Press Here</div>\n" +
            "            </div>\n" +
            "            <button type=\"submit\">GO</button>\n" +
            "        </form>\n" +
            "    </div>\n" +
            "    <footer>\n" +
            "        <div id = \"footer\">\n" +
            "            Sahar Attia <a href=\"https://www.netanya.ac.il/\" target=\"_blank\">Press For Natanya College</a>\n" +
            "        </div>\n" +
            "    </footer>\n" +
            "</body>\n" +
            "</html>";
        return res;
    }
    public static String RegisterPage(){
         String res ="<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Registration Page</title>\n" +
                "    <link rel=\"stylesheet\" href=\"CSS/styleregister.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"CSS/style.css\">\n" +
                "    <script src=\"JS/allhover.js\" defer></script>\n" +
                "    <script src=\"JS/register.js\" defer></script>\n" +
                "    \n" +
                "</head>\n" +
                "<body>\n" +
                "    <div id=\"header\">\n" +
                "        <a href=\"index.html\">\n" +
                "        <img src=\"IMG/logo2.jpg\" alt=\"logo\"></a>\n" +
                "        <h1>This Is My Site</h1>\n" +
                "        <h2>Hello User</h2>\n"
                 + "<form action=\"logOutServlet\" method=\"post\" style=\"display: flex; padding: 0 25% 0 25%\">\n" +
                "            <button type=\"submit\">logout</button>\n" +
                "        </form>" +
                "    </div>" +
                "    <h1 class=\"register\">\n" +
                "        Registration Page\n" +
                "    </h1>\n" +
                "    <h2>Fill Out Your Info</h2>\n" +
                "    <form action=\"RegisterServlet?cmd=register\" method=\"post\">\n" +
                "        <div class=\"imgcontainer\">\n" +
                "          <img src=\"IMG/cyber.jpg\" class=\"avatar\">\n" +
                "        </div>\n" +
                "        <div class=\"container\">\n" +
                "            <label for=\"uemail\"><b>Email</b></label>\n" +
                "            <input type=\"email\" placeholder=\"Enter Username\" id=\"uname\" name=\"uemail\" required>\n" +
                "        \n" +
                "            <label for=\"upsw\"><b>Password</b></label>\n" +
                "            <input type=\"password\" placeholder=\"Enter Password\" id=\"psw\" name =\"password\" required>\n" +
                "\n" +
                "            <label for=\"ufname\"><b>First Name</b></label>\n" +
                "            <input type=\"text\" placeholder=\"Enter Your First Name\" name=\"ufname\">\n" +
                "        \n" +
                "            <label for=\"ulname\"><b>Last Name</b></label>\n" +
                "            <input type=\"text\" placeholder=\"Enter your Last Name\" name=\"ulname\">\n" +
                "\n" +
                "            <label for=\"ubdate\"><b>Birth Date</b></label>\n" +
                "            <input type=\"date\" placeholder=\"Enter Your Birth Date\" name=\"ubdate\" min=\"1902-12-08\" max=\"2012-12-08\">\n" +
                "\n" +
                "            <label for=\"uage\"><b>Age</b></label>\n" +
                "            <input type=\"number\" min=\"10\" max=\"120\" placeholder=\"Enter Your Age\" name=\"uage\">\n" +
                "        \n" +
                "            <label for=\"gender\"><b>Gender</b></label>\n" +
                "            <input type=\"text\" placeholder=\"Enter Gender Male/Female\" value=\"Male\" pattern=\"(Male)|(Female)|(male)|(female)\" name=\"gender\">\n" +
                "            <label>\n" +
                "            <input type=\"checkbox\" id=\"terms\" onclick=\"myfun()\"> I Agree To Terms Of Use <a href=\"terms.html\" target=\"_blank\">To Read Terms Press Here</a>\n" +
                "            </label>\n" +
                "            <button type=\"submit\" class=\"mybutt11\" onclick=\"login()\" disabled=\"true\">Register</button>\n" +
                "        </div>\n" +
                "    </form>\n" +
                "    <footer>\n" +
                "        <div id = \"footer\">\n" +
                "            Sahar Attia <a href=\"https://www.netanya.ac.il/\" target=\"_blank\">Press For Natanya College</a>\n" +
                "        </div>\n" +
                "    </footer>\n" +
                "</body>\n" +
                "</html>";
         return res;
    }
    
     public static String LogInPage(){
         String res ="<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<link rel=\"stylesheet\" href=\"CSS/stylelogin.css\">\n" +
                "<link rel=\"stylesheet\" href=\"CSS/style.css\">\n" +
                "<script src=\"JS/allhover.js\" defer></script>\n" +
                "<script src=\"JS/login.js\" defer></script>\n" +
                "<title>Log In Page</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "  <div id=\"header\">\n" +
                "    <a href=\"index.html\">\n" +
                "    <img src=\"IMG/logo2.jpg\" alt=\"logo\"></a>\n" +
                "    <h1>This Is My Site</h1>\n" +
                "    <h2>Hello User</h2>\n"+
                "<form action=\"logOutServlet\" method=\"post\" style=\"padding:0 0 0 0 ; margin:0 0 0 0 ; border:0; background-color: aqua;\">\n" +
                "            <button type=\"submit\" style=\"margin-top:50px;\">logout</button>\n" +
                "        </form>" +
                 "</div>"+
                "<h1 class=\"login\">Login Page</h1>\n" +
                "<h2>Fill Out Your Info</h2>\n" +
                "<form action=\"LoginServlet?cmd=login\" method=\"post\">\n" +
                "  <div class=\"imgcontainer\">\n" +
                "    <img src=\"IMG/cyber.jpg\" alt=\"cyber\" class=\"avatar\">\n" +
                "  </div>\n" +
                "  <div class=\"container\">\n" +
                "    <label for=\"uname\"><b>Email</b></label>\n" +
                "    <input type=\"email\" placeholder=\"Enter Username\" id=\"uname\" name=\"email\" required>\n" +
                "\n" +
                "    <label for=\"psw\"><b>Password</b></label>\n" +
                "    <input type=\"password\" placeholder=\"Enter Password\" id=\"psw\" name=\"password\" required>\n" +
                "    \n" +
                "    <button type=\"submit\" name=\"button11\">Login</button>\n" +
                "    \n" +
                "  </div>\n" +
                "</form>\n" +
                "<footer>\n" +
                "  <div id = \"footer\">\n" +
                "      Sahar Attia <a href=\"https://www.netanya.ac.il/\" target=\"_blank\">Press For Natanya College</a>\n" +
                "  </div>\n" +
                "</footer>\n" +
                "</body>\n" +
                "</html>";
         return res;
     }
    
    public static String MessegePage(String Messege,String username, String MessegeColor, String what_type){
        String name = username;
        if (name.equals("")){
            name = "user";
        }
        String url = "index.html";
        String res = "<!DOCTYPE html>\n" +
                            "<html lang=\"en\">\n" +
                            "<head>\n" +
                            "    <meta charset=\"UTF-8\">\n" +
                            "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                            "    <title>Messages Page</title>\n" +
                            "    <link rel=\"stylesheet\" href=\"CSS/messeges11.css\">\n" +
                            "    <link rel=\"stylesheet\" href=\"CSS/style.css\">\n" +
                            "    <script src=\"JS/allhover.js\" defer></script>\n"
                                                        + "   <script>\n" +
                            "        function moveto(str){\n" +
                            "            if(str==\"prev\"){\n" +
                            "                window.open(window.history.back());\n" +
                            "            }\n" +
                            "            else{\n" +
                            "                window.open(window.history.forward());\n" +
                            "            }\n" +
                            "        }\n" +
                            "    </script>" 
                                                        +
                            "</head>\n" +
                            "<body>\n" +
                            "    <div id=\"header\">\n" +
                            "        <a href=\"index.html\">\n" +
                            "        <img src=\"IMG/logo2.jpg\" alt=\"logo\"></a>\n" +
                            "        <h1>This Is My Site</h1>\n" +
                            "        <h2>Hello " + name + "</h2>\n"
                             + "<form action=\"logOutServlet\" method=\"post\" style=\"padding:0 0 0 0 ; margin:0 0 0 0 ; border:0; background-color: aqua;\">\n" +
                "            <button type=\"submit\" style=\"margin-top:50px;\">logout</button>\n" +
                "        </form>" +
                            "    </div>\n" +
                            "        <div class = \"body\">\n" +
                            "            <h1 class=\"login\">This Is Messages Page</h1>\n" +
                            "            <h2>You have a Messege</h2>\n" +
                            "            <p name=\"messege\" style=\"color: " + MessegeColor + ";\">\n" +
                            "               " +Messege + "<br>";
        
                            if(what_type.equals("back_home")){
                                res+=  "<a href=\"" + url + "\"><button type=\"button\" class=\"registerbtn\">back home</button></a>";
                            }
                            
                            else if(what_type.equals("To_Menu")){
                                res+= "<form action=\"RegisterServlet?cmd=registered\" method=\"post\">\n"+
                            "   <button type=\"submit\" class=\"registerbtn\">Continue To Menu</button>"+
                            "</form>";
                            }
                            else if(what_type.equals("To_Menu_Task")){
                                 res+=   "<form action=\"RegisterServlet?cmd=registered\" method=\"post\">\n"+
                            "   <button type=\"submit\" class=\"registerbtn\">Continue To Menu</button>"+
                            "</form>"+
                            "<form action=\"MenuServlet?cmd=add_task&messege=" + Messege +"\" method=\"post\">\n"+
                            "   <button type=\"submit\" class=\"registerbtn\">to add new task</button>"+
                            "</form>";
                            }     
                            else if(what_type.equals("To_Menu_Task_again")){
                                 res+=   "<form action=\"RegisterServlet?cmd=registered\" method=\"post\">\n"+
                            "   <button type=\"submit\" class=\"registerbtn\">Continue To Menu</button>"+
                            "</form>"+
                                         "<form action=\"MenuServlet?cmd=add_task\" method=\"post\">\n"+
                            "   <button type=\"submit\" class=\"registerbtn\">Try Again</button>"+
                            "</form>";
                            } 
                            else if(what_type.equals("To_Menu_List_again")){
                                 res+=   "<form action=\"RegisterServlet?cmd=registered\" method=\"post\">\n"+
                            "   <button type=\"submit\" class=\"registerbtn\">Continue To Menu</button>"+
                            "</form>"+
                                         "<form action=\"MenuServlet?cmd=add_list\" method=\"post\">\n"+
                            "   <button type=\"submit\" class=\"registerbtn\">Try Again</button>"+
                            "</form>";
                            } 
                            else if(what_type.equals("To_Menu_List")){
                                
                                res+=   "<form action=\"RegisterServlet?cmd=registered\" method=\"post\">\n"+
                            "   <button type=\"submit\" class=\"registerbtn\">Continue To Menu</button>"+
                            "</form>"+
                                         "<form action=\"MenuServlet?cmd=add_list\" method=\"post\">\n"+
                            "   <button type=\"submit\" class=\"registerbtn\">to add new list</button>"+
                            "</form>";
                          }      
                            res+=" </p>\n" +
                            "        </div>\n" +    
                                    "<footer>\n" +
                            "        <div id = \"footer\">\n" +
                            "            Sahar Attia <a href=\"https://www.netanya.ac.il/\" target=\"_blank\">Press For Natanya College</a>\n" +
                            "        </div>\n" +
                            "    </footer>\n" +
                            "</body>\n" +
                            "</html>";
        return res;
        
    }
}
