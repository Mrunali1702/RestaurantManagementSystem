/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import model.Bill;

/**
 *
 * @author jrodk
 */
public class BillDao {
    public static String getId(){
        int id = 1;
        try{
            ResultSet rs = DbOperations.getData("select max(id) from bill");
            if (rs.next()){
                id = rs.getInt(1);
                id = id + 1;
            }
        }
        catch (Exception e) {
          JOptionpane.showMessageDialog(null,e);
        }
        return String.valueOf(id);
    }
    public static void save(Bill bill){
      String query = "INSERT INTO bill (id, name, mobileNumber, email, data, total, createdBy) VALUES ('" 
                + bill.getId() + "', '" 
                + bill.getName() + "', '" 
                + bill.getMobileNumber() + "', '" 
                + bill.getEmail() + "', '" 
                + bill.getDate()+ "', '" 
                + bill.getTotal() + "', '" 
                + bill.getCreatedBy()+ "')";
        DbOperations.setDataOrDelete(query, "Bill Details Added Successfully");
    }
}
