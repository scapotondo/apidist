package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import negocio.Confeccion;
import negocio.Insumo;

@Entity
@Table(name="Confeccion")
public class ConfeccionEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private Float tiempoProd;
	private String detalle;
	
	@OneToOne()
	private AreaProduccionEntity areaProduccion;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="confeccion_id")
	private List<InsumoEntity> insumos;
	
	public ConfeccionEntity() { }
	
	public ConfeccionEntity(Confeccion confeccion){
		this.id = confeccion.getId();
		this.tiempoProd = confeccion.getTiempoProd();
		this.detalle = confeccion.getDetalle();
		this.areaProduccion = new AreaProduccionEntity(confeccion.getAreaProduccion());
		
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

	public Float getTiempoProd() {
		return tiempoProd;
	}

	public void setTiempoProd(Float tiempoProd) {
		this.tiempoProd = tiempoProd;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public AreaProduccionEntity getAreaProduccion() {
		return areaProduccion;
	}

	public void setAreaProduccion(AreaProduccionEntity areaProduccion) {
		this.areaProduccion = areaProduccion;
	}

	public List<InsumoEntity> getInsumos() {
		return insumos;
	}

	public void setInsumos(List<InsumoEntity> insumos) {
		this.insumos = insumos;
	}
}
