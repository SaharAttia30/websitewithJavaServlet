/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaproject;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User implements Serializable, Comparable<User>  {
    private final static String FILE_USERS = "E:\\school\\year3\\A\\programing ahmad\\HW3\\Users\\Users.txt";//לתת מיקום לשמירת קובץ המשתמשים
    private final static String FILE_TASK ="E:\\school\\year3\\A\\programing ahmad\\HW3\\tasks\\";// לתת מיקום לשמירת קבצי המשימות
    
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    
    public User(String email, String password,String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email; 
        this.password = password;
    }
    public boolean changePassword(String new_pass){
        if(this.password.compareTo(new_pass)==0){
            System.out.println("You need to choose new password");
            return false;
        }
        this.password = new_pass;
        return true;
    }
    
    public boolean isPassCorect(String password){
        return this.password.compareTo(password) == 0;
    }
    
    public boolean compareToEmail(String email) {
        return this.email.compareTo(email) == 0;
    }
    public String getEmail(){
        return this.email;
    }
    public String getFirstName(){
        return this.firstName;
    }
    @Override
    public int compareTo(User s) {
        return this.email.compareTo(s.email);        
    }
    
    public static boolean saveUser(User user) {
        ObjectOutputStream oos = null;
        ArrayList<User> al = new ArrayList<User>();
        if(loadUsers() != null){
            al = loadUsers();
        }
        for(int i = 0 ; i < al.size(); i++){
            if(al.get(i).compareToEmail(user.getEmail())){
                System.out.println("User already exists");
                return false;
            }
        }
        al.add(user);
        String name[] = user.getEmail().split("");
        String res_name = "";
        for(int i = 0 ; i < name.length ; i++){
            if(name[i].compareTo("@") == 0){
                break;
            }
            if(i == name.length - 1){
                System.out.println("Please input a valid email");
                return false;
            }
            res_name = res_name + name[i];
        }
        String TASK_FILE = FILE_TASK + res_name + "_tasks.txt";
        ArrayList<taskList> my_list = new ArrayList<taskList>();
        try {
            oos = new ObjectOutputStream(new FileOutputStream(TASK_FILE));
            oos.writeObject(my_list);
            oos.close();
        }
        catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            oos = new ObjectOutputStream(new FileOutputStream(FILE_USERS));
            oos.writeObject(al);
            oos.close();
        }
        catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public static ArrayList<User> loadUsers(){
        ArrayList<User> al = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_USERS));
            al = (ArrayList<User>)ois.readObject();
            return al;
    
        } catch (Exception ex) {
            //Logger.getLogger(Javaproject.class.getName()).log(Level.SEVERE, null, ex);
            return al;
        }
    }
    public static boolean signUp(String email, String password , String firstName,String lastName){
        User user = new User(email, password,firstName,lastName);
        return saveUser(user);
    }
    
    public static User loadUserbyEmail(String email){
        ArrayList<User> al = loadUsers();
        User result = null;
        if(al == null){
            return result;
        }
        for (int i = 0 ; i < al.size(); i++){
            if(al.get(i).compareToEmail(email)){
                result = al.get(i);
                return result;
            }
        }
        return result;
    }
    
    public static boolean signIn(String email, String password){
        User user = loadUserbyEmail(email);
        if(user == null){
            return false;
        }
        return user.isPassCorect(password);
    }
    
}
