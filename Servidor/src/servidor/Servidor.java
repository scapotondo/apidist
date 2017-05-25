package servidor;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import interfaces.*;
import objetosRemotos.AdministracionClientes;
import objetosRemotos.AdministracionPrendas;

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
    	
    	try {
    		
    		LocateRegistry.createRegistry(1099);	
    		
    		adminClientes = new AdministracionClientes();
    		adminPrendas = new AdministracionPrendas();
    		
            Naming.rebind ("//localhost/administracion/clientes", adminClientes);
            System.out.println("Fijado en //localhost/administracion/clientes");
            
            Naming.rebind ("//localhost/administracion/prendas", adminPrendas);
            System.out.println("Fijado en //localhost/administracion/prendas");

		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}