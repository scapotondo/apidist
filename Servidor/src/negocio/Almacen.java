package negocio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Hashtable;

import dao.MovimientoMateriaPrimaDao;
import dao.StockMateriaPrimaDao;
import dao.StockPrendaDao;
import exceptions.ColorException;

public class Almacen {
	
	private static Almacen instance;
	
	private int[][][][] almacen = new int[17][6][7][22];
	
	
	private ArrayList<MovimientoPrenda> movimientosPrendas;
	private ArrayList<MovimientoMateriaPrima> movimientosMateriaPrima;
	private ArrayList<StockPrenda> stockPrendas;
	private ArrayList<StockMateriaPrima> stockMateriaPrima;
	
	private Almacen(){
		for (int calles = 1; calles < 17; calles++) {
			for (int bloques = 1; bloques < 6; bloques++) {
				for (int estantes = 1; estantes < 7; estantes++) {
					for (int posiciones = 1; posiciones < 21; posiciones++) {
						
						almacen[calles][bloques][estantes][posiciones] = 0;
					}
				}
			}
		}
	}
	
	public static Almacen getInstance(){
		if(instance==null)
			instance = new Almacen();
		
		return instance;
	}
	
	public ArrayList<MovimientoPrenda> getMovimientosPrendas() {
		return movimientosPrendas;
	}
	public void setMovimientosPrendas(ArrayList<MovimientoPrenda> movimientosPrendas) {
		this.movimientosPrendas = movimientosPrendas;
	}
	public ArrayList<MovimientoMateriaPrima> getMovimientosMateriaPrima() {
		return movimientosMateriaPrima;
	}
	public void setMovimientosMateriaPrima(ArrayList<MovimientoMateriaPrima> movimientosMateriaPrima) {
		this.movimientosMateriaPrima = movimientosMateriaPrima;
	}
	public ArrayList<StockPrenda> getStockPrendas() {
		return stockPrendas;
	}
	public void setStockPrendas(ArrayList<StockPrenda> stockPrendas) {
		this.stockPrendas = stockPrendas;
	}
	public ArrayList<StockMateriaPrima> getStockMateriaPrima() {
		return stockMateriaPrima;
	}
	public void setStockMateriaPrima(ArrayList<StockMateriaPrima> stockMateriaPrima) {
		this.stockMateriaPrima = stockMateriaPrima;
	}
	
	
	public int getStockPrenda( Prenda prenda,  String talle,  String color){
		int total = 0;
		
		this.stockPrendas=StockPrendaDao.getInstance().getStockPrendas();
		for (StockPrenda stockPrenda : this.stockPrendas) {
			
			if(stockPrenda.getPrenda().getCodigo() == prenda.getCodigo() && stockPrenda.getColor().equals(color) 
					&& stockPrenda.getTalle().equals(talle) )
				
				total = total + stockPrenda.getCantidad();
		}
		
		return total;
	}
	
	public boolean tenesStockPrenda(Prenda prenda,String talle, String color, int cantidad){

		if(getStockPrenda(prenda, talle, color) >= cantidad )
			return true;
		
		return false;
	}
	
