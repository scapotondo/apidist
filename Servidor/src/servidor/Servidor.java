package servidor;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

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
    	try {
    		LocateRegistry.createRegistry(1099);	
    		clienteOR =new ClienteRemoto();

            Naming.rebind ("//localhost/sucursal/clientes", clienteOR);
            System.out.println("Fijado en //localhost/sucursal/clientes");

		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}