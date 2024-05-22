/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.menuModel.JDBC_DRIVER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class hewanModel {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/zoo";
    static final String USER = "root";
    static final String PASS = "";
    
    
    Connection connection;
    Statement statement;
    public  String nama;
    
    public hewanModel() {
        try{ 
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection Success hewan");
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Connection Failed");
        }
    }
    
        public int getHewanData(){
        try {
            int totalData = 0;
            String query = "SELECT * FROM `hewan`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                totalData++;
            }
            statement.close();
            return totalData;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return 0;
        }
    }
        public String[][] readHewan(){
        try{
            int totalData = 0;
            
            String data[][] = new String[getHewanData()][4];
            
            String query = "SELECT * FROM `hewan`"; 
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[totalData][0] = resultSet.getString("id");
                data[totalData][1] = resultSet.getString("nama");                
                data[totalData][2] = resultSet.getString("kelas");
                data[totalData][3] = resultSet.getString("jenis_makanan");
                totalData++;
            }
            statement.close();
            return data;
               
        }catch(SQLException e){
            System.out.println("Error : " + e.getMessage());
            return null;
        }
    }
        
   public void tambahHewan(String nama, String kelas, String jenis) {
        try {
            String query = "INSERT INTO hewan (nama, kelas, jenis_makanan) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, kelas);
            preparedStatement.setString(3, jenis);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }        
        
        
     public void updateHewan(String id, String nama, String kelas, String jenis) {
        try {
            String query = "UPDATE `hewan` SET `nama` = '" + nama + "', `kelas` = '" + kelas + "', `jenis_makanan` = '" + jenis + "' WHERE `id` = '" + id + "'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public void deleteHewan(String id) {
        try {
            String query = "DELETE FROM `hewan` WHERE `id` = '" + id + "'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
public String[][] searchHewan(String keyword, String filter) {
    try {
        String query = "";
        if (filter.equals("Nama")) {
            query = "SELECT * FROM hewan WHERE nama LIKE ?";
        } else if (filter.equals("Kelas")) {
            query = "SELECT * FROM hewan WHERE kelas LIKE ?";
        } else if (filter.equals("Jenis Makanan")) {
            query = "SELECT * FROM hewan WHERE jenis_makanan LIKE ?";
        }

        PreparedStatement preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        preparedStatement.setString(1, "%" + keyword + "%");
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.last(); // Move to the last row to get the total number of rows
        int totalData = resultSet.getRow();
        resultSet.beforeFirst(); // Move back to the start of the result set

        String data[][] = new String[totalData][4];
        int index = 0;
        while (resultSet.next()) {
            data[index][0] = resultSet.getString("id");
            data[index][1] = resultSet.getString("nama");
            data[index][2] = resultSet.getString("kelas");
            data[index][3] = resultSet.getString("jenis_makanan");
            index++;
        }
        resultSet.close();
        preparedStatement.close();
        return data;
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
        return null;
    }
}


    
}
