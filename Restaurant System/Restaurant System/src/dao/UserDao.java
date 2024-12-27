/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.User;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author jrodk
 */
import java.util.ArrayList;
public class UserDao {

    public static void save(User user) {
        String query = "insert into user (name,email,mobileNumber,address,password,securityQuestion,answer,status) values('" + user.getName() + "','" + user.getEmail() + "','" + user.getMobileNumber() + "','" + user.getAddress() + "','" + user.getPassword() + "','" + user.getSecurityQuestion() + "','" + user.getAnswer() + "','"+"false"+"');";
        DbOperations.setDataOrDelete(query, "Registered Successfully ");        
        
    }

    public static User login(String email, String password) {
        User user = null;
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM user WHERE email='" + email + "' AND password='" + password + "';");
            while (rs.next()) {
                user = new User();
                user.setStatus(rs.getString("status"));
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
        return user;
        
    }
    
    public static User getSecurityQuestion(String email) {
        User user = null;
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM user WHERE email ='" + email + "'");
            while (rs.next()) {
                user = new User();
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            
        }
        return user;
    }
    
    public static void update(String email,String newpassword){
        String query="update user set password = '"+newpassword+"' where email ='"+email+"' ";
        DbOperations.setDataOrDelete(query,"Password changed successfully");
        
    }
    public static ArrayList<User> getAllRecords(String email){
        ArrayList<User> arrayList = new ArrayList<>();
        try{
            ResultSet rs=DbOperations.getData("select * from user where email like '%"+email+"%'");
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setMobileNumber(rs.getString("mobileNumber"));
                user.setAddress(rs.getString("address"));
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setStatus(rs.getString("status"));
                arrayList.add(user);
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static void changeStatus(String email, String status){
        String query = "update user set status ='"+status+"' where email = '"+email+"'";
        DbOperations.setDataOrDelete(query, "Status CHanged Successfully");
    }
}
