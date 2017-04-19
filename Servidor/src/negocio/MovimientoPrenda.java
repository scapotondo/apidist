package negocio;

import java.util.Date;

public class MovimientoPrenda {

	private int cantidad;
	private Date fecha;
	private String talle;
	private String color;
	private String encargado;
	private String quienAutorizo;
	private String destino;
	private Prenda prenda;
	
	public MovimientoPrenda(int cantidad, Date fecha, String talle, String color, String encargado, String quienAutorizo,
			String destino, Prenda prenda){
		this.cantidad=cantidad;
		this.fecha=fecha;
		this.talle=talle;
		this.color=color;
		this.encargado=encargado;
		this.quienAutorizo=quienAutorizo;
		this.destino=destino;
		this.prenda=prenda;
	}
}
