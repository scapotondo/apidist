package dto;

import java.util.Date;


public class StockMateriaPrimaDto {

	private OrdenDeCompraDto lote;
	private Date fechaRecepcion;
	private float precioFinalCompra;
	private int cantidad;
	private String ubicacion;
	
	public StockMateriaPrimaDto(OrdenDeCompraDto lote,Date fechaRecepcion,float precioFinalCompra,int cantidad,String ubicacion){
		this.lote=lote;
		this.fechaRecepcion=fechaRecepcion;
		this.precioFinalCompra=precioFinalCompra;
		this.cantidad=cantidad;
		this.ubicacion=ubicacion;
	}

	public OrdenDeCompraDto getLote() {
		return lote;
	}

	public void setLote(OrdenDeCompraDto lote) {
		this.lote = lote;
	}

	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public float getPrecioFinalCompra() {
		return precioFinalCompra;
	}

	public void setPrecioFinalCompra(float precioFinalCompra) {
		this.precioFinalCompra = precioFinalCompra;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
}
