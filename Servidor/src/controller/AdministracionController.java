package controller;

import java.util.ArrayList;

import dao.AreaProduccionDao;
import dao.ClienteDao;
import dao.MateriaPrimaDao;
import dao.PrendaDao;
import dao.SucursalDao;
import dto.ClienteDto;
import dto.ConfeccionDto;
import dto.InsumoDto;
import dto.PrendaDto;
import exceptions.ClienteException;
import exceptions.ColorException;
import exceptions.PrendaException;
import exceptions.SucursalException;
import negocio.AreaProduccion;
import negocio.Cliente;
import negocio.ColorPrenda;
import negocio.Confeccion;
import negocio.EstadoProcesoProduccion;
import negocio.Insumo;
import negocio.PedidoPrendas;
import negocio.Prenda;
import negocio.StockPrenda;
import negocio.Sucursal;

public class AdministracionController {
	private static AdministracionController instance;

	private ArrayList<Cliente> clientes;
	private ArrayList<Prenda> prendas;

	public static AdministracionController getInstance(){
		if (instance == null)
			instance = new AdministracionController();
		
		return instance;
	}

	private AdministracionController() {}

	public void generarFacturacion(PedidoPrendas pedido){

	}

	public void AltaCliente(ClienteDto clienteDto)  {
		Sucursal sucursal = SucursalDao.getInstance().getSucursalById(clienteDto.getSucursal().getNumero());
		if (sucursal == null){
			try {
				throw new SucursalException("La sucursal indicada no existe");
			} catch (SucursalException e) {
				e.printStackTrace();
			}
		}
		
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
				new ArrayList<PedidoPrendas>(), 
				clienteDto.getUsuario(),
				clienteDto.getPassword()
				);

		cliente.saveMe();
	}

	public void ModificarCliente(ClienteDto clienteDto) throws ClienteException{
		
		Cliente cliente=this.BuscarClientePorId(clienteDto);
		if (cliente == null)
			throw new ClienteException("El cliente ingresado no existe");
		
		Sucursal sucursal = SucursalDao.getInstance().getSucursalById(clienteDto.getSucursal().getNumero());
		if (sucursal == null){
			try {
				throw new SucursalException("La sucursal indicada no existe");
			} catch (SucursalException e) {
				e.printStackTrace();
			}
		}
		
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
		cliente.setUsuario(clienteDto.getUsuario());
		cliente.setPassword(clienteDto.getPassword());
		
		cliente.modificame();
	}
	
	public void EliminarCliente(ClienteDto clienteDto) throws ClienteException{
		Cliente cliente= this.BuscarClientePorId(clienteDto);
		if (cliente == null)
			throw new ClienteException("El cliente ingresado no existe");
		
		cliente.eliminame();
	}

	public ArrayList<ClienteDto> BuscarClientes(){
		this.clientes= ClienteDao.getInstance().BuscarClientes();
		ArrayList<ClienteDto> clientesDto = new ArrayList<ClienteDto>();
		
		for (Cliente cliente : clientes) {
			clientesDto.add(cliente.toDto());
		}
		
		return clientesDto;
	}
	
	public Cliente BuscarClientePorId(ClienteDto clienteDto) {
		return ClienteDao.getInstance().BuscarClientePorId(clienteDto);
	}

	public void AltaPrenda(PrendaDto prendaDto) throws ColorException {

		ArrayList<Confeccion> confecciones = new ArrayList<Confeccion>();
		for (ConfeccionDto confeccionDto : prendaDto.getConfecciones()) {
			
			AreaProduccion areaProd = AreaProduccionDao.getInstance().getById(confeccionDto.getAreaProduccion());
			
			ArrayList<Insumo> insumos = new ArrayList<Insumo>();
			for (InsumoDto insumoDto : confeccionDto.getInsumos()) {
				insumos.add(new Insumo(insumoDto.getCantidad(), insumoDto.getDesperdicio(), MateriaPrimaDao.getInstance().getById(insumoDto.getMateriaPrima())));
			}
			
			Confeccion confeccion = new Confeccion(confeccionDto.getTiempoProd(), confeccionDto.getDetalle(), areaProd, insumos, EstadoProcesoProduccion.INCOMPLETO);
			
			confecciones.add(confeccion);
		}
		
		ArrayList<ColorPrenda> colores = new ArrayList<>();
		for (String color : prendaDto.getColoresValidos())
			colores.add(ColorPrenda.fromString(color));
		
		Prenda prenda = new Prenda(
				prendaDto.getTallesValidos(), 
				colores,
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
	
	public void EliminarPrenda(PrendaDto prendaDto) throws PrendaException{
		Prenda prenda = this.BuscarPrendaPorNumero(prendaDto);
		if (prenda == null)
			throw new PrendaException("La prenda a borrar no existe");
		
		prenda.deleteMe();
	}
	
	public Prenda BuscarPrendaPorNumero(PrendaDto prendaDto){
		return PrendaDao.getInstance().BuscarPrendaPorCodigo(prendaDto);
	}
	
	public void ModificarPrenda(PrendaDto prendaDto) throws PrendaException, ColorException {
		
		Prenda prenda = PrendaDao.getInstance().BuscarPrendaPorCodigo(prendaDto);
		
		ArrayList<ColorPrenda> colores = new ArrayList<>();
		for (String color : prendaDto.getColoresValidos())
			colores.add(ColorPrenda.fromString(color));
			
		prenda.setTallesValidos(prendaDto.getTallesValidos());
		prenda.setColoresValidos(colores);
		prenda.setEsDiscontinuo(prendaDto.getEsDiscontinuo());
		prenda.setCantidadAProducir(prendaDto.getCantidadAProducir());
		prenda.setNombre(prendaDto.getNombre());
		prenda.setDescripcion(prendaDto.getDescripcion());
		prenda.setPorsentajeGanancia(prendaDto.getPorcentajeGanancia());
		
		prenda.modificame();
	}
	
	public ArrayList<PrendaDto> BuscarPrendas(){
		
		this.prendas = PrendaDao.getInstance().BuscarPrendas();
		
		ArrayList<PrendaDto> prendasDto = new ArrayList<PrendaDto>();
		
		for (Prenda prenda : this.prendas) {
			prendasDto.add( prenda.toDto());
		}
		
		return prendasDto;
	}

	public ArrayList<PrendaDto> GetPrendasDisponibles(){
		
		ArrayList<PrendaDto> prendasDto = new ArrayList<PrendaDto>();
		
		ArrayList<Prenda> prendasDisponibles = PrendaDao.getInstance().GetPrendasDisponibles();
		for (Prenda prenda : prendasDisponibles) {
			prendasDto.add( prenda.toDto());
		}
		
		return prendasDto;
	}
}
