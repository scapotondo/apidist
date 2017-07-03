package negocio;

import dao.ProcesoProduccionDao;
import dto.ProcesoProduccionDto;
import entity.ProcesoProduccionEntity;

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
	
	public ProcesoProduccion(ProcesoProduccionEntity pe) {
		this.id = pe.getId();
		this.confeccion = new Confeccion(pe.getConfeccion());
		this.estado = EstadoProcesoProduccion.fromInt(pe.getEstado());
		this.nroOrden = pe.getNroOrden();
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

	public void modificar() {
		ProcesoProduccionDao.getInstance().modificarProceso(this);
	}
}
