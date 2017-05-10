/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

/**
 *
 * @author javiercapotondo
 */
public class NewClass {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainAdministracion ma= new MainAdministracion();
                ma.setLocationRelativeTo(null);
                ma.setVisible(true);
            }
        });

    }
}
