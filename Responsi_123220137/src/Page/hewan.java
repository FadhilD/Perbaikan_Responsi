/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Page;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Lab Informatika
 */
public class hewan extends JFrame {
      JFrame window = new JFrame("Pegawai");
     JLabel ltitle = new JLabel("Selamat Datang");

     
     String []columnNames = {"ID","Nama","Kelas","Jenis"};
      String[][]data=new String[100][5];
     
      DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);
    public JTable table = new JTable(tableModel);
    public JScrollPane sp = new JScrollPane(table);
     public JButton bkembali = new JButton("Kembali");
     public JButton btambah = new JButton("Tambah");
     public JButton bedit = new JButton("Edit (Klik Pada Tabel)");
     public JButton bhapus = new JButton("Hapus (Klik Pada Tabel)");
    public JLabel lCari = new JLabel("Search by :");
    public JComboBox<String> cmbCari = new JComboBox<>(new String[]{"Nama", "Kelas", "Jenis Makanan"});
    public JTextField tCari = new JTextField();
    public JButton bCari = new JButton("Cari");
    public JButton bReset = new JButton("Reset");
    String nama;

    public hewan(String nama) {
        this.nama = nama;
        window.setSize(700, 700);
        window.setVisible(true);
        window.setLayout(null);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        
        window.add(sp);
        window.add(bkembali);
        window.add(btambah);
        window.add(bedit);
        window.add(bhapus);
        window.add(lCari);
        window.add(cmbCari);
        window.add(tCari);
        window.add(bCari);
        window.add(bReset);
        
        sp.setBounds(20, 35, 650, 250);
        lCari.setBounds(20, 300, 80, 25);
        cmbCari.setBounds(100, 300, 150, 25);
        tCari.setBounds(260, 300, 200, 25);
        bCari.setBounds(470, 300, 80, 25);
        bReset.setBounds(580, 300, 80, 25);
        bkembali.setBounds(20, 340, 650, 50);
        btambah.setBounds(20, 410, 650, 50);
        bedit.setBounds(20, 480, 650, 50);
        bhapus.setBounds(20, 550, 650, 50);
    }
    
    public String getNamaH() {
        return nama;
    }
    
    public void closeWindow() {
        window.dispose();
    }
    
    public String getcari() {
        return tCari.getText();
    }
    
    public String getcmb() {
        return cmbCari.getSelectedItem().toString();
    }
}
