package dto;

import java.io.Serializable;
import java.util.ArrayList;


public class ConfeccionDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Float tiempoProd;
	private String detalle;
	private AreaProduccionDto areaProduccion;
	private ArrayList<InsumoDto> insumos;
	private String estado;
	
	public ConfeccionDto(){}
	public ConfeccionDto(Float tiempoProd, String detalle, AreaProduccionDto areaProduccion, ArrayList<InsumoDto> insumos, String estado){
		this.tiempoProd=tiempoProd;
		this.detalle=detalle;
		this.areaProduccion=areaProduccion;
		this.insumos=insumos;
		this.estado=estado;
	}
	
	public ConfeccionDto(Float tiempoProd, String detalle, AreaProduccionDto areaProduccion, ArrayList<InsumoDto> insumos,
			String estado, int id){
		this.id = id;
		this.tiempoProd=tiempoProd;
		this.detalle=detalle;
		this.areaProduccion=areaProduccion;
		this.insumos=insumos;
		this.estado=estado;
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

	public AreaProduccionDto getAreaProduccion() {
		return areaProduccion;
	}

	public void setAreaProduccion(AreaProduccionDto areaProduccion) {
		this.areaProduccion = areaProduccion;
	}

	public ArrayList<InsumoDto> getInsumos() {
		return insumos;
	}

	public void setInsumos(ArrayList<InsumoDto> insumos) {
		this.insumos = insumos;
	}
	
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return this.detalle;
	}
	
}
