
package clientes;

import java.util.ArrayList;

import dao.SucursalDao;
import dto.SucursalDto;

public class NewClass {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	SucursalDto sucursal = new SucursalDto(1, "suc1", "direccion", new ArrayList<>(), null, new ArrayList<>(), new ArrayList<>());
            	SucursalDao.getInstance().altaSucursal(sucursal);
            	
                MainAdministracion ma= new MainAdministracion();
                ma.setLocationRelativeTo(null);
                ma.setVisible(true);
                
                
            }
        });

    }
}
