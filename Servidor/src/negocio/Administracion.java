package negocio;

import java.util.ArrayList;

import dao.AreaProduccionDao;
import dao.ClienteDao;
import dao.MateriaPrimaDao;
import dao.PrendaDao;
import dto.AdministracionDto;
import dto.AreaProduccionDto;
import dto.ClienteDto;
import dto.ConfeccionDto;
import dto.InsumoDto;
import dto.LineaProduccionDto;
import dto.PedidoPrendasDto;
import dto.PrendaDto;

public class Administracion {
	private static Administracion instance;

	private ArrayList<Cliente> clientes;
	private ArrayList<Prenda> prendas;

	public static Administracion getInstance(){
		if (instance == null)
			instance = new Administracion();
		
		return instance;
	}

	private Administracion() {}

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
				sucursal,
				new ArrayList<PedidoPrendas>()
				);

		cliente.saveMe();
	}

	public void ModificarCliente(ClienteDto clienteDto, Sucursal sucursal){
		Cliente cliente=ClienteDao.getInstance().BuscarClientePorId(clienteDto);
		cliente.setLimiteCredito(clienteDto.getLimiteCredito());
		cliente.setFormaPago(clienteDto.getFormaPago());
		cliente.setCuentaCorriente(clienteDto.getCuentaCorriente());
		cliente.setCuit(clienteDto.getCuit());
		cliente.setNombre(clienteDto.getNombre());
		cliente.setRazonSocial(clienteDto.getRazonSocial());
		cliente.setTelefono(clienteDto.getTelefono());
		cliente.setDireccionEnvio(clienteDto.getDireccionEnvio());
		cliente.setDireccionFacturacion(clienteDto.getDireccionFacturacion());
		cliente.setSucursal(sucursal);
		
		cliente.modificame();
	}
	
	public void EliminarCliente(ClienteDto clienteDto){
		Cliente cliente=ClienteDao.getInstance().BuscarClientePorId(clienteDto);
		
		cliente.eliminame();
	}

	public ArrayList<ClienteDto> BuscarClientes(){
		ArrayList<Cliente> clientes= ClienteDao.getInstance().BuscarClientes();
		ArrayList<ClienteDto> clientesDto = new ArrayList<ClienteDto>();
		
		for (Cliente cliente : clientes) {
			clientesDto.add(cliente.toDto());
		}
		
		return clientesDto;
	}
	
	public ClienteDto BuscarClientePorId(ClienteDto cliente){
		return ClienteDao.getInstance().BuscarClientePorId(cliente).toDto();
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
	
	public void AltaPrenda(PrendaDto prendaDto) {
		ArrayList<Confeccion> confecciones = new ArrayList<Confeccion>();
		for (ConfeccionDto confeccionDto : prendaDto.getConfecciones()) {
			ArrayList<AreaProduccion> areasProd = new ArrayList<AreaProduccion>();
			for (AreaProduccionDto areaProdDto : confeccionDto.getAreaProduccion()) {
				areasProd.add(AreaProduccionDao.getInstance().getById(areaProdDto));
			}
			
			ArrayList<Insumo> insumos = new ArrayList<Insumo>();
			for (InsumoDto insumoDto : confeccionDto.getInsumos()) {
				insumos.add(new Insumo(insumoDto.getCantidad(), insumoDto.getDesperdicio(), MateriaPrimaDao.getInstance().getById(insumoDto.getMateriaPrima())));
			}
			
			Confeccion confeccion = new Confeccion(confeccionDto.getTiempoProd(), confeccionDto.getDetalle(), areasProd, insumos);
			
			confecciones.add(confeccion);
		}
		
		Prenda prenda = new Prenda(
				prendaDto.getTallesValidos(), 
				prendaDto.getColoresValidos(),
				prendaDto.getEsDiscontinuo(),
				prendaDto.getCantidadAProducir(),
				prendaDto.getNombre(),
				prendaDto.getDescripcion(),
				prendaDto.getPorcentajeGanancia(),
				confecciones,
				new ArrayList<StockPrenda>()
				);
		
		prenda.saveMe();
	}
}
