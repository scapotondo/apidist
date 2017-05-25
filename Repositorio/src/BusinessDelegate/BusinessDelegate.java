package BusinessDelegate;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.*;
import exceptions.ApplicationException;
import exceptions.RemoteObjectNotFoundException;
import interfaces.*;

public class BusinessDelegate {
	private static BusinessDelegate instance;
	private BusinessDelegate(){}
	
	public static BusinessDelegate getInstance(){
		if(instance==null)
			instance= new BusinessDelegate();
		return instance;
	}
	
	private AdministracionClientesInterface getAdministracionClientes() throws RemoteObjectNotFoundException {
		try {
			return (AdministracionClientesInterface)Naming.lookup("//localhost/administracion/clientes");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw new RemoteObjectNotFoundException("No se pudo encontrar Administracion de Clientes");
		}
	}
	
	public void AltaCliente(float limiteCredito,String formaPago,float cuentaCorriente,String cuit,String nombre, 
			String razonSocial,String telefono, String direccionEnvio,String direccionFacturacion, int nroSucursal ) throws RemoteObjectNotFoundException, ApplicationException{
	
		try {
			SucursalDto sucursal = new SucursalDto();
			sucursal.setNumero(nroSucursal);
			
			ClienteDto cliente = new ClienteDto(limiteCredito, formaPago, cuentaCorriente, cuit, nombre,
					razonSocial, telefono, direccionEnvio, direccionFacturacion, sucursal, new ArrayList<>(),0);
			
			getAdministracionClientes().AltaCliente(cliente);
			
			//TODO: falta manejo exceptions
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}
	
	public ArrayList<ClienteDto> BuscarClientes() throws RemoteObjectNotFoundException, ApplicationException{
		
		try {
			return getAdministracionClientes().BuscarClientes();
			
			//TODO: faltan exceptions
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}
	
	public ClienteDto BuscarClientePorId(String cadena) throws RemoteObjectNotFoundException, ApplicationException{
		
		try {
			String [] partesCadena = cadena.split("-");
			
			String nombreCliente=partesCadena[0];
			
			int legajoCliente= Integer.parseInt(partesCadena[1]);
			
			ClienteDto cliente = new ClienteDto();
			cliente.setLegajo(legajoCliente);
			cliente.setNombre(nombreCliente);
			
			return getAdministracionClientes().BuscarClientePorId(cliente);
			//TODO: faltan exceptions
			
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}
	
	public void ModificarCliente(float limiteCredito,String formaPago,float cuentaCorriente,String cuit,String nombre, 
			String razonSocial,String telefono, String direccionEnvio,String direccionFacturacion, int nroSucursal,
			int legajo) throws RemoteObjectNotFoundException, ApplicationException {
			
		try {
			SucursalDto sucursal = new SucursalDto();
			sucursal.setNumero(nroSucursal);
			
			ClienteDto cliente = new ClienteDto(limiteCredito, formaPago, cuentaCorriente, cuit, nombre,
					razonSocial, telefono, direccionEnvio, direccionFacturacion, sucursal, new ArrayList<>(),0);
			cliente.setLegajo(legajo);
			
			getAdministracionClientes().ModificarCliente(cliente);
			
			//TODO: faltan exceptions
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}
	
	public void EliminarCliente(String cadena) throws RemoteObjectNotFoundException, ApplicationException{
				
		try {
			String [] partes = cadena.split("-");
			String nombre=partes[0];
			int legajo = Integer.parseInt(partes[1]);
			
			ClienteDto cliente = new ClienteDto();
			cliente.setNombre(nombre);
			cliente.setLegajo(legajo);
			
			getAdministracionClientes().EliminarCliente(cliente);
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}
	
	private AdministracionPrendasInterface getAdministracionPrendas() throws RemoteObjectNotFoundException {
		try {
			return (AdministracionPrendasInterface)Naming.lookup("//localhost/administracion/prendas");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw new RemoteObjectNotFoundException("No se pude encontrar Administracion de Prendas");
		}
	}
	
	public void AltaPrenda (PrendaDto prendaDto) throws RemoteObjectNotFoundException, ApplicationException {
		try {
			getAdministracionPrendas().AltaPrenda(prendaDto);
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}
	
	public void EliminarPrenda (PrendaDto prendaDto) throws RemoteObjectNotFoundException, ApplicationException {
		try {
			getAdministracionPrendas().EliminarPrenda(prendaDto);
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}
	
	public void ModificarPrenda (PrendaDto prendaDto) throws RemoteObjectNotFoundException, ApplicationException {
		try {
			getAdministracionPrendas().ModificarPrenda(prendaDto);
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}
	
	public ArrayList<PrendaDto> getPrendas() throws RemoteObjectNotFoundException, ApplicationException {
		try {
			return getAdministracionPrendas().BuscarPrendas();
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}
	
	public PrendaDto buscarPrendaPorCodigo (PrendaDto prendaDto) throws RemoteObjectNotFoundException, ApplicationException {
		try {
			return getAdministracionPrendas().BuscarPrendaPorNumero(prendaDto);
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}
}







