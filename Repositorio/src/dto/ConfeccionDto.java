package dto;

import java.io.Serializable;
import java.util.ArrayList;


public class ConfeccionDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Float tiempoProd;
	private String detalle;
	private AreaProduccionDto areaProduccion;
	private ArrayList<InsumoDto> insumos;
	
	public ConfeccionDto(Float tiempoProd, String detalle, AreaProduccionDto areaProduccion, ArrayList<InsumoDto> insumos){
		this.tiempoProd=tiempoProd;
		this.detalle=detalle;
		this.areaProduccion=areaProduccion;
		this.insumos=insumos;
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
	
	@Override
	public String toString() {
		return this.detalle;
	}
	
}
