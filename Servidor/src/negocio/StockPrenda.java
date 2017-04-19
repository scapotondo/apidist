package negocio;

import java.util.Date;

public class StockPrenda {
	private String color;
	private String talle;
	private OrdenDeProduccion lote;
	private Date fecha;
	private float costoProduccion;
	private int cantidad;
	private String ubicacion;
	private String estado;
	private Prenda prenda;
	private OrdenDeProduccion ordenProduccion;
	
	public StockPrenda(String color,String talle,OrdenDeProduccion lote,Date fecha,float costoProduccion,int cantidad,
			String ubicacion,String estado,Prenda prenda,OrdenDeProduccion ordenProduccion){
		this.color=color;
		this.talle=talle;
		this.lote=lote;
		this.fecha=fecha;
		this.costoProduccion=costoProduccion;
		this.cantidad=cantidad;
		this.ubicacion=ubicacion;
		this.estado=estado;
		this.prenda=prenda;
		this.ordenProduccion=ordenProduccion;
	}

}
