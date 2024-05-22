/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.hewanModel;
import Model.menuModel;
import Model.pegawaiModel;
import Page.hewan;
import Page.menu;
import Page.pegawai;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author asus
 */
public class PegawaiController {
pegawai view;
pegawaiModel model;
Object columnName[] = {"ID", "Nama", "Email", "Role"};
    public PegawaiController(pegawaiModel model, pegawai view) {
        this.model = model;
        this.view = view;
        
        if (model.getPegawaiData()!=0) {
            String dataMovie[][] = model.readPegawai();
            view.table.setModel((new JTable(dataMovie, columnName)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "No Data");
        }
        
        view.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);

                int baris = view.table.getSelectedRow();
                 
                String name = view.table.getValueAt(baris, 0).toString();
                String harga = view.table.getValueAt(baris, 2).toString();
                
//                rentModel model = new rentModel(name,harga);
//                RenterDataView view = new RenterDataView();
//                rentController controller = new rentController(model,view);
                
            }

        });
        
       view.bkembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button kembali Pegawai");
                System.out.println(view.getNamaP());
                new MenuController(new menuModel(), new menu(view.getNamaP()));

                view.closeWindow();
            }
        });
        
    }

    
}
