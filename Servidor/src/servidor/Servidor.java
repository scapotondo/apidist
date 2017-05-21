package servidor;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import org.hibernate.boot.model.source.spi.SingularAttributeSource;

import interfaces.ClienteInterface;
import objetosRemotos.ClienteRemoto;

public class Servidor {
    
	ClienteRemoto clienteOR;

	
	public static void main(String[] args)
	{
		new Servidor();
	}
	
	public Servidor() {
		iniciar();
	}
	
    public void iniciar() {
    	ClienteInterface clienteRemoto;
    	try {
    		
    		LocateRegistry.createRegistry(1099);	
    		
    		clienteRemoto = new ClienteRemoto();
    		
            Naming.rebind ("//localhost/sucursal/clientes", clienteRemoto);
            System.out.println("Fijado en //localhost/sucursal/clientes");

		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}