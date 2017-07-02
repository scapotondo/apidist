package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Hashtable;

import dao.MovimientoMateriaPrimaDao;
import dao.MovimientoPrendaDao;
import dao.ProveedorDao;
import dao.StockMateriaPrimaDao;
import dao.StockPrendaDao;
import dto.EmpleadoDto;
import dto.ModificacionStockDto;
import dto.MovimientoMateriaPrimaDto;
import dto.MovimientoPrendaDto;
import dto.StockMateriaPrimaDto;
import dto.StockPrendaDto;
import exceptions.ApplicationException;
import exceptions.ColorException;
import negocio.ColorPrenda;
import negocio.EstadoMovimientoMateriaPrima;
import negocio.EstadoOrdenProduccion;
import negocio.EstadoPedidoPrenda;
import negocio.ItemPrenda;
import negocio.MateriaPrima;
import negocio.MovimientoMateriaPrima;
import negocio.MovimientoPrenda;
import negocio.OrdenDeCompra;
import negocio.OrdenDeProduccion;
import negocio.PedidoPrendas;
import negocio.Prenda;
import negocio.Proveedor;
import negocio.StockMateriaPrima;
import negocio.StockPrenda;
import negocio.TipoMovimientoStockPrendaEnum;

public class AlmacenController {

	private static AlmacenController instance;

	private int callePrendas = 8;
	private int calle = 17;
	private int bloque = 6;
	private int estante = 7;
	private int posicion = 22;

	private int[][][][] almacen = new int[calle][bloque][estante][posicion];

	private AlmacenController() {
		for (int calles = 1; calles < calle; calles++) {
			for (int bloques = 1; bloques < bloque; bloques++) {
				for (int estantes = 1; estantes < estante; estantes++) {
					for (int posiciones = 1; posiciones < posicion; posiciones++) {

						almacen[calles][bloques][estantes][posiciones] = 0;
					}
				}
			}
		}

		ArrayList<StockPrenda> stockPrendasDisponibles = StockPrendaDao.getInstance().getStockPrendasDisponibles();
		if (stockPrendasDisponibles != null) {
			for (StockPrenda stockPrenda : stockPrendasDisponibles) {
				this.agregarStockPrenda(stockPrenda);
			}
		}

		ArrayList<StockMateriaPrima> stockMateriasPrimasDisponibles = StockMateriaPrimaDao.getInstance()
				.getStockMateriasPrimasDisponibles();
		if (stockMateriasPrimasDisponibles != null) {
			for (StockMateriaPrima stockMateriaPrima : stockMateriasPrimasDisponibles) {
				this.agregarStockMateriaPrima(stockMateriaPrima);
			}
		}

	}

	public static AlmacenController getInstance() {
		if (instance == null)
			instance = new AlmacenController();

		return instance;
	}

	public int getStockPrenda(Prenda prenda, String talle, String color) {
		int total = 0;
		ArrayList<StockPrenda> stockPrendas = StockPrendaDao.getInstance().getStockPrendas();
		for (StockPrenda stockPrenda : stockPrendas) {

			if (stockPrenda.getPrenda().getCodigo() == prenda.getCodigo() && stockPrenda.getColor().equals(color)
					&& stockPrenda.getTalle().equals(talle))

				total = total + stockPrenda.getCantidad();
		}

		return total;
	}

	public boolean tenesStockPrenda(Prenda prenda, String talle, String color, int cantidad) {

		if (getStockPrenda(prenda, talle, color) >= cantidad)
			return true;

		return false;
	}

