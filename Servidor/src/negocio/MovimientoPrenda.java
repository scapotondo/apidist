package negocio;

import java.util.Date;

import dto.MovimientoPrendaDto;

public class MovimientoPrenda {

	private int cantidad;
	private Date fecha;
	private String talle;
	private String color;
	private String encargado;
	private String quienAutorizo;
	private String destino;
	private Prenda prenda;
	private int id;
	
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

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getEncargado() {
		return encargado;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	public String getQuienAutorizo() {
		return quienAutorizo;
	}

	public void setQuienAutorizo(String quienAutorizo) {
		this.quienAutorizo = quienAutorizo;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}
	
	public MovimientoPrendaDto toDto(){
		return new MovimientoPrendaDto(cantidad, fecha, talle, color, encargado, quienAutorizo, destino, prenda.toDto());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
