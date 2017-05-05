package negocio;

import java.util.ArrayList;

import dto.ConfeccionDto;
import dto.InsumoDto;

public class Confeccion {
	
	private int tiempoProd;
	private String detalle;
	private AreaProduccion areaProduccion;
	private ArrayList<Insumo> insumos;
	
	public Confeccion(int tiempoProd,String detalle,AreaProduccion areaProduccion, ArrayList<Insumo> insumos){
		this.tiempoProd=tiempoProd;
		this.detalle=detalle;
		this.areaProduccion=areaProduccion;
		this.insumos=insumos;
	}
	
	public ArrayList<Insumo> getInsumos(){
		return null;
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

	public AreaProduccion getAreaProduccion() {
		return areaProduccion;
	}

	public void setAreaProduccion(AreaProduccion areaProduccion) {
		this.areaProduccion = areaProduccion;
	}

	public void setInsumos(ArrayList<Insumo> insumos) {
		this.insumos = insumos;
	}
	
	public ConfeccionDto toDto(){
		
		ArrayList<InsumoDto> insumosDto= new ArrayList<>();
		for (Insumo insumo : insumos) {
			insumosDto.add(insumo.toDto());
		}
		return new ConfeccionDto(tiempoProd, detalle, areaProduccion.toDto(), insumosDto);
	}
}