	public boolean tenesStockMateriaPrimaParaPrenda(Prenda prenda) {
		Hashtable<MateriaPrima, Integer> materiasPrimasReservadas = this.materiaPrimaReservada();

		Hashtable<MateriaPrima, Integer> materiaPrimaActual = this.materiaPrimaActual();

		// diccionario de materias necesarias
		Hashtable<MateriaPrima, Integer> materiaPrimaNecesaria = prenda.CalcularCantidadMateriaPrimaTotal();

		// obtengo las keys del diccionario, en este caso son los objetos de materia prima
		Enumeration<MateriaPrima> materiasPrimasKeys = materiaPrimaNecesaria.keys();

		while (materiasPrimasKeys.hasMoreElements()) {

			MateriaPrima materia = materiasPrimasKeys.nextElement();
			int actual = 0;
			int necesaria = 0;
			int reservada = 0;

			if (materiaPrimaActual.containsKey(materia))
				actual = materiaPrimaActual.get(materia);

			if (materiaPrimaNecesaria.containsKey(materia))
				necesaria = materiaPrimaNecesaria.get(materia);

			if (materiasPrimasReservadas.containsKey(materia))
				reservada = materiasPrimasReservadas.get(materia);

			if ((actual - necesaria - reservada) < 0)
				return false;
		}

		return true;
	}
	
	private StockPrenda buscarStockPrendaPorCodigo(int codigo) {
		return StockPrendaDao.getInstance().BuscarStockPrenda(codigo);
	}
	
	public void modificarStockPrendaAdmin(StockPrendaDto stockDto, EmpleadoDto empleadoDto, EmpleadoDto quienAutorizoDto, ModificacionStockDto modifDto) throws ApplicationException {
		if (stockDto == null)
			return;
		
		StockPrenda stock = buscarStockPrendaPorCodigo(stockDto.getCodigo());
		
		ArrayList<StockPrenda> stocks = new ArrayList<>();
		stocks.add(stock);
		
		int cantidad = modifDto.getCantidad();
		if (cantidad < 0) 
			disminuirStockPrenda(stock.getPrenda(), cantidad, stock.getTalle(), stock.getColor().toString(), empleadoDto.getNombre(), quienAutorizoDto.getNombre(), stocks, TipoMovimientoStockPrendaEnum.fromString(modifDto.getTipo()));
		else if (cantidad > 0) 
			aumentarStockPrendaDiferenciaInventario(stock, cantidad, empleadoDto.getNombre(), quienAutorizoDto.getNombre());
	}
	
	public void aumentarStockPrendaDiferenciaInventario(StockPrenda stock, int cantidad, String nombreEmpleado, String nombreAutorizo) {
		stock.setCantidad(stock.getCantidad() + cantidad);
		stock.updateMe();
		
		ArrayList<StockPrenda> stocks = new ArrayList<>();
		stocks.add(stock);
		
		MovimientoPrenda movimiento = new MovimientoPrenda(cantidad, Calendar.getInstance().getTime(), nombreEmpleado,
				nombreAutorizo, stock.getUbicacion(), stock.getPrenda(), TipoMovimientoStockPrendaEnum.DiferenciaInventario, stocks);
		movimiento.saveMe();
	}

	public void disminuirStockPrendaDespacho(Prenda prenda, int cantidad, String talle, String color, String encargado) {
		ArrayList<StockPrenda> stockPrendas = StockPrendaDao.getInstance().getStockPrendasReservadas(prenda.getCodigo());
		
		disminuirStockPrenda(prenda, cantidad, talle, color, encargado, "sistema", stockPrendas, TipoMovimientoStockPrendaEnum.Sistema);
	}

	private void disminuirStockPrenda(Prenda prenda, int cantidad, String talle, String color, String encargado, String quienAutoriza,
			ArrayList<StockPrenda> stockPrendas, TipoMovimientoStockPrendaEnum tipo) {
		String ubicacion = "";
		ArrayList<StockPrenda> stockPrendaUsados = new ArrayList<>();
		
		for (StockPrenda stockPrenda : stockPrendas) {
			if (cantidad <= 0) {
				break;
			}
			if (stockPrenda.getColor().equals(color) && stockPrenda.getTalle().equals(talle)) {

				if (stockPrenda.getCantidad() - cantidad > 0) {

					stockPrenda.disminuirCantidad(cantidad);

					ubicacion = stockPrenda.getUbicacion();
					cantidad = 0;
				} else {

					cantidad = cantidad - stockPrenda.getCantidad();

					ubicacion = "0";

					stockPrenda.setCantidad(0);

					sacarStockPrenda(stockPrenda);
				}

				stockPrenda.updateMe();
				
				stockPrendaUsados.add(stockPrenda);
			}
		}

		MovimientoPrenda movimiento = new MovimientoPrenda(cantidad, Calendar.getInstance().getTime(), encargado,
				quienAutoriza, ubicacion, prenda, tipo, stockPrendaUsados);
		movimiento.saveMe();
	}

