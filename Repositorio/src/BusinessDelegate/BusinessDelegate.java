package BusinessDelegate;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.ClienteDto;
import dto.SucursalDto;
import interfaces.ClienteInterface;

public class BusinessDelegate {
	private static BusinessDelegate instance;
	private BusinessDelegate(){}
	
	public static BusinessDelegate getInstance(){
		if(instance==null)
			instance= new BusinessDelegate();
		return instance;
	}
	
	public void AltaCliente(float limiteCredito,String formaPago,float cuentaCorriente,String cuit,String nombre, 
			String razonSocial,String telefono, String direccionEnvio,String direccionFacturacion, int nroSucursal ){
	
		try {
			ClienteInterface clienteRemoto=(ClienteInterface)Naming.lookup("//localhost/sucursal/clientes");
			
			SucursalDto sucursal = new SucursalDto();
			sucursal.setNumero(nroSucursal);
			
			ClienteDto cliente = new ClienteDto(limiteCredito, formaPago, cuentaCorriente, cuit, nombre,
					razonSocial, telefono, direccionEnvio, direccionFacturacion, sucursal, new ArrayList<>(),0);
			
			clienteRemoto.AltaCliente(cliente);
			
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
		
		ClienteInterface clienteRemoto;
		
		try {
			
			clienteRemoto = (ClienteInterface)Naming.lookup("//localhost/sucursal/clientes");
			
			return clienteRemoto.BuscarClientes();
			
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
		ClienteInterface clienteRemoto;
		try {
			clienteRemoto = (ClienteInterface)Naming.lookup("//localhost/sucursal/clientes");
			
			String [] partesCadena = cadena.split("-");
			
			String nombreCliente=partesCadena[0];
			
			int legajoCliente= Integer.parseInt(partesCadena[1]);
			
			ClienteDto cliente = new ClienteDto();
			cliente.setLegajo(legajoCliente);
			cliente.setNombre(nombreCliente);
			
			return clienteRemoto.BuscarClientePorId(cliente);
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
		ClienteInterface clienteRemoto;
		
		try {
			clienteRemoto = (ClienteInterface)Naming.lookup("//localhost/sucursal/clientes");
			
			SucursalDto sucursal = new SucursalDto();
			sucursal.setNumero(nroSucursal);
			
			ClienteDto cliente = new ClienteDto(limiteCredito, formaPago, cuentaCorriente, cuit, nombre,
					razonSocial, telefono, direccionEnvio, direccionFacturacion, sucursal, new ArrayList<>(),0);
			cliente.setLegajo(legajo);
			
			clienteRemoto.ModificarCliente(cliente);
			
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
		ClienteInterface clienteRemoto;
		
		try {
			clienteRemoto = (ClienteInterface)Naming.lookup("//localhost/sucursal/clientes");
			
			String [] partes = cadena.split("-");
			String nombre=partes[0];
			int legajo = Integer.parseInt(partes[1]);
			
			ClienteDto cliente = new ClienteDto();
			cliente.setNombre(nombre);
			cliente.setLegajo(legajo);
			
			clienteRemoto.EliminarCliente(cliente);
			
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







