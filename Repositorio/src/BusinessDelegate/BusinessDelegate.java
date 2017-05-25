package BusinessDelegate;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.*;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw new RemoteObjectNotFoundException("No se pudo encontrar Administracion de Clientes");
		}
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
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (RemoteObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<ClienteDto> BuscarClientes(){
		
		try {
			return getAdministracionClientes().BuscarClientes();
			
			//TODO: faltan exceptions
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (RemoteObjectNotFoundException e) {
			// TODO Auto-generated catch block
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
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (RemoteObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void ModificarCliente(float limiteCredito,String formaPago,float cuentaCorriente,String cuit,String nombre, 
			String razonSocial,String telefono, String direccionEnvio,String direccionFacturacion, int nroSucursal,
			int legajo) {
			
		try {
			SucursalDto sucursal = new SucursalDto();
			sucursal.setNumero(nroSucursal);
			
			ClienteDto cliente = new ClienteDto(limiteCredito, formaPago, cuentaCorriente, cuit, nombre,
					razonSocial, telefono, direccionEnvio, direccionFacturacion, sucursal, new ArrayList<>(),0);
			cliente.setLegajo(legajo);
			
			getAdministracionClientes().ModificarCliente(cliente);
			
			//TODO: faltan exceptions
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (RemoteObjectNotFoundException e) {
			// TODO Auto-generated catch block
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
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (RemoteObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private AdministracionPrendasInterface getAdministracionPrendas() throws RemoteObjectNotFoundException {
		try {
			return (AdministracionPrendasInterface)Naming.lookup("//localhost/administracion/prendas");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw new RemoteObjectNotFoundException("No se pude encontrar Administracion de Prendas");
		}
	}
	
	//TODO: no le tendriamos que pasar el DTO desde la Vista directamente? Como hacemos con las listas sino (por ej Confecciones)?
	//TODO: las exceptions no las deberia catchear la vista directamente?
	public void AltaPrenda (ArrayList<String> tallesValidos, ArrayList<String> coloresValidos, boolean esDiscontinuo, int cantidadAProducir, String nombre, String descripcion, float porsentajeGanancia, ArrayList<ConfeccionDto> confecciones) {
		PrendaDto prendaDto = new PrendaDto(tallesValidos, coloresValidos, 0, esDiscontinuo, cantidadAProducir, nombre, descripcion, porsentajeGanancia, confecciones, new ArrayList<StockPrendaDto>());
		
		try {
			getAdministracionPrendas().AltaPrenda(prendaDto);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void EliminarPrenda (int codigo) {
		try {
			getAdministracionPrendas().EliminarPrenda(new PrendaDto(codigo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ModificarPrenda (int codigo, ArrayList<String> tallesValidos, ArrayList<String> coloresValidos, boolean esDiscontinuo, int cantidadAProducir, String nombre, String descripcion, float porsentajeGanancia, ArrayList<ConfeccionDto> confecciones) {
		PrendaDto prendaDto = new PrendaDto(tallesValidos, coloresValidos, codigo, esDiscontinuo, cantidadAProducir, nombre, descripcion, porsentajeGanancia, confecciones, new ArrayList<StockPrendaDto>());
		
		try {
			getAdministracionPrendas().ModificarPrenda(prendaDto);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<PrendaDto> getPrendas() {
		try {
			return getAdministracionPrendas().BuscarPrendas();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ArrayList<PrendaDto>();
	}
	
	public PrendaDto buscarPrendaPorCodigo (int codigo) {
		try {
			getAdministracionPrendas().BuscarPrendaPorId(new PrendaDto(codigo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}