	public void agregarStockPrenda(Prenda prenda, int cantidad, String talle, String color, OrdenDeProduccion lote)
			throws ColorException {

		Float costoProduccion = prenda.calcularCostoActual();

		String ubicacion = getUbicacionPrendaDisponible();

		StockPrenda stockPrenda = new StockPrenda(ColorPrenda.fromString(color), talle, lote,Calendar.getInstance().getTime(), 
				costoProduccion, cantidad, ubicacion,prenda);

		agregarStockPrenda(stockPrenda);

		stockPrenda.saveMe();

		ArrayList<StockPrenda> stockUtilizado = new ArrayList<>();
		stockUtilizado.add(stockPrenda);
		
		MovimientoPrenda movimiento = new MovimientoPrenda(cantidad, Calendar.getInstance().getTime(),
				"sistema", "sistema", ubicacion, prenda, TipoMovimientoStockPrendaEnum.Sistema, stockUtilizado);

		movimiento.saveMe();
	}

	public void reservarPrendasPedido(ArrayList<ItemPrenda> items){
		
		ArrayList<StockPrenda> stockPedidos = new ArrayList<StockPrenda>();
		
		for (ItemPrenda itemPrenda : items) {
			stockPedidos = StockPrendaDao.getInstance().getStockPrendas(itemPrenda.getPrenda().getCodigo());
			for (StockPrenda stockPrenda : stockPedidos) {
				if(itemPrenda.getCantidad() == 0){
					break;
				}
				
				if(stockPrenda.getCantidad() >= itemPrenda.getCantidad()){
						
					stockPrenda.reservar(itemPrenda.getCantidad());
					itemPrenda.setCantidad(0);
					
				}else{
					itemPrenda.disminuirCantidad(stockPrenda.getCantidad());
						
					stockPrenda.reservar(stockPrenda.getCantidad());
				}
			}
		}
	}
	
	public String getUbicacionPrendaDisponible() {
		String ubicacion;
		for (int calles = 1; calles < callePrendas; calles++) {
			for (int bloques = 1; bloques < bloque; bloques++) {
				for (int estantes = 1; estantes < estante; estantes++) {
					for (int posiciones = 1; posiciones < posicion; posiciones++) {

						if (almacen[calles][bloques][estantes][posiciones] == 0) {
							if (posiciones < 10)
								ubicacion = "0" + posiciones;
							else
								ubicacion = posiciones + "";

							return getLetraCalle(calles) + "0" + bloques + "0" + estantes + ubicacion;
						}
					}
				}
			}
		}

		return null;
	}

	private void sacarStockPrenda(StockPrenda stockPrenda) {
		String ubicacion = stockPrenda.getUbicacion();

		int calle = getNumeroCalle(ubicacion.charAt(0) + "");
		int bloque = Integer.parseInt((ubicacion.charAt(1) + ubicacion.charAt(2) + ""));
		int estante = Integer.parseInt(ubicacion.charAt(3) + ubicacion.charAt(4) + "");
		int posicion = Integer.parseInt(ubicacion.charAt(5) + ubicacion.charAt(6) + "");

		almacen[calle][bloque][estante][posicion] = 0;
	}

	private void agregarStockPrenda(StockPrenda stockPrenda) {
		String ubicacion = stockPrenda.getUbicacion();

		int calle = getNumeroCalle(ubicacion.charAt(0) + "");
		int bloque = Integer.parseInt((ubicacion.charAt(1) + ubicacion.charAt(2) + ""));
		int estante = Integer.parseInt(ubicacion.charAt(3) + ubicacion.charAt(4) + "");
		int posicion = Integer.parseInt(ubicacion.charAt(5) + ubicacion.charAt(6) + "");

		almacen[calle][bloque][estante][posicion] = stockPrenda.getLote().getNroOrden();
	}

	
	
