package dto;

import java.util.ArrayList;


public class AlmacenDto {

	private ArrayList<MovimientoPrendaDto> movimientosPrendas;
	private ArrayList<MovimientoMateriaPrimaDto> movimientosMateriaPrima;
	private ArrayList<StockPrendaDto> stockPrendas;
	private ArrayList<StockMateriaPrimaDto> stockMateriaPrima;
	
	public AlmacenDto(ArrayList<MovimientoPrendaDto> movimientosPrendas,ArrayList<MovimientoMateriaPrimaDto> movimientosMateriaPrima,
			ArrayList<StockPrendaDto> stockPrendas,ArrayList<StockMateriaPrimaDto> stockMateriaPrima){
		
		this.movimientosPrendas=movimientosPrendas;
		this.movimientosMateriaPrima=movimientosMateriaPrima;
		this.stockPrendas=stockPrendas;
		this.stockMateriaPrima=stockMateriaPrima;
	}

	public ArrayList<MovimientoPrendaDto> getMovimientosPrendas() {
		return movimientosPrendas;
	}

	public void setMovimientosPrendas(ArrayList<MovimientoPrendaDto> movimientosPrendas) {
		this.movimientosPrendas = movimientosPrendas;
	}

	public ArrayList<MovimientoMateriaPrimaDto> getMovimientosMateriaPrima() {
		return movimientosMateriaPrima;
	}

	public void setMovimientosMateriaPrima(ArrayList<MovimientoMateriaPrimaDto> movimientosMateriaPrima) {
		this.movimientosMateriaPrima = movimientosMateriaPrima;
	}

	public ArrayList<StockPrendaDto> getStockPrendas() {
		return stockPrendas;
	}

	public void setStockPrendas(ArrayList<StockPrendaDto> stockPrendas) {
		this.stockPrendas = stockPrendas;
	}

	public ArrayList<StockMateriaPrimaDto> getStockMateriaPrima() {
		return stockMateriaPrima;
	}

	public void setStockMateriaPrima(ArrayList<StockMateriaPrimaDto> stockMateriaPrima) {
		this.stockMateriaPrima = stockMateriaPrima;
	}
	
}
