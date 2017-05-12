
package administracion;

import java.util.ArrayList;

import dao.SucursalDao;
import dto.SucursalDto;
import hibernate.HibernateUtil;

public class NewClass {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
            	//HibernateUtil.datos();
                
            	MainAdministracion ma= new MainAdministracion();
                ma.setLocationRelativeTo(null);
                ma.setVisible(true);
                
                
            }
        });

    }
}
