package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Confeccion")
public class ConfeccionEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private int tiempoProd;
	private String detalle;
	
	@OneToMany()
	@JoinColumn(name="confeccion_id")
	private List<AreaProduccionEntity> areaProduccion;
	
	@OneToMany()
	@JoinColumn(name="confeccion_id")
	private List<InsumoEntity> insumos;
	
	public ConfeccionEntity(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTiempoProd() {
		return tiempoProd;
	}

	public void setTiempoProd(int tiempoProd) {
		this.tiempoProd = tiempoProd;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public List<AreaProduccionEntity> getAreaProduccion() {
		return areaProduccion;
	}

	public void setAreaProduccion(List<AreaProduccionEntity> areaProduccion) {
		this.areaProduccion = areaProduccion;
	}

	public List<InsumoEntity> getInsumos() {
		return insumos;
	}

	public void setInsumos(List<InsumoEntity> insumos) {
		this.insumos = insumos;
	}
	
	
}
