/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;

/**
 *
 * @author jrodk
 */
public class tables {

    public static void main(String[] args) {
        try {
     //       String useTable = "create table user(id int AUTO_INCREMENT primary key,name varchar(200),email varchar(200),mobileNumber varchar(10),address varchar(200),password varchar(200),securityQuestion varchar(200),answer varchar(200),status varchar(20),UNIQUE(email))";
  //        DbOperations.setDataOrDelete(useTable,"User Table created Successfully");
 //           String categoryTable = "create table category(id int AUTO_INCREMENT primary key,name varchar(200))";
   //         String productTable = "create table product(id int AUTO_INCREMENT primary key,name varchar(200),category varchar(200),price varchar(200))";
            String billTable = "create table bill(id int  primary key,name varchar(200),mobileNumber varchar(200), email varchar(200), data varchar(50),total varchar(200), createdBy varchar(200))";
//          DbOperations.setDataOrDelete(productTable,"Product table created Successfully");
//          DbOperations.setDataOrDelete(categoryTable,"Category table created Successfully");
//            String adminDetails = "insert into user(name,email,mobileNumber,address,password,securityQuestion,answer,status) values('admin','admin@gmail.com','1234567890','India','12345','What is your name','moni','true')  ";
 //         DbOperations.setDataOrDelete(adminDetails,"Admin Detail added created Successfully");
            DbOperations.setDataOrDelete(billTable, "Bill Table created Successfully");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

}