	public boolean tenesStockMateriaPrimaParaPrenda(Prenda prenda){
		//actualizo stock
		this.stockMateriaPrima = StockMateriaPrimaDao.getInstance().getStockMateriasPrimas();
				
		//movimientos que tienen estado Reservado
		ArrayList<MovimientoMateriaPrima> movimientosMateriaPrimaReservada = MovimientoMateriaPrimaDao.getInstance().BuscarMovimientoMateriaPrimaReservara();
				
		Hashtable<MateriaPrima, Integer> materiasPrimasReservadas= new Hashtable<>();
				
		for (MovimientoMateriaPrima movimientoMateriaPrima : movimientosMateriaPrimaReservada) {
					
			//si la materia prima existe 
			if(materiasPrimasReservadas.containsKey(movimientoMateriaPrima.getMateriaPrima())){
						
				//obtengo la materia prima
				MateriaPrima materia = movimientoMateriaPrima.getMateriaPrima();
						
				int cantidadVieja = materiasPrimasReservadas.get(materia);
				//la cantidad existente la sumo con la nueva
				int cantidadNueva = cantidadVieja + movimientoMateriaPrima.getCantidad();
						
				//cambio valores de la materia prima en diccionario
				materiasPrimasReservadas.replace(materia, cantidadVieja, cantidadNueva);
				
			}else{
				materiasPrimasReservadas.put(movimientoMateriaPrima.getMateriaPrima(), movimientoMateriaPrima.getCantidad());
			}
		}
		
		//Materia prima que actualmente tengo
		Hashtable<MateriaPrima, Integer> materiaPrimaActual = new Hashtable<MateriaPrima, Integer>();
		
		for (StockMateriaPrima stockMateriaPrima : this.stockMateriaPrima) {
			
			if(materiaPrimaActual.containsKey(stockMateriaPrima.getMateriaPrima())){
				
				MateriaPrima materia = stockMateriaPrima.getMateriaPrima();
				
				int cantidadVieja = materiaPrimaActual.get(materia);
				
				int cantidadNueva = cantidadVieja + stockMateriaPrima.getCantidad();
				
				materiaPrimaActual.replace(materia, cantidadVieja, cantidadNueva);
			}else
				materiaPrimaActual.put(stockMateriaPrima.getMateriaPrima(), stockMateriaPrima.getCantidad());
			
		}
						
		//diccionario de materias necesarias
		Hashtable<MateriaPrima, Integer> materiaPrimaNecesaria = prenda.CalcularCantidadMateriaPrimaTotal();
				
		
		//obtengo las keys del diccionario, en este caso son los objetos de materia prima
		Enumeration<MateriaPrima> materiasPrimasKeys = materiaPrimaNecesaria.keys();
		
		while(materiasPrimasKeys.hasMoreElements()){
			
			MateriaPrima materia = materiasPrimasKeys.nextElement();
			int reservada = 0;
			int actual = 0;
			int necesaria = 0;
			
			if(materiasPrimasReservadas.containsKey(materia))
				reservada = materiasPrimasReservadas.get(materia);
			
			if(materiaPrimaNecesaria.containsKey(materia))
				necesaria = materiaPrimaNecesaria.get(materia);
			
			if(materiaPrimaActual.containsKey(materia))
				actual = materiaPrimaActual.get(materia);
			
			if( (actual - necesaria - reservada) < 0)
				return false;
		}
		
		return true;
	}

	public void disminuirStockPrenda(Prenda prenda,int cantidad, String talle, String color, String encargado){
		MovimientoPrenda movimiento;
		String ubicacion= "";
		
		if(tenesStockPrenda(prenda, talle, color, cantidad)){
			this.stockPrendas = StockPrendaDao.getInstance().getStockPrendas();
			for (StockPrenda stockPrenda : this.stockPrendas) {
				if(cantidad > 0){
					if(stockPrenda.getPrenda().getCodigo() == prenda.getCodigo() && stockPrenda.getColor().equals(color) &&
							stockPrenda.getTalle().equals(talle)){
						
						if(stockPrenda.getCantidad() - cantidad > 0){
							
							stockPrenda.disminuirCantidad(cantidad);
							stockPrenda.updateMe();
							
							ubicacion = getUbicacionStockPrenda(stockPrenda);
						
							cantidad = 0;
						}else{
							
							cantidad = cantidad - stockPrenda.getCantidad();
							
							stockPrenda.deleteMe();
							
							ubicacion = "0";
							
							sacarStockPrenda(stockPrenda);
						}
					}
				}
			}
		}
		
		movimiento = new MovimientoPrenda(-cantidad, Calendar.getInstance().getTime(), talle, color, encargado, "sistema", ubicacion, prenda);
		movimiento.saveMe();
	}
	
	public void disminuirStockPrendaPorDeterioro(Prenda prenda,int cantidad, String talle, String color, String encargado, String quienAutorizo, String destino){
		MovimientoPrenda movimiento;
		String ubicacion= "";
		
		if(tenesStockPrenda(prenda, talle, color, cantidad)){
			this.stockPrendas = StockPrendaDao.getInstance().getStockPrendas();
			for (StockPrenda stockPrenda : this.stockPrendas) {
				if(cantidad > 0){
					if(stockPrenda.getPrenda().getCodigo() == prenda.getCodigo() && stockPrenda.getColor().equals(color) &&
							stockPrenda.getTalle().equals(talle)){
						
						if(stockPrenda.getCantidad() - cantidad > 0){
							
							stockPrenda.disminuirCantidad(cantidad);
							stockPrenda.updateMe();
							
							ubicacion = getUbicacionStockPrenda(stockPrenda);
							
							cantidad = 0;
						}else{
							
							cantidad = cantidad - stockPrenda.getCantidad();
							
							stockPrenda.deleteMe();
							
							ubicacion = "0";
							
							sacarStockPrenda(stockPrenda);
						}
					}
				}
			}
		}
		
		movimiento = new MovimientoPrenda(-cantidad, Calendar.getInstance().getTime(), talle, color, encargado, quienAutorizo, ubicacion, prenda);
		movimiento.saveMe();
	}
	
