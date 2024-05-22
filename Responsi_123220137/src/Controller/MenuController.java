/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import Page.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class MenuController {
    menuModel model;
    menu view;
    
    public MenuController(menuModel model,menu view ) {
        
        
        view.blogout.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            System.out.println("button logout");
            Database model = new Database();
            Login lview = new Login();
            LoginController controller = new LoginController(model,lview);
            view.dispose();                     
            }       
        }); 
  
            view.bhewan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            System.out.println("button hewan");
//            view.dispose();
            System.out.println("clear menu");
            String username = view.GetNama(); 
            System.out.println("ini nama dari MC:"+username);
//            model.NamaUser(username);       
            hewanModel model = new hewanModel();
            hewan hview = new hewan(username);
            HewanController controller = new HewanController(model,hview);
            view.dispose();
            }       
        }); 
  
                    view.bpegawai.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
//            System.out.println("button pegawai");
//            view.dispose();
//            System.out.println("clear menu");
            String username = view.GetNama();   
//            System.out.println("ini nama dari MC:"+username);
//            model.NamaUser(username);       
            pegawaiModel model = new pegawaiModel();
            pegawai pview = new pegawai(username);
            PegawaiController controller = new PegawaiController(model,pview);
            view.dispose();                   
            }       
        }); 
  
    
}
}
