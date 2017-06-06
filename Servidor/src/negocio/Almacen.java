package negocio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Hashtable;

import dao.MovimientoMateriaPrimaDao;
import dao.StockMateriaPrimaDao;
import dao.StockPrendaDao;

public class Almacen {
	//falta diccionario de diccionarios
	//hashmap para diccionario
	
	
	private ArrayList<MovimientoPrenda> movimientosPrendas;
	private ArrayList<MovimientoMateriaPrima> movimientosMateriaPrima;
	private ArrayList<StockPrenda> stockPrendas;
	private ArrayList<StockMateriaPrima> stockMateriaPrima;
	
	public Almacen(){
		movimientosMateriaPrima=new ArrayList<MovimientoMateriaPrima>();
		movimientosPrendas=new ArrayList<MovimientoPrenda>();
		stockPrendas=new ArrayList<StockPrenda>();
		stockMateriaPrima=new ArrayList<StockMateriaPrima>();
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

	
	//devuelvo -1 porque no acepta null
	public int getStockPrendaDto( Prenda prenda,  String talle,  String color){
		
		this.stockPrendas=StockPrendaDao.getInstance().getStockPrendas();
		for (StockPrenda stockPrenda : this.stockPrendas) {
			
			if(stockPrenda.getPrenda().getCodigo() == prenda.getCodigo() && stockPrenda.getColor().equals(color) 
					&& stockPrenda.getTalle().equals(talle) )
				
				return stockPrenda.getCantidad();
		}
		
		return -1;
	}
	
	public boolean tenesStockPrenda(Prenda prenda,String talle, String color, int cantidad){

		this.stockPrendas=StockPrendaDao.getInstance().getStockPrendas();
		for (StockPrenda stockPrenda : this.stockPrendas) {
			
			if(stockPrenda.getPrenda().getCodigo() == prenda.getCodigo() && stockPrenda.getColor().equals(color) 
					&& stockPrenda.getTalle().equals(talle) && stockPrenda.getCantidad() >= cantidad)
				
				return true;
		}
		
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
	
	public void disminuirStockPrenda(Prenda prenda,int cantidad, String talle, String color, String encargado, String quienAutorizo, String destino){
		
	}
	
	public void agregarStockPrenda(Prenda prenda,int cantidad,String talle,String  color, OrdenDeProduccion lote){
		
		Float costoProduccion= prenda.calcularCostoActual();
		
		//TODO: ARMAR UBICACIONES
		String ubicacion = "";
		
		StockPrenda stockPrenda = new StockPrenda(color, talle, lote,Calendar.getInstance().getTime(), costoProduccion, cantidad, 
				ubicacion, EstadoStockPrenda.Disponible, prenda);
		
		stockPrenda.saveMe();
		
		new MovimientoPrenda(cantidad, Calendar.getInstance().getTime(), talle, color, "sistema", "sistema", ubicacion, prenda).saveMe();
	}
	
	public void agregarStockMateriaPrima(MateriaPrima materiaPrima,int cantidad){
		
	}
	
	public void disminuirStockMateriaPrima(MateriaPrima materiaPrima,int cantidad){
		
	}
	
	
	public void ReservarPrenda(Prenda prenda,String talle,String color, int cantidad){
		
	}
	
	public void reservarMateriaPrima(MateriaPrima mp, int cantidad){
		
		MovimientoMateriaPrima movimientoMateriaPrimaReservada = new MovimientoMateriaPrima(EstadoMovimientoMateriaPrima.Reservado, cantidad, Calendar.getInstance().getTime(), mp);
		movimientoMateriaPrimaReservada.saveMe();
		
		//TODO: ver si hay que moverla y en base a eso si se devuelve la nueva localizacion
	}
	
	
}
