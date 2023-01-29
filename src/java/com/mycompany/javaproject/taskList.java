package com.mycompany.javaproject;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class taskList implements Serializable, Comparable<taskList>{
    public String listName;
    public ArrayList<Task> yourList;
    public taskList(String listname){
        this.listName = listname;
        yourList = new ArrayList<Task>();
    }
    
    @Override
    public int compareTo(taskList s) {
        return this.listName.compareTo(s.listName); 
    }
      public static ArrayList<taskList> getlists(String location){
       
        ArrayList<taskList> my_list = new ArrayList<taskList>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(location));
            my_list = (ArrayList<taskList>)ois.readObject();
        } 
        catch (Exception ex) {
            return my_list;
            //Logger.getLogger(Javaproject.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return my_list;
    }
    
    public static void writeList(ArrayList<taskList> my_list, String location){
        ObjectOutputStream oos = null;
        String TASK_FILE = location;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(TASK_FILE));
            oos.writeObject(my_list);
            oos.close();
        }
        catch (Exception ex) {
            Logger.getLogger(taskList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void sortlist(){
        for(int i = 0 ; i < this.yourList.size()-1 ; i++){
            for(int j = i + 1 ; j < this.yourList.size()  ; j++){
                if (this.yourList.get(i).getpriority() > this.yourList.get(j).getpriority()){
                    this.yourList.get(i).swap(this.yourList.get(j));
                }
            }
        }
    }
   
    @Override
    public String toString() {
        String str = "Name of list is: " + listName + "\n-----------------------------------------\n";
        for(int i = 0 ; i < this.yourList.size() ; i++){
            str = str + "Task number " + (i+1) + ":\n" + this.yourList.get(i).toString() + "\n";
        }
        return str;
    }  
}
