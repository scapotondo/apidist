package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class MovimientoMateriaPrimaDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String estado;
	private int cantidad;
	private Date fecha;
	private ArrayList<StockMateriaPrimaDto> stocksReservados;
	private int id;
	private OrdenDeProduccionDto lote;
	
	public MovimientoMateriaPrimaDto(int id,String estado, int cantidad, Date fecha, ArrayList<StockMateriaPrimaDto> stocksReservados, OrdenDeProduccionDto lote){
		this.id=id;
		this.estado=estado;
		this.cantidad=cantidad;
		this.fecha=fecha;
		this.stocksReservados=stocksReservados;
		this.lote=lote;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public ArrayList<StockMateriaPrimaDto> getStocksReservados() {
		return stocksReservados;
	}

	public void setStocksReservados(ArrayList<StockMateriaPrimaDto> stocksReservados) {
		this.stocksReservados = stocksReservados;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OrdenDeProduccionDto getLote() {
		return lote;
	}

	public void setLote(OrdenDeProduccionDto lote) {
		this.lote = lote;
	}
	
	
	
}
