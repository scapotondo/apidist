package controller;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import dao.AreaProduccionDao;
import dao.ClienteDao;
import dao.MateriaPrimaDao;
import dao.PedidoPrendasDao;
import dao.SucursalDao;
import dto.AreaProduccionDto;
import dto.ItemPrendaDto;
import dto.MateriaPrimaDto;
import dto.PedidoPrendasDto;
import dto.SucursalDto;
import exceptions.ClienteException;
import exceptions.ColorException;
import exceptions.PedidoException;
import exceptions.PrendaException;
import exceptions.SucursalException;
import negocio.AreaProduccion;
import negocio.Cliente;
import negocio.EstadoPedidoPrenda;
import negocio.ItemPrenda;
import negocio.MateriaPrima;
import negocio.PedidoPrendas;
import negocio.Prenda;
import negocio.Sucursal;

public class Controller {
	
	private static Controller instance;

	private Controller(){}

	public static Controller getInstance(){
		if(instance==null)
			instance=new Controller();
		
		return instance;
	}

	private PedidoPrendasDao getPedidoPrendasDao() {
		return PedidoPrendasDao.getInstance();
	}
	
	public PedidoPrendasDto CrearPedidoPrendas(PedidoPrendasDto pedidoDto) throws SucursalException, ColorException, ClienteException, PrendaException{
		Cliente cliente = ClienteDao.getInstance().BuscarClientePorId(pedidoDto.getCliente());
		if (cliente == null)
			throw new ClienteException("El Cliente " + pedidoDto.getCliente().getNombre() + " no existe");
		
		ArrayList<ItemPrenda> items = new ArrayList<>();
		for (ItemPrendaDto itemDto : pedidoDto.getItems()) {
			Prenda prenda = AdministracionController.getInstance().BuscarPrendaPorNumero(itemDto.getPrenda());
			if (prenda == null)
				throw new PrendaException("No existe la prenda: " + itemDto.getPrenda().getNombre());
			
			Float importe = prenda.calcularCostoActual();
			items.add(new ItemPrenda(itemDto.getCantidad(), 
					itemDto.getTalle(), 
					itemDto.getColor(), 
					importe, 
					prenda, 
					null));
		}
		PedidoPrendas pedido = new PedidoPrendas(pedidoDto.getNroPedido(), 
				pedidoDto.getFechaProbableDespacho(),
				pedidoDto.getEstado(),
				pedidoDto.getFechaGeneracion(),
				pedidoDto.getFechaRealDespacho(),
				null,
				cliente,
				items);
		
		pedido = getPedidoPrendasDao().CrearPedidoPrendas(pedido);
		cliente.getSucursal().addNuevoPedido(pedido);
		cliente.getSucursal().modificame();
		
		return pedido.toDto();
	}
	
	public void AprobarPedidoAdmin(PedidoPrendasDto pedidoDto) throws ClienteException, PedidoException{
		Cliente cliente = ClienteDao.getInstance().BuscarClientePorId(pedidoDto.getCliente());
		if (cliente == null)
			throw new ClienteException("El Cliente no existe");
		
		PedidoPrendas pedido = PedidoPrendasDao.getInstance().BuscarPedidoPrendas(pedidoDto.getNroPedido());
		if (pedido == null)
			throw new PedidoException("No se encuentra el pedido");

		Float importe = pedido.calcularTotal();
		if(!cliente.alcanzaCredito(importe))
			throw new ClienteException("El Cliente no posee credito suficiente para realizar el pedido");
		
		pedido.setEstado(EstadoPedidoPrenda.PendienteDeAceptacion);
		pedido.modificame();
		
		Calendar c = Calendar.getInstance();
		c.setTime(Date.from(Instant.now()));
		c.add(Calendar.DATE, pedido.estimarCantDiasParaDeEntrega()); 

		pedido.setFechaProbableDespacho(c.getTime());		
		pedido.modificame();
		
		Sucursal sucursal = cliente.getSucursal();
		sucursal.getPedidos().remove(pedido);
		sucursal.modificame();
		
		cliente.addNuevoPedidoAceptado(pedido);
		cliente.modificame();
	}
	
	public PedidoPrendas BuscarPedido(int nroPedido){
		return getPedidoPrendasDao().BuscarPedidoPrendas(nroPedido);
	}
	
	public void RechazarPedidoAdmin(PedidoPrendasDto pedidoDto, String descripcion) throws ClienteException, PedidoException {
		Cliente cliente = ClienteDao.getInstance().BuscarClientePorId(pedidoDto.getCliente());
		if (cliente == null)
			throw new ClienteException("El Cliente no existe");
		
		PedidoPrendas pedido = PedidoPrendasDao.getInstance().BuscarPedidoPrendas(pedidoDto.getNroPedido());
		if (pedido == null)
			throw new PedidoException("No se encuentra el pedido");
		
		pedido.setEstado(EstadoPedidoPrenda.RechazadoAdmin);
		pedido.modificame();
		
		Sucursal sucursal = cliente.getSucursal();
		sucursal.getPedidos().remove(pedido);
		sucursal.modificame();
		
		cliente.addNuevoPedidoRechazado(pedido, descripcion);
		cliente.modificame();
	}
	
	public void AceptarPedidoCliente(int nroPedido) throws PedidoException{
		PedidoPrendas pedido = this.BuscarPedido(nroPedido);
		
		if(pedido == null)
			throw new PedidoException("No se encuentra el pedido");
		
		if(hayStock(pedido.getItems())){
			AlmacenController.getInstance().reservarPrendasPedido(pedido.getItems());
			pedido.setEstado(EstadoPedidoPrenda.Despacho);
			pedido.modificame();
			
		}else{
			//TODO: seguir viendo cuantas prendas le pueden faltar y hacer las ordenes
		}
	}
	
	public void RechazarPedidoCliente(int nroPedido) throws PedidoException{
		PedidoPrendas pedido = this.BuscarPedido(nroPedido);
		
		if(pedido == null)
			throw new PedidoException("No se encuentra el pedido");
		
		pedido.setEstado(EstadoPedidoPrenda.CanceladoCliente);
		pedido.modificame();
	}
	
	//TODO: ver si se pasa o no al almacenController
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
	
	private boolean hayStock(ArrayList<ItemPrenda>items){
		for (ItemPrenda item : items) {
			
			if(!AlmacenController.getInstance().tenesStockPrenda(item.getPrenda(), item.getTalle(), item.getColor(), item.getCantidad())){
			
				return false;
			}
		}
		return true;
	}
	//===========================fin todo
	
	
	public void TrabajoLineaTerminado(int codigoArea, int nroLinea){
		AreaProduccionDto areaDto = new AreaProduccionDto();
		areaDto.setCodigo(codigoArea);
		
		AreaProduccion area = this.BuscarAreaProduccion(areaDto);
		area.liberarLineaProduccion(nroLinea);
		
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
