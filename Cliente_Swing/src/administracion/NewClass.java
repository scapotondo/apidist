
package administracion;


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
