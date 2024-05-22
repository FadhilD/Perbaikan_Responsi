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
public class TambahHewan extends JFrame {
    JFrame window = new JFrame("Tambah Hewan");
    JLabel lNama = new JLabel("Nama");
    JLabel lKelas = new JLabel("Kelas");
    JLabel lJenis = new JLabel("Jenis Makanan");
    public JTextField tNama = new JTextField();
    public JTextField tKelas = new JTextField();
    public JTextField tJenis = new JTextField();
    public JButton bSave = new JButton("Save");
    public JButton bCancel = new JButton("Cancel");
     String nama;

    public TambahHewan(String nama) {
        this.nama = nama;
        window.setSize(400, 300);
        window.setVisible(true);
        window.setLayout(null);
        window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        window.setLocationRelativeTo(null);

        lNama.setBounds(50, 50, 100, 25);
        lKelas.setBounds(50, 80, 100, 25);
        lJenis.setBounds(50, 110, 100, 25);
        tNama.setBounds(150, 50, 200, 25);
        tKelas.setBounds(150, 80, 200, 25);
        tJenis.setBounds(150, 110, 200, 25);
        bSave.setBounds(150, 150, 80, 25);
        bCancel.setBounds(240, 150, 80, 25);

        window.add(lNama);
        window.add(lKelas);
        window.add(lJenis);
        window.add(tNama);
        window.add(tKelas);
        window.add(tJenis);
        window.add(bSave);
        window.add(bCancel);
    }

        public String getNama() {
        return nama;
    }
    
    public void closeWindow() {
        window.dispose();
    }
    
    
}
