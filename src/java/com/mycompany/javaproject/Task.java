package com.mycompany.javaproject;
import jakarta.servlet.ServletException;
import java.io.*;
import java.util.ArrayList;

public class Task implements Serializable{
    public String taskName;
    public String taskDetails;
    public String date;
    public int priority;
    public boolean isDone;
     private final static String FILE_USERS = "E:\\school\\year3\\A\\programing ahmad\\HW1\\Users\\Users.txt";//לתת מיקום לשמירת קובץ המשתמשים
    private final static String FILE_TASK ="E:\\school\\year3\\A\\programing ahmad\\HW1\\tasks\\";// לתת מיקום לשמירת קבצי המשימות
    public static int global_int = 0;
    
    public static taskList getTaskList(String list, ArrayList<taskList> my_list){
        taskList res_list = null;
        int i;
        for(i = 0; i < my_list.size() ; i++){
            if(my_list.get(i).listName.compareTo(list)==0){
                res_list = my_list.get(i);
                break;
            }
        }
        global_int = i;
        return res_list;
    }
    public static String add_task(String email, String Uname, String list ,String taskname,String taskdetails, String taskpriority, boolean isdone, String endDate)
            throws ServletException, IOException {
        String TASK_FILE = FILE_TASK + Uname + "_tasks.txt";
        ArrayList<taskList> my_list = taskList.getlists(TASK_FILE);
        String res = "";
        taskList res_list = getTaskList(list, my_list);
        
        if(res_list == null){
            res += "; There is no List under that name, Creating new list named "+ list;
            taskList tasklist = new taskList(list);
            my_list.add(tasklist);
            taskList.writeList(my_list, TASK_FILE);
            res += "; List "+ list + " was added successfully";
        }
        for(int i = 0 ; i < my_list.get(global_int).yourList.size() ; i++){
            if(my_list.get(global_int).yourList.get(i).taskName.equals(taskname)){
                return "false";
            }
        }
        Task temptask = new Task(taskname,taskdetails,Integer.parseInt(taskpriority), isdone,endDate);
        my_list.get(global_int).yourList.add(temptask);
        my_list.get(global_int).sortlist();
        taskList.writeList(my_list, TASK_FILE);
        res += "; Task "+ taskname + " was added successfully";
        return res;
    }
    
    public Task(String taskname, String taskdetails, int priority, boolean isdone, String Date){
        this.taskName = taskname;
        this.taskDetails = taskdetails;
        this.priority = priority;
        this.isDone = isdone;
        this.date = Date;
    }
    
     public static void tasksAction(User user){
        String name[] = user.getEmail().split("");
        String res_name = "";
        for(int i = 0 ; i < name.length ; i++){
            if(name[i].compareTo("@") == 0){
                break;
            }
            res_name = res_name + name[i];
        }
     }
    public void swap(Task t){
        if (t==null){
            return;
        }
        String temptaskName = this.taskName;
        String temptaskDetails= this.taskDetails;
        int temppriority = this.priority;
        boolean tempisDone= this.isDone;
        this.taskName = t.taskName;
        this.taskDetails = t.taskDetails;
        this.priority = t.priority;
        this.isDone = t.isDone;
        t.taskName = temptaskName;
        t.taskDetails = temptaskDetails;
        t.priority = temppriority;
        t.isDone = tempisDone;  
    }
    
    public void setDone(){
        this.isDone = true;
    }
    
    public int getpriority(){
        return this.priority;
    }
    
    @Override
    public String toString() {
        return "The task priority is: " + this.priority + "\nThe task name is: " + this.taskName + " \nThe task details are: \n" + this.taskDetails + "\n" + "Is done: " + this.isDone + "\n" + "End date is: " + this.date +"\n -----------------------------------------";
    }
}