	public void agregarStockMateriaPrima(MateriaPrima materiaPrima, int cantidad, Float precio) {

		String ubicacion = getUbicacionMateriaPrimaDisponible();

		StockMateriaPrima stock = new StockMateriaPrima(Calendar.getInstance().getTime(), precio, cantidad, ubicacion,
				materiaPrima);
		stock.saveMe();

		agregarStockMateriaPrima(stock);

		MovimientoMateriaPrima movimiento = new MovimientoMateriaPrima(EstadoMovimientoMateriaPrima.Agregar, cantidad,
				Calendar.getInstance().getTime(), stock);
		movimiento.saveMe();
	}

	public void disminuirStockMateriaPrima(MateriaPrima materiaPrima, int cantidad, OrdenDeProduccion lote) {
		
		ArrayList<StockMateriaPrima> stocksUsados = new ArrayList<StockMateriaPrima>();
		
		ArrayList<StockMateriaPrima> stockMateriaPrima = StockMateriaPrimaDao.getInstance().getStockMateriasPrimas();
		for (StockMateriaPrima stock : stockMateriaPrima) {
			if (cantidad <= 0)
				break;

			if (stock.getMateriaPrima().getCodigo() == materiaPrima.getCodigo()) {

				if (stock.getCantidad() - cantidad > 0) {
					stock.disminuirCantidad(cantidad);
					cantidad = 0;

				} else {
					cantidad = cantidad - stock.getCantidad();

					stock.setCantidad(0);

					sacarStockMateriaPrima(stock);
				}

				stock.updateMe();
				stocksUsados.add(stock);
			}
		}

		MovimientoMateriaPrima movimiento = new MovimientoMateriaPrima(EstadoMovimientoMateriaPrima.Remover, cantidad,
				Calendar.getInstance().getTime(), stocksUsados, lote);
		movimiento.saveMe();
	}

	public void reservarMateriaPrima(MateriaPrima mp, int cantidad, OrdenDeProduccion lote) {
		
		ArrayList<StockMateriaPrima> materiasPrimas = StockMateriaPrimaDao.getInstance().getStockMateriasPrimas();
		Float precio = 0f;
		for (StockMateriaPrima stockMateriaPrima : materiasPrimas) {
			if(stockMateriaPrima.getMateriaPrima().getCodigo() == mp.getCodigo()){
				if(stockMateriaPrima.getCantidad() >= cantidad)
					cantidad = 0;
				else
					cantidad = cantidad - stockMateriaPrima.getCantidad();
				
				precio = stockMateriaPrima.getPrecioFinalCompra();
			}
			
		}
		PedidoPrendas pedido = lote.getPedido();
		if(cantidad == 0){
		
			MovimientoMateriaPrima movimientoMateriaPrimaReservada = new MovimientoMateriaPrima(
					EstadoMovimientoMateriaPrima.Reservar, cantidad, Calendar.getInstance().getTime(), new ArrayList<StockMateriaPrima>(), lote);
			movimientoMateriaPrimaReservada.saveMe();
			
			pedido.setEstado(EstadoPedidoPrenda.EnProduccion);
			pedido.modificame();
			
		}else{
			Proveedor proveedor = ProveedorDao.getInstance().getProveedores().get(0);
			
			OrdenDeCompra ordenDeCompra = new OrdenDeCompra(Calendar.getInstance().getTime(), Calendar.getInstance().getTime(),
					Calendar.getInstance().getTime(), mp.getMinimo(), precio, lote, proveedor, OrdenDeCompra.PENDIENTE, mp);
			ordenDeCompra.saveMe();
			
			lote.setEstado(EstadoOrdenProduccion.MATERIAPRIMA);
			lote.modificame();
			
			pedido.setEstado(EstadoPedidoPrenda.EsperandoMateriaPrima);
			pedido.modificame();
		}
	}


