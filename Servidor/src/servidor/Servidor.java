package servidor;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import interfaces.*;
import objetosRemotos.AdministracionClientes;
import objetosRemotos.AdministracionPrendas;
import objetosRemotos.AdministracionProduccion;

public class Servidor {
    
	
	public static void main(String[] args)
	{
		new Servidor();
	}
	
	public Servidor() {
		iniciar();
	}
	
    public void iniciar() {
    	
    	AdministracionClientesInterface adminClientes;
    	AdministracionPrendasInterface adminPrendas;
    	AdministracionProduccionInterface adminProduccion;
    	
    	try {
    		
    		LocateRegistry.createRegistry(1099);	
    		
    		adminClientes = new AdministracionClientes();
    		adminPrendas = new AdministracionPrendas();
    		adminProduccion = new AdministracionProduccion();
    		
            Naming.rebind ("//localhost/administracion/clientes", adminClientes);
            System.out.println("Fijado en //localhost/administracion/clientes");
            
            Naming.rebind ("//localhost/administracion/prendas", adminPrendas);
            System.out.println("Fijado en //localhost/administracion/prendas");
            
            Naming.rebind ("//localhost/administracion/produccion", adminProduccion);
            System.out.println("Fijado en //localhost/administracion/produccion");

		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}