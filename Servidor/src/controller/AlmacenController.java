package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Hashtable;

import dao.MovimientoMateriaPrimaDao;
import dao.StockMateriaPrimaDao;
import dao.StockPrendaDao;
import exceptions.ColorException;
import negocio.ColorPrenda;
import negocio.EstadoMovimientoMateriaPrima;
import negocio.ItemPrenda;
import negocio.MateriaPrima;
import negocio.MovimientoMateriaPrima;
import negocio.MovimientoPrenda;
import negocio.OrdenDeProduccion;
import negocio.Prenda;
import negocio.StockMateriaPrima;
import negocio.StockPrenda;

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

		// obtengo las keys del diccionario, en este caso son los objetos de
		// materia prima
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

	public void disminuirStockPrendaDespacho(Prenda prenda, int cantidad, String talle, String color, String encargado) {
		MovimientoPrenda movimiento;
		String ubicacion = "";
		ArrayList<StockPrenda> stockPrendas;

		stockPrendas = StockPrendaDao.getInstance().getStockPrendasReservadas(prenda.getCodigo());
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
			}
		}

		movimiento = new MovimientoPrenda(cantidad, Calendar.getInstance().getTime(), talle, color, encargado,
				"sistema", ubicacion, prenda);
		movimiento.saveMe();
	}

	public void disminuirStockPrendaPorDeterioro(Prenda prenda, int cantidad, String talle, String color,
			String encargado, String quienAutorizo, String destino) {
		MovimientoPrenda movimiento;
		String ubicacion = "";
		ArrayList<StockPrenda> stockPrendas;

		if (tenesStockPrenda(prenda, talle, color, cantidad)) {

			stockPrendas = StockPrendaDao.getInstance().getStockPrendas();
			for (StockPrenda stockPrenda : stockPrendas) {
				if (cantidad <= 0) {
					break;
				}

				if (stockPrenda.getPrenda().getCodigo() == prenda.getCodigo() && stockPrenda.getColor().equals(color)
						&& stockPrenda.getTalle().equals(talle)) {

					if (stockPrenda.getCantidad() - cantidad > 0) {

						stockPrenda.disminuirCantidad(cantidad);

						ubicacion = stockPrenda.getUbicacion();
						cantidad = 0;
					} else {

						cantidad = cantidad - stockPrenda.getCantidad();

						stockPrenda.setCantidad(0);

						ubicacion = "0";

						sacarStockPrenda(stockPrenda);
					}
					stockPrenda.updateMe();
				}
			}
		}

		movimiento = new MovimientoPrenda(cantidad, Calendar.getInstance().getTime(), talle, color, encargado,
				quienAutorizo, ubicacion, prenda);
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

		MovimientoPrenda movimiento = new MovimientoPrenda(cantidad, Calendar.getInstance().getTime(), talle, color,
				"sistema", "sistema", ubicacion, prenda);

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
				Calendar.getInstance().getTime(), materiaPrima);
		movimiento.saveMe();
	}

	public void disminuirStockMateriaPrima(MateriaPrima materiaPrima, int cantidad) {

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
			}
		}

		MovimientoMateriaPrima movimiento = new MovimientoMateriaPrima(EstadoMovimientoMateriaPrima.Remover, cantidad,
				Calendar.getInstance().getTime(), materiaPrima);
		movimiento.saveMe();
	}

	public void reservarMateriaPrima(MateriaPrima mp, int cantidad) {
//		TODO: cambiar reserva para incluir stock
		//lote mp
//		MovimientoMateriaPrima movimientoMateriaPrimaReservada = new MovimientoMateriaPrima(
//				EstadoMovimientoMateriaPrima.Reservar, cantidad, Calendar.getInstance().getTime(), mp, ArraList<StockMateriaPrima>);
//		movimientoMateriaPrimaReservada.saveMe();
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

		int calle = getNumeroCalle(ubicacion.charAt(0) + "");
		int bloque = Integer.parseInt((ubicacion.charAt(1) + ubicacion.charAt(2) + ""));
		int estante = Integer.parseInt(ubicacion.charAt(3) + ubicacion.charAt(4) + "");
		int posicion = Integer.parseInt(ubicacion.charAt(5) + ubicacion.charAt(6) + "");

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

			// si la materia prima existe
			if (materiasPrimasReservadas.containsKey(movimientoMateriaPrima.getMateriaPrima())) {

				// obtengo la materia prima
				MateriaPrima materia = movimientoMateriaPrima.getMateriaPrima();

				int cantidadVieja = materiasPrimasReservadas.get(materia);
				// la cantidad existente la sumo con la nueva
				int cantidadNueva = cantidadVieja + movimientoMateriaPrima.getCantidad();

				// cambio valores de la materia prima en diccionario
				materiasPrimasReservadas.replace(materia, cantidadVieja, cantidadNueva);

			} else {
				materiasPrimasReservadas.put(movimientoMateriaPrima.getMateriaPrima(),
						movimientoMateriaPrima.getCantidad());
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


}