	private String getUbicacionMateriaPrimaDisponible() {
		String ubicacion;
		for (int calles = callePrendas; calles < calle; calles++) {
			for (int bloques = 1; bloques < bloque; bloques++) {
				for (int estantes = 1; estantes < estante; estantes++) {
					for (int posiciones = 1; posiciones < posicion; posiciones++) {

						if (almacen[calles][bloques][estantes][posiciones] == 0) {
							if (posiciones < 10)
								ubicacion = "0" + posiciones;
							else
								ubicacion = posiciones + "";

							return getLetraCalle(calles) + "0" + bloques + "0" + estantes + ubicacion;
						}
					}
				}
			}
		}

		return null;
	}

	private void sacarStockMateriaPrima(StockMateriaPrima stockMateriaPrima) {
		String ubicacion = stockMateriaPrima.getUbicacion();

		int calle = getNumeroCalle(ubicacion.charAt(0) + "");
		int bloque = Integer.parseInt((ubicacion.charAt(1) + ubicacion.charAt(2) + ""));
		int estante = Integer.parseInt(ubicacion.charAt(3) + ubicacion.charAt(4) + "");
		int posicion = Integer.parseInt(ubicacion.charAt(5) + ubicacion.charAt(6) + "");

		almacen[calle][bloque][estante][posicion] = 0;
	}

	private void agregarStockMateriaPrima(StockMateriaPrima stockMateriaPrima) {
		String ubicacion = stockMateriaPrima.getUbicacion();

		int calle = getNumeroCalle(String.valueOf(ubicacion.charAt(0)));
		int bloque = Integer.parseInt(String.valueOf(ubicacion.charAt(1)) + String.valueOf(ubicacion.charAt(2)));
		int estante = Integer.parseInt(String.valueOf(ubicacion.charAt(3)) + String.valueOf(ubicacion.charAt(4)));
		int posicion = Integer.parseInt(String.valueOf(ubicacion.charAt(5)) + String.valueOf(ubicacion.charAt(6)));

		almacen[calle][bloque][estante][posicion] = stockMateriaPrima.getNumero();
	}

	private int getNumeroCalle(String letra) {
		switch (letra.toUpperCase()) {
		case "A":
			return 1;
		case "B":
			return 2;
		case "C":
			return 3;
		case "D":
			return 4;
		case "E":
			return 5;
		case "F":
			return 6;
		case "G":
			return 7;
		case "H":
			return 8;
		case "I":
			return 9;
		case "J":
			return 10;
		case "K":
			return 11;
		case "L":
			return 12;
		case "M":
			return 13;
		case "N":
			return 14;
		case "O":
			return 15;
		case "P":
			return 16;

		default:
			return 0;
		}
	}

	private String getLetraCalle(int numero) {
		switch (numero) {
		case 1:
			return "A";
		case 2:
			return "B";
		case 3:
			return "C";
		case 4:
			return "D";
		case 5:
			return "E";
		case 6:
			return "F";
		case 7:
			return "G";
		case 8:
			return "H";
		case 9:
			return "I";
		case 10:
			return "J";
		case 11:
			return "K";
		case 12:
			return "L";
		case 13:
			return "M";
		case 14:
			return "N";
		case 15:
			return "O";
		case 16:
			return "P";
		default:
			return null;
		}
	}
	
