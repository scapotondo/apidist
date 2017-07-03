package entity;

import java.io.Serializable;

import javax.persistence.*;

import negocio.ProcesoProduccion;

@Entity
@Table(name = "ProcesoProduccion")
public class ProcesoProduccionEntity implements Serializable {

	private static final long serialVersionUID = 3163887964848617147L;

	@Id()
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne()
	private ConfeccionEntity confeccion;
	
	@Column(nullable = false)
	int estado;
	
	int nroOrden;
	
	public ProcesoProduccionEntity() {}

	public ProcesoProduccionEntity(ProcesoProduccion proceso) {
		this.id = proceso.getId();
		this.confeccion = new ConfeccionEntity(proceso.getConfeccion());
		this.estado = proceso.getEstado().toInt();
		this.nroOrden = proceso.getNroOrden();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ConfeccionEntity getConfeccion() {
		return confeccion;
	}

	public void setConfeccion(ConfeccionEntity confeccion) {
		this.confeccion = confeccion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getNroOrden() {
		return nroOrden;
	}

	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}
}
