package negocio;

import java.util.Date;

import dto.MovimientoMateriaPrimaDto;
import entity.MovimientoMateriaPrimaEntity;

public class MovimientoMateriaPrima {

	private String estado;
	private int cantidad;
	private Date fecha;
	private MateriaPrima materiaPrima;
	private int id;
	
	public MovimientoMateriaPrima(int id,String estado, int cantidad, Date fecha, MateriaPrima materiaPrima){
		this.id=id;
		this.estado=estado;
		this.cantidad=cantidad;
		this.fecha=fecha;
		this.materiaPrima=materiaPrima;
	}
	
	public MovimientoMateriaPrima(MovimientoMateriaPrimaEntity movimiento){
		this.id=movimiento.getId();
		this.estado=movimiento.getEstado();
		this.cantidad=movimiento.getCantidad();
		this.fecha=movimiento.getFecha();
		this.materiaPrima=new MateriaPrima(movimiento.getMateriaPrima());
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

	public MateriaPrima getMateriaPrima() {
		return materiaPrima;
	}

	public void setMateriaPrima(MateriaPrima materiaPrima) {
		this.materiaPrima = materiaPrima;
	}
	
	public MovimientoMateriaPrimaDto toDto(){
		return new MovimientoMateriaPrimaDto(id,estado, cantidad, fecha, materiaPrima.toDto());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
