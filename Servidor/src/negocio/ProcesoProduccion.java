package negocio;

import dto.ProcesoProduccionDto;

public class ProcesoProduccion {
	int id;
	int nroOrden;
	Confeccion confeccion;
	EstadoProcesoProduccion estado;
	
	public ProcesoProduccion(int orden, Confeccion confeccion, EstadoProcesoProduccion estado) {
		nroOrden = orden;
		this.confeccion = confeccion;
		this.estado = estado;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNroOrden() {
		return nroOrden;
	}
	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}
	public Confeccion getConfeccion() {
		return confeccion;
	}
	public void setConfeccion(Confeccion confeccion) {
		this.confeccion = confeccion;
	}
	public EstadoProcesoProduccion getEstado() {
		return estado;
	}
	public void setEstado(EstadoProcesoProduccion estado) {
		this.estado = estado;
	}

	public ProcesoProduccionDto toDto() {
		return new ProcesoProduccionDto(id, nroOrden, confeccion.toDto(), estado.toString());
	}
}
