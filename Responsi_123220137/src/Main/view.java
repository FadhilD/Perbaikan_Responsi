/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.LoginController;
import Model.Database;
import Page.Login;

/**
 *
 * @author Lab Informatika
 */
public class view {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        new Login();
        Database model = new Database();
        Login view = new Login();
        LoginController controller = new LoginController(model,view);
    }
    
}
