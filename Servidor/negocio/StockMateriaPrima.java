package negocio;

import java.util.Date;

public class StockMateriaPrima {
	
	private OrdenDeCompra lote;
	private Date fechaRecepcion;
	private float precioFinalCompra;
	private int cantidad;
	private String ubicacion;
	
	public StockMateriaPrima(OrdenDeCompra lote,Date fechaRecepcion,float precioFinalCompra,int cantidad,String ubicacion){
		this.lote=lote;
		this.fechaRecepcion=fechaRecepcion;
		this.precioFinalCompra=precioFinalCompra;
		this.cantidad=cantidad;
		this.ubicacion=ubicacion;
	}
}
