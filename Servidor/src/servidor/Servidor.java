package servidor;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import interfaces.ClienteInterface;
import interfaces.PrendaInterface;
import objetosRemotos.ClienteRemoto;
import objetosRemotos.PrendaRemoto;

public class Servidor {
    
	
	public static void main(String[] args)
	{
		new Servidor();
	}
	
	public Servidor() {
		iniciar();
	}
	
    public void iniciar() {
    	
    	ClienteInterface clienteRemoto;
    	PrendaInterface prendaRemoto;
    	
    	try {
    		
    		LocateRegistry.createRegistry(1099);	
    		
    		clienteRemoto = new ClienteRemoto();
    		prendaRemoto = new PrendaRemoto();
    		
            Naming.rebind ("//localhost/administracion/clientes", clienteRemoto);
            System.out.println("Fijado en //localhost/administracion/clientes");
            
            Naming.rebind ("//localhost/administracion/prendas", prendaRemoto);
            System.out.println("Fijado en //localhost/administracion/prendas");

		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}