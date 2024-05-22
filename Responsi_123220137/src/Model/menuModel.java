/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.MenuController;
import Page.menu;
import static Model.Database.JDBC_DRIVER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class menuModel {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/zoo";
    static final String USER = "root";
    static final String PASS = "";
    
    
    Connection connection;
    Statement statement;
    public  String nama;
    
    public menuModel() {       
        try{ 
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection Success Menu");
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Connection Failed");
        }
    }
    
    public void NamaUser(String nama){
                menuModel model = new menuModel();
                menu view = new menu(nama);
                MenuController controller = new MenuController(model,view);
        
   }
    
}
