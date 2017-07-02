package controller;

import java.rmi.RemoteException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

import dao.AreaProduccionDao;
import dao.ClienteDao;
import dao.EmpleadoDao;
import dao.MateriaPrimaDao;
import dao.PedidoPrendasDao;
import dao.SucursalDao;
import dao.UsuarioDao;
import dto.AreaProduccionDto;
import dto.ClienteDto;
import dto.EmpleadoDto;
import dto.ItemPrendaDto;
import dto.MateriaPrimaDto;
import dto.PedidoPrendasDto;
import dto.SucursalDto;
import dto.UsuarioDto;
import exceptions.ClienteException;
import exceptions.ColorException;
import exceptions.PedidoException;
import exceptions.PrendaException;
import exceptions.SucursalException;
import exceptions.UsuarioException;
import negocio.AreaProduccion;
import negocio.Cliente;
import negocio.EstadoOrdenProduccion;
import negocio.EstadoPedidoPrenda;
import negocio.ItemPrenda;
import negocio.MateriaPrima;
import negocio.OrdenDeProduccion;
import negocio.OrdenProduccionCompleta;
import negocio.OrdenProduccionParcial;
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
				EstadoPedidoPrenda.Nuevo,
				pedidoDto.getFechaGeneracion(),
				pedidoDto.getFechaRealDespacho(),
				null,
				cliente,
				items);
		
		return getPedidoPrendasDao().CrearPedidoPrendas(pedido).toDto();
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
	}
	
	public ArrayList<PedidoPrendasDto> buscarPedidosAprobadosAdmin(ClienteDto clienteDto) throws ClienteException {
		Cliente cliente = ClienteDao.getInstance().BuscarClientePorId(clienteDto);
		if (cliente == null)
			throw new ClienteException("El Cliente no existe");
		
		ArrayList<PedidoPrendas> pedidos = PedidoPrendasDao.getInstance().BuscarPedidosPrendasAprobadasAdmin(cliente);
		
		ArrayList<PedidoPrendasDto> pedidosDto = new ArrayList<PedidoPrendasDto>();
		for (PedidoPrendas pedidoPrendas : pedidos) {
			pedidosDto.add(pedidoPrendas.toDto());
		}
		
		return pedidosDto;
	}
	
	public ArrayList<PedidoPrendasDto> buscarPedidosRechazadosAdmin(ClienteDto clienteDto) throws ClienteException {
		Cliente cliente = ClienteDao.getInstance().BuscarClientePorId(clienteDto);
		if (cliente == null)
			throw new ClienteException("El Cliente no existe");
		
		ArrayList<PedidoPrendas> pedidos = PedidoPrendasDao.getInstance().BuscarPedidosPrendasRechazadosAdmin(cliente);
		
		ArrayList<PedidoPrendasDto> pedidosDto = new ArrayList<PedidoPrendasDto>();
		for (PedidoPrendas pedidoPrendas : pedidos) {
			pedidosDto.add(pedidoPrendas.toDto());
		}
		
		return pedidosDto;
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
	}
	
	public void AceptarPedidoCliente(int nroPedido) throws PedidoException{
		PedidoPrendas pedido = this.BuscarPedido(nroPedido);
		
		if(pedido == null)
			throw new PedidoException("No se encuentra el pedido");
		
		Cliente cliente = pedido.getCliente();
		cliente.setCuentaCorriente(cliente.getCuentaCorriente() - pedido.calcularTotal());
		cliente.modificame();
		
		Hashtable<Prenda, ArrayList<ItemPrenda>> sinStock = getItemsSinStock(pedido.getItems());
		if(sinStock.isEmpty()) {
			AlmacenController.getInstance().reservarPrendasPedido(pedido.getItems());
			pedido.setEstado(EstadoPedidoPrenda.Despacho);
			pedido.modificame();
		} else {
			for(Prenda prenda : sinStock.keySet()) {
				ArrayList<String> cantColores = new ArrayList<>();
				ArrayList<String> cantTalles = new ArrayList<>();

				for(ItemPrenda item : sinStock.get(prenda)) {
					if (!cantColores.contains(item.getColor()))
						cantColores.add(item.getColor());
					
					if (!cantTalles.contains(item.getTalle()))
						cantTalles.add(item.getTalle());
				}

				Hashtable<MateriaPrima, Integer> mps = prenda.CalcularCantidadMateriaPrimaTotal();
				
				if (cantColores.size() >= 3 || cantTalles.size() >= 3) {
					
					OrdenDeProduccion opc = new OrdenProduccionCompleta(EstadoOrdenProduccion.PENDIENTE, pedido, prenda);
					opc.saveMe();
					
					int cantidad = prenda.getCantidadOPC();
					
					for (MateriaPrima mp : mps.keySet()) {
						AlmacenController.getInstance().reservarMateriaPrima(mp, cantidad, opc);
					}
					
				} else {
					
					OrdenDeProduccion opp = new OrdenProduccionParcial(cantTalles, cantColores, EstadoOrdenProduccion.PENDIENTE, pedido, prenda);
					opp = opp.saveMe();
					
					int cantidad = sinStock.get(prenda).size() * prenda.getCantidadAProducir();
					
					for (MateriaPrima mp : mps.keySet()) {
						AlmacenController.getInstance().reservarMateriaPrima(mp, cantidad, opp);
					}
					
				}
			}
			
		}
	}
	
	public ArrayList<PedidoPrendasDto> getPedidosPendientesAceptacionCliente(ClienteDto cliente)throws RemoteException {
		ArrayList<PedidoPrendasDto> pedidosDto = new ArrayList<PedidoPrendasDto>();
		
		ArrayList<PedidoPrendas> pedidos = PedidoPrendasDao.getInstance().getPedidosPedientesAprobacionCliente(cliente);
		for (PedidoPrendas pedidoPrendas : pedidos) {
			pedidosDto.add(pedidoPrendas.toDto());
		}
		
		return pedidosDto;
	}

	public ArrayList<PedidoPrendasDto> getPedidosPendientesAceptacionAdmin() throws RemoteException {
		ArrayList<PedidoPrendasDto> pedidosDto = new ArrayList<PedidoPrendasDto>();
		
		ArrayList<PedidoPrendas> pedidos = PedidoPrendasDao.getInstance().getPedidosPedientesAprobacionAdmin();
		for (PedidoPrendas pedidoPrendas : pedidos) {
			pedidosDto.add(pedidoPrendas.toDto());
		}
		
		return pedidosDto;
	}
	
	public void RechazarPedidoCliente(int nroPedido) throws PedidoException{
		PedidoPrendas pedido = this.BuscarPedido(nroPedido);
		
		if(pedido == null)
			throw new PedidoException("No se encuentra el pedido");
		
		pedido.setEstado(EstadoPedidoPrenda.CanceladoCliente);
		pedido.modificame();
	}
	
	private Hashtable<Prenda, ArrayList<ItemPrenda>> getItemsSinStock(ArrayList<ItemPrenda>items){
		Hashtable<Prenda, ArrayList<ItemPrenda>> sinStock = new Hashtable<>();
		for (ItemPrenda item : items) {
			if (!AlmacenController.getInstance().tenesStockPrenda(item.getPrenda(), item.getTalle(), item.getColor(), item.getCantidad())) {
				ArrayList<ItemPrenda> list = new ArrayList<>();
				if (sinStock.containsKey(item.getPrenda()))
					list = sinStock.get(item.getPrenda());

				list.add(item);

				sinStock.put(item.getPrenda(), list);
			}
		}
		
		return sinStock;
	}
	
	
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
	
	public EmpleadoDto getEmpleado(EmpleadoDto empleado) throws UsuarioException {
		return EmpleadoDao.getInstance().getEmpleado(empleado.getLegajo()).toDto();
	}
	
	public UsuarioDto LoginCliente(String userName, String password) {
		try {
			return UsuarioDao.getInstance().loginCliente(userName, password);
		} catch (UsuarioException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public UsuarioDto getUsuarioCliente(int codigo) {
		try {
			return UsuarioDao.getInstance().getUsuarioCliente(codigo);
		} catch (UsuarioException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public UsuarioDto LoginEmpleado(String userName, String password) {
		try {
			return UsuarioDao.getInstance().loginEmpleado(userName, password);
		} catch (UsuarioException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public UsuarioDto getUsuarioEmpleado(int codigo) {
		try {
			return UsuarioDao.getInstance().getUsuarioEmpleado(codigo);
		} catch (UsuarioException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<PedidoPrendasDto> getPedidosDespacho() {
		try {
			ArrayList<PedidoPrendas> pedidos = PedidoPrendasDao.getInstance().getPedidosDespacho(); 
			ArrayList<PedidoPrendasDto> pedidosDto = new ArrayList<PedidoPrendasDto>(); 
			
			for (PedidoPrendas pedido : pedidos) {
				pedidosDto.add(pedido.toDto());
			}
			
			return pedidosDto; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<PedidoPrendasDto> getPedidosAceptados(ClienteDto cliente) {
		try {
			ArrayList<PedidoPrendas> pedidos = PedidoPrendasDao.getInstance().getPedidosAceptados(cliente); 
			ArrayList<PedidoPrendasDto> pedidosDto = new ArrayList<PedidoPrendasDto>(); 
			
			for (PedidoPrendas pedido : pedidos) {
				pedidosDto.add(pedido.toDto());
			}
			
			return pedidosDto; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
