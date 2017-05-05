package negocio;

import java.util.ArrayList;

import dto.AdministracionDto;
import dto.ClienteDto;
import dto.PedidoPrendasDto;
import dto.PrendaDto;

public class Administracion {
	private ArrayList<Cliente> clientes;
	private ArrayList<Prenda> prendas;

	public Administracion(ArrayList<Cliente> clientes,ArrayList<Prenda> prendas){
		this.clientes=clientes;
		this.prendas=prendas;
	} 
	public void generarFacturacion(PedidoPrendas pedido){
		
	}
	
	public void altaCliente(float limiteCredito,String formaPago, float cuentaCorriente, String cuit, String nombre, String razonSocial,
						String telefono, String direccionEnvio,String direccionFacturacion, int legajo,
						ArrayList<PedidoPrendasDto> pedidosAceptados, Sucursal sucursal ){
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
