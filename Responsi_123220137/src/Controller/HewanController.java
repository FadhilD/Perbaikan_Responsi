/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.hewanModel;
import Model.menuModel;
import Page.*;
import Page.menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author asus
 */
public class HewanController {
hewan view;
hewanModel model;
Object columnName[] = {"ID", "Nama", "Kelas", "Jenis_Makanan"};
    public HewanController(hewanModel model,hewan view) {
        this.model = model;
        this.view = view;
        
         showdata();
        
        
        view.btambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TambahHewan tambahView = new TambahHewan(view.getNamaH());
                new TambahHewanController(tambahView, model);
                view.closeWindow();
            }
        });
        
        view.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);

                int baris = view.table.getSelectedRow();
                String id = view.table.getValueAt(baris, 0).toString();
                String name = view.table.getValueAt(baris, 1).toString();
                String kelas = view.table.getValueAt(baris, 2).toString();
                String jenis = view.table.getValueAt(baris, 3).toString();
                
//                rentModel model = new rentModel(name,harga);
//                RenterDataView view = new RenterDataView();
//                rentController controller = new rentController(model,view);
                menuHewan menuView = new menuHewan(id, name, kelas, jenis);
                new MenuHewanController(menuView, model);
            }

        });
        
        view.bkembali.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button kembali Hewan");
                System.out.println(view.getNamaH());
                new MenuController(new menuModel(), new menu(view.getNamaH()));

               view.closeWindow();
            }
        
        });
        
        view.bCari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = view.tCari.getText();
                String filter = view.cmbCari.getSelectedItem().toString();
                cariData(keyword, filter);
            }
        });
        
        view.bReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showdata();
            }
        });
        
    }
    
public void showdata() {
        if (model.getHewanData() != 0) {
            String dataMovie[][] = model.readHewan();
            view.table.setModel((new JTable(dataMovie, columnName)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "No Data");
        }
    }
   
public void cariData(String keyword, String filter) {
        if (model.getHewanData() != 0) {
            String dataMovie[][] = model.searchHewan(keyword, filter);
            view.table.setModel((new JTable(dataMovie, columnName)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "No Data");
        }
    }

class TambahHewanController {
    TambahHewan view;
    hewanModel model;

    public TambahHewanController(TambahHewan view, hewanModel model) {
        this.view = view;
        this.model = model;

        view.bSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = view.tNama.getText();
                String kelas = view.tKelas.getText();
                String jenis = view.tJenis.getText();

                if (nama.isEmpty() || 
                    kelas.isEmpty() || 
                    jenis.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Data tidak boleh kosong!");
                } else {
                    model.tambahHewan(nama, kelas, jenis);
                    view.closeWindow();
                    JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
                    new HewanController(new hewanModel(), new hewan(view.getNama()));
                    showdata();
                }
            }
        });

        view.bCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.closeWindow();
                new HewanController(new hewanModel(), new hewan(view.getNama()));
            }
        });
    }
}
    
    
    class MenuHewanController {
    menuHewan view;
    hewanModel model;

    public MenuHewanController(menuHewan view, hewanModel model) {
        this.view = view;
        this.model = model;

        view.bEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditHewan editView = new EditHewan(view.getId(), view.getNama(), view.getKelas(), view.getJenis());
                new EditHewanController(editView, model);
                view.closeWindow();
            }
        });

        view.bHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HapusHewan hapusView = new HapusHewan(view.getId());
                new HapusHewanController(hapusView, model);
                view.closeWindow();
            }
        });
        
        view.bCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.closeWindow();

            }
        });
        
    }
}

class EditHewanController {
    EditHewan view;
    hewanModel model;

    public EditHewanController(EditHewan view, hewanModel model) {
        this.view = view;
        this.model = model;

        view.bSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.updateHewan(view.getId(), view.getNama(), view.getKelas(), view.getJenis());
                view.closeWindow();
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
                showdata();
            }
        });
    }
}

class HapusHewanController {
    HapusHewan view;
    hewanModel model;

    public HapusHewanController(HapusHewan view, hewanModel model) {
        this.view = view;
        this.model = model;

        view.bYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.deleteHewan(view.getId());
                view.closeWindow();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            }
        });

        view.bNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.closeWindow();
            }
        });
        
    
        
    }
}
    
}
