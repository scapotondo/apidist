package controller;

import java.util.ArrayList;

import dto.ClienteDto;
import dto.SucursalDto;
import objetosRemotos.ClienteRemoto;

public class ControllerSwing {
	private static ControllerSwing instance;
	private ControllerSwing(){}
	
	public static ControllerSwing getInstance(){
		if(instance==null)
			instance= new ControllerSwing();
		return instance;
	}
	
	public void AltaCliente(float limiteCredito,String formaPago,float cuentaCorriente,String cuit,String nombre, 
			String razonSocial,String telefono, String direccionEnvio,String direccionFacturacion, int nroSucursal ){
		
		SucursalDto sucursal = new SucursalDto();
		sucursal.setNumero(nroSucursal);
		ClienteDto cliente = new ClienteDto(limiteCredito, formaPago, cuentaCorriente, cuit, nombre,
				razonSocial, telefono, direccionEnvio, direccionFacturacion, sucursal, new ArrayList<>(),0);
		
		ClienteRemoto.getInstance().AltaCliente(cliente);
	}
	
	public ArrayList<ClienteDto> BuscarClientes(){
		return ClienteRemoto.getInstance().BuscarClientes();
	}
	
	public ClienteDto BuscarClientePorId(String cadena){
		String [] partesCadena = cadena.split("-");
		String nombreCliente=partesCadena[0];
		int legajoCliente= Integer.parseInt(partesCadena[1]);
		ClienteDto cliente = new ClienteDto();
		cliente.setLegajo(legajoCliente);
		cliente.setNombre(nombreCliente);
		return ClienteRemoto.getInstance().BuscarClientePorId(cliente);
	}
	
	public void ModificarCliente(float limiteCredito,String formaPago,float cuentaCorriente,String cuit,String nombre, 
			String razonSocial,String telefono, String direccionEnvio,String direccionFacturacion, int nroSucursal,
			int legajo){
		
		SucursalDto sucursal = new SucursalDto();
		sucursal.setNumero(nroSucursal);
		
		ClienteDto cliente = new ClienteDto(limiteCredito, formaPago, cuentaCorriente, cuit, nombre,
				razonSocial, telefono, direccionEnvio, direccionFacturacion, sucursal, new ArrayList<>(),0);
		cliente.setLegajo(legajo);
		
		ClienteRemoto.getInstance().ModificarCliente(cliente);
	}
	
	public void EliminarCliente(String cadena){
		String [] partes = cadena.split("-");
		String nombre=partes[0];
		int legajo = Integer.parseInt(partes[1]);
		
		ClienteDto cliente = new ClienteDto();
		cliente.setNombre(nombre);
		cliente.setLegajo(legajo);
		
		ClienteRemoto.getInstance().EliminarCliente(cliente);
	}
	
}







