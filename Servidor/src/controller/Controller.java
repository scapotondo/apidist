package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import dto.*;
import exceptions.*;
import negocio.*;
import dao.*;

public class Controller {
	private static Controller instance;
	
	private ArrayList<PedidoPrendas> pedidos;
	private ArrayList<OrdenDeProduccion> ordenesProduccion;
	private ArrayList<MateriaPrima> materiaPrima;
	private ArrayList<Sucursal> sucursales;
	private AreaProduccion areaProduccion;

	//singleton
	private Controller(){}
	public static Controller getInstance(){
		if(instance==null)
			instance=new Controller();
		
		return instance;
	}

	private PedidoPrendasDao getPedidoPrendasDao() {
		return PedidoPrendasDao.getInstance();
	}
	
	public PedidoPrendasDto CrearPedidoPrendas(PedidoPrendasDto pedidoDto) throws SucursalException, ColorException, ClienteException{
		Cliente cliente = ClienteDao.getInstance().BuscarClientePorId(pedidoDto.getCliente());
		if (cliente == null)
			throw new ClienteException("El Cliente no existe");
		
		ArrayList<ItemPrenda> items = new ArrayList<>();
		for (ItemPrendaDto itemDto : pedidoDto.getItems()) 
			items.add(new ItemPrenda(itemDto.getCantidad(), 
					itemDto.getTalle(), 
					itemDto.getColor(), 
					itemDto.getImporte(), 
					new Prenda(itemDto.getPrenda()), 
					null));
		
		PedidoPrendas pedido = new PedidoPrendas(pedidoDto.getNroPedido(), 
				pedidoDto.getFechaProbableDespacho(),
				pedidoDto.getEstado(),
				pedidoDto.getFechaGeneracion(),
				pedidoDto.getFechaRealDespacho(),
				null,
				cliente,
				items);
		
		getPedidoPrendasDao().CrearPedidoPrendas(pedido);
		
		//TODO: ver como traer el pedido recien agregado para tener el nro que es autogenerado y para poder pasarle el pedido a la sucursal
//		cliente.getSucursal().addNuevoPedido(pedido);
//		cliente.getSucursal().updateMe();
		
		return null;
	}
	
	public void AprobarPedidoAdmin(PedidoPrendasDto pedidoDto) throws ClienteException, PedidoException{
		Cliente cliente = ClienteDao.getInstance().BuscarClientePorId(pedidoDto.getCliente());
		if (cliente == null)
			throw new ClienteException("El Cliente no existe");
		
		PedidoPrendas pedido = PedidoPrendasDao.getInstance().BuscarPedidoPrendas(pedidoDto.getNroPedido());
		if (pedido == null)
			throw new PedidoException("No se encuentra el pedido");
		
		//TODO: cambiar estado pedido
		//TODO: calcular fecha probable
		ArrayList<ItemPrenda> sinStock = new ArrayList<>();
		for (ItemPrenda item : pedido.getItems()) {
			if (!AlmacenController.getInstance().tenesStockPrenda(item.getPrenda(), item.getTalle(), item.getColor(), item.getCantidad())) {
				sinStock.add(item);
			}
		}
		
		if (!sinStock.isEmpty()) {
			//Calcular el tipo de OP y si hay MP
		}
		
		Sucursal sucursal = cliente.getSucursal();
		sucursal.getPedidos().remove(pedido);
		sucursal.modificame();
		
		cliente.addNuevoPedidoAceptado(pedido);
		cliente.modificame();
	}
	
	//TODO: cambiar parametro, no puede ser int si viene de la vista, tiene que ser DTO
	public PedidoPrendas BuscarPedido(int nroPedido){
		return getPedidoPrendasDao().BuscarPedidoPrendas(nroPedido);
	}
	
	public void RechazarPedidoAdmin(PedidoPrendasDto pedidoDto, String descripcion) throws ClienteException, PedidoException{
		Cliente cliente = ClienteDao.getInstance().BuscarClientePorId(pedidoDto.getCliente());
		if (cliente == null)
			throw new ClienteException("El Cliente no existe");
		
		PedidoPrendas pedido = PedidoPrendasDao.getInstance().BuscarPedidoPrendas(pedidoDto.getNroPedido());
		if (pedido == null)
			throw new PedidoException("No se encuentra el pedido");
		
		//TODO: cambiar estado pedido
		
		Sucursal sucursal = cliente.getSucursal();
		sucursal.getPedidos().remove(pedido);
		sucursal.modificame();
		
		cliente.addNuevoPedidoRechazado(pedido, descripcion);
		cliente.modificame();
	}
	
	public void AceptarPedidoCliente(int nroPedido){
		//TODO: terminar
	}
	
	public void RechazarPedidoCliente(int nroPedido){
		//TODO: terminar
	}
	
	public void GenerarDevolucion(Prenda prenda){
		//TODO: terminar
	}
	
	public void AumentarRealStockAlmacen(String bulto,int cantidad){
		//TODO: terminar
	}
	
	public void DisminuirRealStockAlmacen(String bulto,int cantidad){
		//TODO: terminar
	}
	
	public void DisminuirStockDefectuosoAlmacen(String lote,int cantidad){
		//TODO: terminar
	}
	
	public void RechazarOrdenDeCompra(int nroCompra){
		//TODO: terminar
	}
	
	public ArrayList<PedidoPrendasDto> GetPedidosADespachar(){
		//TODO: terminar
		return null;
	}
	
	public void AceptarPedidoDespacho(int nroPedido){
		//TODO: terminar
	}
	
	public void TrabajoLineaTerminado(int codigoArea, int nroLinea){
		
	}
	
	private AreaProduccion BuscarAreaProduccion(AreaProduccionDto areaProdDto){
		return AreaProduccionDao.getInstance().getById(areaProdDto);
	}
	
	public ArrayList<AreaProduccionDto> GetAreasProduccion(){
		ArrayList<AreaProduccionDto> areasProduccionDto = new ArrayList<AreaProduccionDto>();
		
		ArrayList<AreaProduccion> areasProduccion = AreaProduccionDao.getInstance().getAreasProduccion();
		for (AreaProduccion areaProduccion : areasProduccion) {
			areasProduccionDto.add(areaProduccion.toDto());
		}
		
		return areasProduccionDto;
	}
	
	public ArrayList<MateriaPrimaDto> GetMateriasPrimas(){
		ArrayList<MateriaPrimaDto> materiasPrimasDto = new ArrayList<MateriaPrimaDto>();
		
		ArrayList<MateriaPrima> materiasPrimas = MateriaPrimaDao.getInstance().getMateriasPrimas();
		for (MateriaPrima materiaPrima : materiasPrimas) {
			materiasPrimasDto.add(materiaPrima.toDto());
		}
		
		return materiasPrimasDto;
	}
	
	public ArrayList<SucursalDto> getSucursales(){
		
		ArrayList<SucursalDto> sucursalesDto = new ArrayList<SucursalDto>();
		
		ArrayList<Sucursal> sucursales = SucursalDao.getInstance().getSucursales();
		for (Sucursal sucursal : sucursales) {
			sucursalesDto.add(sucursal.toDto());
		}
		
		return sucursalesDto;
	}
	
	private Sucursal BuscarSucursal(int nroSucursal){	
		return SucursalDao.getInstance().getSucursalById(nroSucursal);
	}
}
