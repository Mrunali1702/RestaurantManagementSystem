/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import javax.swing.JOptionPane;
import java.io.File;

/**
 *
 * @author jrodk
 */
public class OpenPdf {
    public static void openById(String id){
        try{
            String path="C:\\Users\\jrodk\\OneDrive\\Desktop\\pdfs\\Bill";
            String filePath = path + id + ".pdf";
            if ((new File(filePath)).exists()){
                Process p=Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler \"" + filePath + "\"");
            }
            else{
                JOptionPane.showMessageDialog(null,"File is not exists ");
            }
        
        
        
        
        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    
    
    
}
