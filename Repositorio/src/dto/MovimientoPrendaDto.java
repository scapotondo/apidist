package dto;

import java.io.Serializable;
import java.util.Date;


public class MovimientoPrendaDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int cantidad;
	private Date fecha;
	private String encargado;
	private String quienAutorizo;
	private String destino;
	private int id;
	private String tipo; 
	private PrendaDto prenda;
	
	public MovimientoPrendaDto(int id,int cantidad, Date fecha, String encargado, String quienAutorizo,
			String destino, PrendaDto prenda, String tipo){
		this.id= id;
		this.cantidad=cantidad;
		this.fecha=fecha;
		this.encargado=encargado;
		this.quienAutorizo=quienAutorizo;
		this.destino=destino;
		this.tipo=tipo;
		this.prenda=prenda;
	}
	
	public PrendaDto getPrenda() {
		return prenda;
	}

	public void setPrenda(PrendaDto prenda) {
		this.prenda = prenda;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
}