	public void agregarStockPrenda(Prenda prenda, int cantidad, String talle, String color, OrdenDeProduccion lote) throws ColorException{
		
		Float costoProduccion= prenda.calcularCostoActual();
		
		String ubicacion = getUbicacionPrendaDisponible();
		
		
		StockPrenda stockPrenda = new StockPrenda(ColorPrenda.fromString(color), talle, lote,Calendar.getInstance().getTime(), costoProduccion, cantidad, 
				ubicacion, EstadoStockPrenda.Disponible, prenda);
		
		agregarStockPrenda(stockPrenda, ubicacion);
		
		stockPrenda.saveMe();
		
		MovimientoPrenda movimiento = new MovimientoPrenda(cantidad, Calendar.getInstance().getTime(), talle, color,
				"sistema", "sistema", ubicacion, prenda);
		
		movimiento.saveMe();
	}
	
	public void agregarStockMateriaPrima(MateriaPrima materiaPrima, int cantidad, Float precio){
		
		String ubicacion = getUbicacionMateriaPrimaDisponible();
		
		
		StockMateriaPrima stock = new StockMateriaPrima(Calendar.getInstance().getTime(), precio, cantidad, ubicacion, materiaPrima);
		stock.saveMe();
		
		agregarStockMateriaPrima(stock, ubicacion);
		
		MovimientoMateriaPrima movimiento = new MovimientoMateriaPrima(EstadoMovimientoMateriaPrima.Disponible, cantidad, Calendar.getInstance().getTime(), materiaPrima);
		movimiento.saveMe();
	}
 	
	//si pertenece a un movimiento donde esta reservada, se elimina el movimiento?
	public void disminuirStockMateriaPrima(MateriaPrima materiaPrima, int cantidad){
		
		this.stockMateriaPrima = StockMateriaPrimaDao.getInstance().getStockMateriasPrimas();
		for (StockMateriaPrima stock : this.stockMateriaPrima) {
			if(cantidad > 0){
				if(stock.getMateriaPrima().getCodigo() == materiaPrima.getCodigo()){
					
					if(stock.getCantidad() - cantidad > 0){
						stock.disminuirCantidad(cantidad);
						stock.updateMe();
						
						cantidad = 0;
					}else{
						cantidad = cantidad - stock.getCantidad();
						stock.deleteMe();
						
						sacarStockMateriaPrima(stock);
					}
				}
			}
		}
		
		MovimientoMateriaPrima movimiento = new MovimientoMateriaPrima(EstadoMovimientoMateriaPrima.Utilizado, -cantidad, Calendar.getInstance().getTime(), materiaPrima);
		movimiento.saveMe();
	}
	
	public void reservarMateriaPrima(MateriaPrima mp, int cantidad){
		
		MovimientoMateriaPrima movimientoMateriaPrimaReservada = new MovimientoMateriaPrima(EstadoMovimientoMateriaPrima.Reservado, cantidad, Calendar.getInstance().getTime(), mp);
		movimientoMateriaPrimaReservada.saveMe();
	}

	
	public String getUbicacionPrendaDisponible(){
		String posicion;
		for (int calles = 1; calles < 8; calles++) {
			for (int bloques = 1; bloques < 6; bloques++) {
				for (int estantes = 1; estantes < 7; estantes++) {
					for (int posiciones = 1; posiciones < 22; posiciones++) {
						
						if(almacen[calles][bloques][estantes][posiciones] == 0 ){
							if(posiciones <10)
								posicion = "0"+posiciones;
							else
								posicion = posiciones+"";
							
							return getLetraCalle(calles) + "0" + bloques + "0" + estantes + posicion;
						}
					}
				}
			}
		}
		
		return null;
	}
	
	private void sacarStockPrenda(StockPrenda stockPrenda){
		
		for (int calles = 1; calles < 8; calles++) {
			for (int bloques = 1; bloques < 6; bloques++) {
				for (int estantes = 1; estantes < 7; estantes++) {
					for (int posiciones = 1; posiciones < 22; posiciones++) {
						
						if(almacen[calles][bloques][estantes][posiciones] == stockPrenda.getLote().getNroOrden() ){
							
							almacen[calles][bloques][estantes][posiciones] = 0;
						}
					}
				}
			}
		}
	}

