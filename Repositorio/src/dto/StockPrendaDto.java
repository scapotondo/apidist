package dto;

import java.io.Serializable;
import java.util.Date;


public class StockPrendaDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int codigo;
	private String color;
	private String talle;
	private OrdenDeProduccionDto lote;
	private Date fecha;
	private float costoProduccion;
	private int cantidad;
	private String ubicacion;
	private int cantidadPrendasReservadas;
	private PrendaDto prenda;
	
	public StockPrendaDto(int codigo) {
		this.codigo=codigo;
	}
	
	public StockPrendaDto(int codigo, String color,String talle,OrdenDeProduccionDto lote,Date fecha,float costoProduccion,int cantidad,
			String ubicacion,int cantidadPrendasReservadas,PrendaDto prenda){
		this.codigo=codigo;
		this.color=color;
		this.talle=talle;
		this.lote=lote;
		this.fecha=fecha;
		this.costoProduccion=costoProduccion;
		this.cantidad=cantidad;
		this.ubicacion=ubicacion;
		this.cantidadPrendasReservadas=cantidadPrendasReservadas;
		this.prenda=prenda;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}

	public OrdenDeProduccionDto getLote() {
		return lote;
	}

	public void setLote(OrdenDeProduccionDto lote) {
		this.lote = lote;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getCostoProduccion() {
		return costoProduccion;
	}

	public void setCostoProduccion(float costoProduccion) {
		this.costoProduccion = costoProduccion;
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



	public int getCantidadPrendasReservadas() {
		return cantidadPrendasReservadas;
	}

	public void setCantidadPrendasReservadas(int cantidadPrendasReservadas) {
		this.cantidadPrendasReservadas = cantidadPrendasReservadas;
	}

	public PrendaDto getPrenda() {
		return prenda;
	}

	public void setPrenda(PrendaDto prenda) {
		this.prenda = prenda;
	}

	
}
