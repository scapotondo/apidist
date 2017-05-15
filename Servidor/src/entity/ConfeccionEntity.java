package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import negocio.AreaProduccion;
import negocio.Confeccion;
import negocio.Insumo;

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
	private List<AreaProduccionEntity> areasProduccion;
	
	@OneToMany()
	@JoinColumn(name="confeccion_id")
	private List<InsumoEntity> insumos;
	
	public ConfeccionEntity(){}
	public ConfeccionEntity(Confeccion confeccion){
		this.tiempoProd = confeccion.getTiempoProd();
		this.detalle = confeccion.getDetalle();
		this.areasProduccion = new ArrayList<AreaProduccionEntity>();
		if(confeccion.getAreasProduccion() != null){
			for (AreaProduccion areaProduccion : confeccion.getAreasProduccion()) {
				this.areasProduccion.add(new AreaProduccionEntity(areaProduccion));
			}
		}
		this.insumos = new ArrayList<InsumoEntity>();
		if(confeccion.getInsumos() != null){
			for (Insumo insumo : confeccion.getInsumos()) {
				this.insumos.add(new InsumoEntity(insumo));
			}
		}
	}

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

	public List<AreaProduccionEntity> getAreasProduccion() {
		return areasProduccion;
	}

	public void setAreasProduccion(List<AreaProduccionEntity> areaProduccion) {
		this.areasProduccion = areaProduccion;
	}

	public List<InsumoEntity> getInsumos() {
		return insumos;
	}

	public void setInsumos(List<InsumoEntity> insumos) {
		this.insumos = insumos;
	}
	
	
}
