/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Page.*;
import Page.Login;
import Controller.*;

import java.sql.*;
import javax.swing.*;
/**
 *
 * @author asus
 */
public class Database {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/zoo";
    static final String USER = "root";
    static final String PASS = "";
    
    
    Connection connection;
    Statement statement;

    public Database() {
        try{
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection Success Database");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Connection Failed");
        }
    }
    
    public boolean loginUser(String username, String password){
           try {
            Statement stm = connection.createStatement();
            String query = "select * from pegawai where nama ='"+username+"' and password = '"+password+"'";
            ResultSet resultSet = stm.executeQuery(query);
            String nama = null;

            if(resultSet.next()){             
               nama = resultSet.getString("nama");
//                new menu(nama);
                menuModel model = new menuModel();
                menu view = new menu(nama);
                MenuController controller = new MenuController(model,view);
               return true;               
            }
            else{
             statement.close();
             return false;

            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return false;
        }

    
    }
    public void menu(){
    
}
    
 
}
