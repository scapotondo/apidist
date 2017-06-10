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
	
	private int[][][][] almacen = new int[7][5][6][21];
	
	private Object[] calle = new Integer[7];
	private Object[] bloque = new Integer[5];
	private Object[] estante = new Integer[6];
	private Object[] posicion = new StockPrenda[21];
	
//	private Object [][][][] almacen ={calle,bloque,estante,posicion}; 
	
	
	private ArrayList<MovimientoPrenda> movimientosPrendas;
	private ArrayList<MovimientoMateriaPrima> movimientosMateriaPrima;
	private ArrayList<StockPrenda> stockPrendas;
	private ArrayList<StockMateriaPrima> stockMateriaPrima;
	
	private Almacen(){
		for (int calles = 1; calles <= 7; calles++) {
			for (int bloques = 1; bloques <= 5; bloques++) {
				for (int estantes = 1; estantes <= 6; estantes++) {
					for (int posiciones = 1; posiciones <= 21; posiciones++) {
						
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
		
		this.stockPrendas=StockPrendaDao.getInstance().getStockPrendas();
		for (StockPrenda stockPrenda : this.stockPrendas) {
			
			if(stockPrenda.getPrenda().getCodigo() == prenda.getCodigo() && stockPrenda.getColor().equals(color) 
					&& stockPrenda.getTalle().equals(talle) )
				
				return stockPrenda.getCantidad();
		}
		return 0;
	}
	
	public boolean tenesStockPrenda(Prenda prenda,String talle, String color, int cantidad){

		if(getStockPrenda(prenda, talle, color) >= cantidad )
			return true;
		
		return false;
	}
	
	public boolean tenesStockMateriaPrimaParaPrenda(Prenda prenda){
		//actualizo stock
		this.stockMateriaPrima = StockMateriaPrimaDao.getInstance().getStockMateriasPrimas();
		
		//diccionario materias primas reservadas
				
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
		
	}
	
	public void disminuirStockPrendaPorDeterioro(Prenda prenda,int cantidad, String talle, String color, String encargado, String quienAutorizo, String destino){
		
		
	}
	
	public void agregarStockPrenda(Prenda prenda, int cantidad, String talle, String color, OrdenDeProduccion lote) throws ColorException{
		
		Float costoProduccion= prenda.calcularCostoActual();
		
		//TODO: ARMAR UBICACIONES
		String ubicacion = getUbicacionPrendaDisponible();
		
		//TODO: RESERVAR UBICACION
		
		StockPrenda stockPrenda = new StockPrenda(ColorPrenda.fromString(color), talle, lote,Calendar.getInstance().getTime(), costoProduccion, cantidad, 
				ubicacion, EstadoStockPrenda.Disponible, prenda);
		
		stockPrenda.saveMe();
		
		MovimientoPrenda movimiento = new MovimientoPrenda(cantidad, Calendar.getInstance().getTime(), talle, color,
				"sistema", "sistema", ubicacion, prenda);
		
		movimiento.saveMe();
	}
	
	public void agregarStockMateriaPrima(MateriaPrima materiaPrima, int cantidad, Float precio){
		
		String ubicacion = getUbicacionMateriaPrimaDisponible();
		
		//TODO: reservar ubicacion 
		
		StockMateriaPrima stock = new StockMateriaPrima(Calendar.getInstance().getTime(), precio, cantidad, ubicacion, materiaPrima);
		stock.saveMe();
		
		MovimientoMateriaPrima movimiento = new MovimientoMateriaPrima(EstadoMovimientoMateriaPrima.Disponible, cantidad, Calendar.getInstance().getTime(), materiaPrima);
		movimiento.saveMe();
	}
	
	public void disminuirStockMateriaPrima(MateriaPrima materiaPrima, int cantidad){
		
		//TODO: ver que esta lista se carge con lo que hay en el dic de dics
		this.stockMateriaPrima = StockMateriaPrimaDao.getInstance().getStockMateriasPrimas();
		for (StockMateriaPrima stock : this.stockMateriaPrima) {
			if(cantidad > 0){
				if(stock.getMateriaPrima().getCodigo() == materiaPrima.getCodigo()){
					
					if(stock.getCantidad() - cantidad >= 0){
						stock.disminuirCantidad(cantidad);
						stock.updateMe();
						
					}else{
						cantidad = cantidad - stock.getCantidad();
						stock.deleteMe();
						//TODO: sacar del dic de dics en este caso
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
		
		//TODO: ver si hay que moverla y en base a eso si se devuelve la nueva localizacion
	}
	
	public static void main(String[] args) {
		System.out.println(Almacen.getInstance().getUbicacionPrendaDisponible());
	}
	
	//TODO: en las posiciones poner el codigo del stock y para recuperarlo ir al dao y buscarlo
	public String getUbicacionPrendaDisponible(){
		String posicion;
		for (int calles = 1; calles <= 7; calles++) {
			for (int bloques = 1; bloques <= 5; bloques++) {
				for (int estantes = 1; estantes <= 6; estantes++) {
					for (int posiciones = 1; posiciones <= 21; posiciones++) {
						
						if(almacen[calles][bloques][estantes][posiciones] == 0 ){
							if(posiciones >10)
								posicion = "0"+posiciones;
							else
								posicion = posiciones+"";
							
							return getLetraCallePrendas(calles) + "0" + bloques + "0" + estantes + posicion;
						}
					}
				}
			}
		}
		
		return null;
	}
	
	private StockPrenda buscarStockPrenda(int codigoStock){
		//TODO: terminar y buscar prenda por codigo
		return null;
	}
	
	private String getUbicacionMateriaPrimaDisponible(){
		
		return null;
	}
	
	//se usa para obtener la letra que corresponde a cada calle
	private String getLetraCallePrendas(int numero){
		switch (numero) {
			case 1: return "A";
			case 2: return "B";
			case 3: return "C";
			case 4: return "D";
			case 5: return "E";
			case 6: return "F";
			case 7: return "G";
		
			default : return null;
		}
	}
	
	private String getLetraCalleMateriaPrima(int numero){
		switch (numero) {
			case 1: return "H";
			case 2: return "I";
			case 3: return "J";
			case 4: return "K";
			case 5: return "L";
			case 6: return "M";
			case 7: return "N";
			case 8: return "O";
			case 9: return "P";
		
			default : return null;
		}
	}
	
	
	//TODO: no se usa nunca,solo se reserva materia prima. Por las dudas chequear 
	public void ReservarPrenda(Prenda prenda,String talle,String color, int cantidad){
			
	}
}
