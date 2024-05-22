/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.hewanModel.JDBC_DRIVER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class pegawaiModel {
static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/zoo";
    static final String USER = "root";
    static final String PASS = "";
    
    
    Connection connection;
    Statement statement;
    public  String nama;
    
    public pegawaiModel() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection Success pegawai");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Connection Failed");
        }
    }

    public int getPegawaiData() {
        try {
            int totalData = 0;
            String query = "SELECT id, nama, email, role FROM pegawai";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                totalData++;
            }
            statement.close();
            return totalData;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return 0;
        }
    }

    public String[][] readPegawai() {
        try {
            int totalData = 0;
            String data[][] = new String[getPegawaiData()][4];
            String query = "SELECT id, nama, email, role FROM pegawai";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                data[totalData][0] = resultSet.getString("id");
                data[totalData][1] = resultSet.getString("nama");
                data[totalData][2] = resultSet.getString("email");
                data[totalData][3] = resultSet.getString("role");
                totalData++;
            }
            statement.close();
            return data;
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
            return null;
        }
    }
}
