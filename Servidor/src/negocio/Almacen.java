package negocio;

import java.util.ArrayList;

public class Almacen {
//falta diccionario de diccionarios
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

	public void getStockPrendaDto( Prenda prenda,  String talle,  String color){
		
	}
	
	public boolean tenesStockPrenda(Prenda prenda,String talle, String color, int cantidad){
		return true;
	}
	
	public boolean tenesStockMateriaPrimaParaPrenda(Prenda prenda){
		return true;
	}
	
	public String reservarMateriaPrima(MateriaPrima mp, int cantidad){
		return null;
	}
	
	public void disminuirStockPrenda(Prenda prenda,int cantidad, String talle, String color, String encargado){
		
	}
	
	public void disminuirStockPrenda(Prenda prenda,int cantidad, String talle, String color, String encargado, String quienAutorizo, String destino){
		
	}
	public void agregarStockPrenda(Prenda prenda,int cantidad,String talle,String  color, String lote){
		
	}
	public void agregarStockMateriaPrima(MateriaPrima materiaPrima,int cantidad){
		
	}
	public void disminuirStockMateriaPrima(MateriaPrima materiaPrima,int cantidad){
		
	}
	
	public void ReservarPrenda(Prenda prenda,String talle,String color, int cantidad){
		
	}
	
	
}
