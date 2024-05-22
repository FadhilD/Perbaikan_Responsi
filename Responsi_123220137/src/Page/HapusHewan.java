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
public class HapusHewan extends JFrame {
    JFrame window = new JFrame("Hapus Hewan");
    JLabel lconfirm = new JLabel("Apakah Anda yakin ingin menghapus?");
    public JButton bYes = new JButton("Yes");
    public JButton bNo = new JButton("No");
    String id;

    public HapusHewan(String id) {
        this.id = id;
        
        window.setSize(300, 200);
        window.setVisible(true);
        window.setLayout(null);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        lconfirm.setBounds(50, 50, 200, 25);
        bYes.setBounds(50, 100, 80, 25);
        bNo.setBounds(150, 100, 80, 25);

        window.add(lconfirm);
        window.add(bYes);
        window.add(bNo);
        
        
        
    }

    public String getId() {
        return id;
    }

    public void closeWindow() {
        window.dispose();
    }
}
