package negocio;

import java.util.ArrayList;

import dto.AdministracionDto;
import dto.ClienteDto;
import dto.PedidoPrendasDto;
import dto.PrendaDto;

public class Administracion {
	private static Administracion instance;
	
	public static Administracion getInstance(){
		if (instance == null)
			instance = new Administracion();
		return instance;
	}
	private Administracion() {}
	
	private ArrayList<Cliente> clientes;
	private ArrayList<Prenda> prendas;

	public void generarFacturacion(PedidoPrendas pedido){
		
	}
	
	
	public void AltaCliente(ClienteDto clienteDto, Sucursal sucursal) {
		Cliente cliente = new Cliente(
					clienteDto.getLimiteCredito(),
					clienteDto.getFormaPago(),
					clienteDto.getCuentaCorriente(),
					clienteDto.getCuit(),
					clienteDto.getNombre(),
					clienteDto.getRazonSocial(),
					clienteDto.getTelefono(),
					clienteDto.getDireccionEnvio(),
					clienteDto.getDireccionFacturacion(),
					sucursal
				);
		
		cliente.saveMe();
	}
	
	
	public AdministracionDto toDto(){
		ArrayList<ClienteDto> clientesDto = new ArrayList<>();
		ArrayList<PrendaDto> prendasDto = new ArrayList<>();
		for (Prenda prenda : prendas) {
			prendasDto.add(prenda.toDto());
		}
		for (Cliente cliente : clientes) {
			clientesDto.add(cliente.toDto());
		}
		return new AdministracionDto(clientesDto, prendasDto);
	}
}
