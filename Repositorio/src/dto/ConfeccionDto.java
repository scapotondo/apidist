package dto;

import java.util.ArrayList;


public class ConfeccionDto {
	private int tiempoProd;
	private String detalle;
	private AreaProduccionDto areaProduccion;
	private ArrayList<InsumoDto> insumos;
	
	public ConfeccionDto(int tiempoProd,String detalle,AreaProduccionDto areaProduccion, ArrayList<InsumoDto> insumos){
		this.tiempoProd=tiempoProd;
		this.detalle=detalle;
		this.areaProduccion=areaProduccion;
		this.insumos=insumos;
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
	
}
