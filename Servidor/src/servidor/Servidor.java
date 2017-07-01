
package servidor;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import interfaces.*;
import interfaces.AdministracionOrdenesCompra;
import objetosRemotos.*;

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
    	AdministracionOrdenesProduccionInterface adminOrdenesProduccion;
    	AdministracionPedidoInterface adminPedidos;
    	AdministracionAlmacenInterface adminAlmacen;
    	AdministracionUsuariosInterface adminUsuarios;
    	AdministracionOrdenesCompra adminOrdenesCompra;
    	
    	try {
    		
    		LocateRegistry.createRegistry(1099);	
    		
    		adminClientes = new AdministracionClientes();
    		adminPrendas = new AdministracionPrendas();
    		adminProduccion = new AdministracionProduccion();
    		adminOrdenesProduccion = new AdministracionOrdenesProduccion();
    		adminPedidos = new AdministracionPedidos();
    		adminAlmacen = new AdministracionAlmacen();
    		adminUsuarios = new AdministracionUsuarios();
    		adminOrdenesCompra = new objetosRemotos.AdministracionOrdenesCompra();
    		
            Naming.rebind ("//localhost/administracion/clientes", adminClientes);
            System.out.println("Fijado en //localhost/administracion/clientes");
            
            Naming.rebind ("//localhost/administracion/prendas", adminPrendas);
            System.out.println("Fijado en //localhost/administracion/prendas");
            
            Naming.rebind ("//localhost/administracion/produccion", adminProduccion);
            System.out.println("Fijado en //localhost/administracion/produccion");
            
            Naming.rebind ("//localhost/administracion/ordenesProduccion", adminOrdenesProduccion);
            System.out.println("Fijado en //localhost/administracion/ordenesProduccion");
            
            Naming.rebind ("//localhost/administracion/pedidos", adminPedidos);
            System.out.println("Fijado en //localhost/administracion/pedidos");
            
            Naming.rebind ("//localhost/administracion/almacen", adminAlmacen);
            System.out.println("Fijado en //localhost/administracion/almacen");
            
            Naming.rebind ("//localhost/administracion/usuarios", adminUsuarios);
            System.out.println("Fijado en //localhost/administracion/usuarios");

            Naming.rebind ("//localhost/administracion/ordenesCompra", adminOrdenesCompra);
            System.out.println("Fijado en //localhost/administracion/ordenesCompra");

		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}