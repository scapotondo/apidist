package dto;

import java.io.Serializable;

public class ProcesoProduccionDto implements Serializable{
	private static final long serialVersionUID = 5641623586629673532L;
	
	int id;
	int nroOrden;
	ConfeccionDto confeccion;
	String estado;

	public ProcesoProduccionDto(int id, int nroOrden, ConfeccionDto confeccion, String estado) {
		this.id = id;
		this.nroOrden = nroOrden;
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
	public ConfeccionDto getConfeccion() {
		return confeccion;
	}
	public void setConfeccion(ConfeccionDto confeccion) {
		this.confeccion = confeccion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
