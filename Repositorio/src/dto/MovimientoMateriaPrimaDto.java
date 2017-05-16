package dto;

import java.util.Date;


public class MovimientoMateriaPrimaDto {
	
	private String estado;
	private int cantidad;
	private Date fecha;
	private MateriaPrimaDto materiaPrima;
	
	public MovimientoMateriaPrimaDto(String estado, int cantidad, Date fecha, MateriaPrimaDto materiaPrima){
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
	
}