	private Hashtable<MateriaPrima, Integer> materiaPrimaReservada() {
		// movimientos que tienen estado Reservado
		ArrayList<MovimientoMateriaPrima> movimientosMateriaPrimaReservada = MovimientoMateriaPrimaDao.getInstance()
				.BuscarMovimientoMateriaPrimaReservara();

		Hashtable<MateriaPrima, Integer> materiasPrimasReservadas = new Hashtable<>();

		for (MovimientoMateriaPrima movimientoMateriaPrima : movimientosMateriaPrimaReservada) {
			for (StockMateriaPrima stockMateriaPrima : movimientoMateriaPrima.getStocksReservados()) {
				
				// si la materia prima existe
				if (materiasPrimasReservadas.containsKey(stockMateriaPrima.getMateriaPrima())) {
	
					// obtengo la materia prima
					MateriaPrima materia = stockMateriaPrima.getMateriaPrima();
	
					int cantidadVieja = materiasPrimasReservadas.get(materia);
					// la cantidad existente la sumo con la nueva
					int cantidadNueva = cantidadVieja + movimientoMateriaPrima.getCantidad();
	
					// cambio valores de la materia prima en diccionario
					materiasPrimasReservadas.replace(materia, cantidadVieja, cantidadNueva);
	
				} else {
					materiasPrimasReservadas.put(stockMateriaPrima.getMateriaPrima(),
							movimientoMateriaPrima.getCantidad());
				}
			}
		}

		return materiasPrimasReservadas;
	}

	private Hashtable<MateriaPrima, Integer> materiaPrimaActual() {
		// Materia prima que actualmente tengo
		Hashtable<MateriaPrima, Integer> materiaPrimaActual = new Hashtable<MateriaPrima, Integer>();

		ArrayList<StockMateriaPrima> stockMateriasPrima = StockMateriaPrimaDao.getInstance().getStockMateriasPrimas();
		for (StockMateriaPrima stockMateriaPrima : stockMateriasPrima) {

			if (materiaPrimaActual.containsKey(stockMateriaPrima.getMateriaPrima())) {

				MateriaPrima materia = stockMateriaPrima.getMateriaPrima();

				int cantidadVieja = materiaPrimaActual.get(materia);

				int cantidadNueva = cantidadVieja + stockMateriaPrima.getCantidad();

				materiaPrimaActual.replace(materia, cantidadVieja, cantidadNueva);
			} else
				materiaPrimaActual.put(stockMateriaPrima.getMateriaPrima(), stockMateriaPrima.getCantidad());

		}
		return materiaPrimaActual;
	}


	public ArrayList<MovimientoMateriaPrimaDto> getMovimientosMateriaPrima(){
		ArrayList<MovimientoMateriaPrimaDto> movimientosDto = new ArrayList<MovimientoMateriaPrimaDto>();
		
		ArrayList<MovimientoMateriaPrima> movimientos = MovimientoMateriaPrimaDao.getInstance().BuscarMovimientoMateriaPrima();
		
		for (MovimientoMateriaPrima movimientoMateriaPrima : movimientos) {
			movimientosDto.add(movimientoMateriaPrima.toDto());
		}
		
		return movimientosDto;
	}
	
	public ArrayList<MovimientoPrendaDto> getMovimientosPrendas(){
		ArrayList<MovimientoPrendaDto> movimientosDto = new ArrayList<MovimientoPrendaDto>();
		
		ArrayList<MovimientoPrenda> movimientos = MovimientoPrendaDao.getInstance().BuscarMovimientosPrenda();
		
		for (MovimientoPrenda movimientoPrenda : movimientos) {
			movimientosDto.add(movimientoPrenda.toDto());
		}
		
		return movimientosDto;
	}

	public ArrayList<StockPrendaDto> getStockPrendas(){
		ArrayList<StockPrendaDto> stockDto = new ArrayList<>();
		
		ArrayList<StockPrenda> stock = StockPrendaDao.getInstance().getStockPrendas();
		
		for (StockPrenda stockPrenda : stock) {
			stockDto.add(stockPrenda.toDto());
		}
		return stockDto;
	}
	
	public ArrayList<StockMateriaPrimaDto> getStockMateriaPrima(){
		ArrayList<StockMateriaPrimaDto> stocks = new ArrayList<>();
		
		ArrayList<StockMateriaPrima> stock = StockMateriaPrimaDao.getInstance().getStockMateriasPrimas();
		for (StockMateriaPrima stockMateriaPrima : stock) {
			stocks.add(stockMateriaPrima.toDto());
		}
		return stocks;
	}
}
