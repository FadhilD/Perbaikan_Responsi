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
public class menuHewan extends JFrame {
    JFrame window = new JFrame("Menu Hewan");
    JLabel ltitle = new JLabel("Pilihan Menu");
    public JButton bEdit = new JButton("Edit");
    public JButton bHapus = new JButton("Hapus");
    public JButton bCancel = new JButton("Cancel");
    String id, nama, kelas, jenis;

    public menuHewan(String id, String nama, String kelas, String jenis) {
        this.id = id;
        this.nama = nama;
        this.kelas = kelas;
        this.jenis = jenis;

        window.setSize(300, 200);
        window.setVisible(true);
        window.setLayout(null);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        ltitle.setBounds(100, 10, 100, 25);
        bEdit.setBounds(50, 50, 80, 25);
        bHapus.setBounds(150, 50, 80, 25);
        bCancel.setBounds(50, 100, 185, 40);

        window.add(ltitle);
        window.add(bEdit);
        window.add(bHapus);
        window.add(bCancel);
        
        
        
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getKelas() {
        return kelas;
    }

    public String getJenis() {
        return jenis;
    }

    public void closeWindow() {
        window.dispose();
    }
}
