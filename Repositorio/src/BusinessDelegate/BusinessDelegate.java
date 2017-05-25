package BusinessDelegate;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.ClienteDto;
import dto.SucursalDto;
import interfaces.AdministracionClientesInterface;

public class BusinessDelegate {
	private static BusinessDelegate instance;
	private BusinessDelegate(){}
	
	public static BusinessDelegate getInstance(){
		if(instance==null)
			instance= new BusinessDelegate();
		return instance;
	}
	
	private AdministracionClientesInterface getAdministracionClientes() throws MalformedURLException, RemoteException, NotBoundException {
		return (AdministracionClientesInterface)Naming.lookup("//localhost/administracion/clientes");
	}
	
	public void AltaCliente(float limiteCredito,String formaPago,float cuentaCorriente,String cuit,String nombre, 
			String razonSocial,String telefono, String direccionEnvio,String direccionFacturacion, int nroSucursal ){
	
		try {
			SucursalDto sucursal = new SucursalDto();
			sucursal.setNumero(nroSucursal);
			
			ClienteDto cliente = new ClienteDto(limiteCredito, formaPago, cuentaCorriente, cuit, nombre,
					razonSocial, telefono, direccionEnvio, direccionFacturacion, sucursal, new ArrayList<>(),0);
			
			getAdministracionClientes().AltaCliente(cliente);
			
			//TODO: falta manejo exceptions
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ClienteDto> BuscarClientes(){
		
		try {
			return getAdministracionClientes().BuscarClientes();
			
			//TODO: faltan exceptions
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ClienteDto BuscarClientePorId(String cadena){
		
		try {
			String [] partesCadena = cadena.split("-");
			
			String nombreCliente=partesCadena[0];
			
			int legajoCliente= Integer.parseInt(partesCadena[1]);
			
			ClienteDto cliente = new ClienteDto();
			cliente.setLegajo(legajoCliente);
			cliente.setNombre(nombreCliente);
			
			return getAdministracionClientes().BuscarClientePorId(cliente);
			//TODO: faltan exceptions
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void ModificarCliente(float limiteCredito,String formaPago,float cuentaCorriente,String cuit,String nombre, 
			String razonSocial,String telefono, String direccionEnvio,String direccionFacturacion, int nroSucursal,
			int legajo){
			
		try {
			SucursalDto sucursal = new SucursalDto();
			sucursal.setNumero(nroSucursal);
			
			ClienteDto cliente = new ClienteDto(limiteCredito, formaPago, cuentaCorriente, cuit, nombre,
					razonSocial, telefono, direccionEnvio, direccionFacturacion, sucursal, new ArrayList<>(),0);
			cliente.setLegajo(legajo);
			
			getAdministracionClientes().ModificarCliente(cliente);
			
			//TODO: faltan exceptions
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public void EliminarCliente(String cadena){
				
		try {
			String [] partes = cadena.split("-");
			String nombre=partes[0];
			int legajo = Integer.parseInt(partes[1]);
			
			ClienteDto cliente = new ClienteDto();
			cliente.setNombre(nombre);
			cliente.setLegajo(legajo);
			
			getAdministracionClientes().EliminarCliente(cliente);
			
			//TODO: faltan exceptions
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
}







