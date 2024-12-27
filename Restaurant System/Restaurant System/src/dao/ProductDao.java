/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.util.ArrayList;
import model.Product;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author jrodk
 */
public class ProductDao {
    
    public static void save(Product product){
        String query = "INSERT INTO product(name, category, price) VALUES ('" 
                + product.getName() + "', '" 
                + product.getCategory() + "', " 
                + product.getPrice() + ")";
        DbOperations.setDataOrDelete(query,"Product added successfully");
        
        
        
        
    }
    public static ArrayList<Product>getAllRecords(){
        ArrayList<Product> arrayList=new ArrayList();
        try{
            ResultSet rs =DbOperations.getData("select * from product;");
            
            while(rs.next()){
                Product product=new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setName(rs.getString("category"));
                product.setName(rs.getString("price"));
                
                arrayList.add(product);
                
                
            }
        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        } 
        
        return arrayList;
        
    }
    
    public static void update(Product product){
        String query="update product set name ='"+product.getName()+"','"+product.getCategory()+"','"+product.getPrice()+"' where id = '"+product.getId()+"' ;";
        DbOperations.setDataOrDelete(query,"Product update successfully");
        
    }
    public static void delete(Product product){
        String query="delete from product where id = '"+product.getId()+"' ;";
        DbOperations.setDataOrDelete(query,"Product deleted successfully");
        
    }

    public static void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static ArrayList<Product> getAllRecordsByCategory(String category){
        ArrayList<Product> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select * from product where category='"+category+"'");
            while(rs.next()){
               Product product = new Product();
               product.setName(rs.getString("name"));
               arrayList.add(product);
            }
        }       
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return arrayList;
    }
        public static ArrayList<Product> filterProductByname(String name,String category){
        ArrayList<Product> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select * from product where name like '%"+name+"%'and category='"+category+"'");
            while(rs.next()){
               Product product = new Product();
               product.setName(rs.getString("name"));
               arrayList.add(product);
            }
        }       
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return arrayList;   
    }
        
        public static Product getProductByname(String name){
          Product product = new Product();
          try{
              ResultSet rs = DbOperations.getData("select * from product where name='"+name+"'");
              while (rs.next()){
                  product.setName(rs.getString(2));
                  product.setCategory(rs.getString(3));
                  product.setPrice(rs.getString(4));
              }
          }
          catch (Exception e){
              JOptionPane.showMessageDialog(null, e);
          }
          return product;
        }
}
