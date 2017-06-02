package dto;

import java.io.Serializable;
import java.util.Date;


public class MovimientoMateriaPrimaDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String estado;
	private int cantidad;
	private Date fecha;
	private MateriaPrimaDto materiaPrima;
	private int id;
	
	public MovimientoMateriaPrimaDto(int id,String estado, int cantidad, Date fecha, MateriaPrimaDto materiaPrima){
		this.id=id;
		this.estado=estado;
		this.cantidad=cantidad;
		this.fecha=fecha;
		this.materiaPrima=materiaPrima;
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

	public MateriaPrimaDto getMateriaPrima() {
		return materiaPrima;
	}

	public void setMateriaPrima(MateriaPrimaDto materiaPrima) {
		this.materiaPrima = materiaPrima;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
