package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import negocio.MovimientoMateriaPrima;

@Entity
@Table(name="MovimientoMateriaPrima")
public class MovimientoMateriaPrimaEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String estado;
	private int cantidad;
	private Date fecha;
	
	@ManyToOne()
	@JoinColumn(name="codigoMP")
	private MateriaPrimaEntity materiaPrima;
	
	public MovimientoMateriaPrimaEntity(){}
	public MovimientoMateriaPrimaEntity(MovimientoMateriaPrima movimientoMateriaPrima){
		this.id = movimientoMateriaPrima.getId();
		this.estado = movimientoMateriaPrima.getEstado();
		this.cantidad = movimientoMateriaPrima.getCantidad();
		this.fecha = movimientoMateriaPrima.getFecha();
		this.materiaPrima = new MateriaPrimaEntity(movimientoMateriaPrima.getMateriaPrima());
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public MateriaPrimaEntity getMateriaPrima() {
		return materiaPrima;
	}
	public void setMateriaPrima(MateriaPrimaEntity materiaPrima) {
		this.materiaPrima = materiaPrima;
	}
	
}
