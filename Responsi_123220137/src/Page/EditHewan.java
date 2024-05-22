/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Page;
import javax.swing.*;
/**
 *
 * @author asus
 */
public class EditHewan extends JFrame {
    JFrame window = new JFrame("Edit Hewan");
    JLabel lid = new JLabel("ID");
    JLabel lnama = new JLabel("Nama");
    JLabel lkelas = new JLabel("Kelas");
    JLabel ljenis = new JLabel("Jenis Makanan");
    JTextField tid = new JTextField();
    JTextField tnama = new JTextField();
    JTextField tkelas = new JTextField();
    JTextField tjenis = new JTextField();
    public JButton bSave = new JButton("Save");

    public EditHewan(String id, String nama, String kelas, String jenis) {
        window.setSize(400, 300);
        window.setVisible(true);
        window.setLayout(null);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        lid.setBounds(50, 50, 100, 25);
        lnama.setBounds(50, 80, 100, 25);
        lkelas.setBounds(50, 110, 100, 25);
        ljenis.setBounds(50, 140, 100, 25);
        tid.setBounds(150, 50, 200, 25);
        tnama.setBounds(150, 80, 200, 25);
        tkelas.setBounds(150, 110, 200, 25);
        tjenis.setBounds(150, 140, 200, 25);
        bSave.setBounds(150, 200, 80, 25);

        tid.setText(id);
        tid.setEditable(false);
        tnama.setText(nama);
        tkelas.setText(kelas);
        tjenis.setText(jenis);

        window.add(lid);
        window.add(lnama);
        window.add(lkelas);
        window.add(ljenis);
        window.add(tid);
        window.add(tnama);
        window.add(tkelas);
        window.add(tjenis);
        window.add(bSave);
        
        
        
    }

    public String getId() {
        return tid.getText();
    }

    public String getNama() {
        return tnama.getText();
    }

    public String getKelas() {
        return tkelas.getText();
    }

    public String getJenis() {
        return tjenis.getText();
    }

    public void closeWindow() {
        window.dispose();
    }
}
