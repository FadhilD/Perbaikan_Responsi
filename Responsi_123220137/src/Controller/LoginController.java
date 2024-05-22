/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Page.Login;
import Model.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author asus
 */
public class LoginController {
    Database model;
    Login view;

    public LoginController(Database model, Login view) {
        this.model = model;
        this.view = view;
    
        view.blogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               System.out.println("button klik");
               String username = view.GetUsername();
               String password = view.GetPassword();
               boolean berhasil = model.loginUser(username,password);
                if (!berhasil) {
                    JOptionPane.showMessageDialog(view, "Username or password salah");
                    view.tuser.setText("");
                    view.tpass.setText("");
               
               
            }else{
                    view.dispose();
                }
               
               
            }
        
        });
    }
    
}
