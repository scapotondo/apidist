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
	
	public String reservarMateriaPrima(MateriaPrima mp, int cantidad){
		return null;
	}
	
	
}