	private void agregarStockPrenda(StockPrenda stockPrenda, String ubicacion){
		int calle = getNumeroCalle(ubicacion.charAt(0)+"");
		int bloque = Integer.parseInt((ubicacion.charAt(1) + ubicacion.charAt(2) +""));
		int estante = Integer.parseInt(ubicacion.charAt(3) + ubicacion.charAt(4) +"");
		int posicion = Integer.parseInt(ubicacion.charAt(5) + ubicacion.charAt(6) +"");
		
		almacen[calle][bloque][estante][posicion] = stockPrenda.getLote().getNroOrden();
	}
	
	private String getUbicacionStockPrenda(StockPrenda stock){
		String posicion =new String();
		
		for (int calles = 1; calles < 8; calles++) {
			for (int bloques = 1; bloques < 6; bloques++) {
				for (int estantes = 1; estantes < 7; estantes++) {
					for (int posiciones = 1; posiciones < 22; posiciones++) {
						
						if(almacen[calles][bloques][estantes][posiciones] == stock.getLote().getNroOrden()){
							if(posiciones <10)
								posicion = "0"+posiciones;
							else
								posicion = posiciones+"";
							
							return getLetraCalle(calles) + "0" + bloques + "0" + estantes + posicion;
						}
					}
				}
			}
		}
		return null;
	}
	
	
	private String getUbicacionMateriaPrimaDisponible(){
		String posicion;
		for (int calles = 8; calles < 17; calles++) {
			for (int bloques = 1; bloques < 6; bloques++) {
				for (int estantes = 1; estantes < 7; estantes++) {
					for (int posiciones = 1; posiciones < 22; posiciones++) {
						
						if(almacen[calles][bloques][estantes][posiciones] == 0 ){
							if(posiciones <10)
								posicion = "0"+posiciones;
							else
								posicion = posiciones+"";
							
							return getLetraCalle(calles) + "0" + bloques + "0" + estantes + posicion;
						}
					}
				}
			}
		}
		
		return null;
	}
	
	private void sacarStockMateriaPrima(StockMateriaPrima stockMateriaPrima){
		for (int calles = 8; calles < 17; calles++) {
			for (int bloques = 1; bloques < 6; bloques++) {
				for (int estantes = 1; estantes < 7; estantes++) {
					for (int posiciones = 1; posiciones < 22; posiciones++) {
						
						if(almacen[calles][bloques][estantes][posiciones] ==  stockMateriaPrima.getNumero()){
							
							almacen[calles][bloques][estantes][posiciones] = 0;
						}
					}
				}
			}
		}
	}

	private void agregarStockMateriaPrima(StockMateriaPrima stockMateriaPrima , String ubicacion){
		int calle = getNumeroCalle(ubicacion.charAt(0)+"");
		int bloque = Integer.parseInt((ubicacion.charAt(1) + ubicacion.charAt(2) +""));
		int estante = Integer.parseInt(ubicacion.charAt(3) + ubicacion.charAt(4) +"");
		int posicion = Integer.parseInt(ubicacion.charAt(5) + ubicacion.charAt(6) +"");
		
		almacen[calle][bloque][estante][posicion] = stockMateriaPrima.getNumero();
	}
	
	
	private int getNumeroCalle(String letra){
		switch (letra) {
			case "A": return 1;
			case "B": return 2;
			case "C": return 3;
			case "D": return 4;
			case "E": return 5;
			case "F": return 6;
			case "G": return 7;
			case "H": return 8;
			case "I": return 9;
			case "J": return 10;
			case "K": return 11;
			case "L": return 12;
			case "M": return 13;
			case "N": return 14;
			case "O": return 15;
			case "P": return 16;
		
			default : return 0;
		}
	}
	
	private String getLetraCalle(int numero){
		switch (numero) {
			case 1: return "A";
			case 2: return "B";
			case 3: return "C";
			case 4: return "D";
			case 5: return "E";
			case 6: return "F";
			case 7: return "G";
			case 8: return "H";
			case 9: return "I";
			case 10: return "J";
			case 11: return "K";
			case 12: return "L";
			case 13: return "M";
			case 14: return "N";
			case 15: return "O";
			case 16: return "P";
			default : return null;
		}
	}
	
}
