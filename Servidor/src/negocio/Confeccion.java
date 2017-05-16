package negocio;

import java.util.ArrayList;

import dto.AreaProduccionDto;
import dto.ConfeccionDto;
import dto.InsumoDto;
import entity.AreaProduccionEntity;
import entity.ConfeccionEntity;
import entity.InsumoEntity;

public class Confeccion {
	
	private int id;
	private int tiempoProd;
	private String detalle;
	private ArrayList<AreaProduccion> areasProduccion;
	private ArrayList<Insumo> insumos;
	
	
	public Confeccion(ConfeccionEntity confeccion){
		this.id=confeccion.getId();
		this.tiempoProd=confeccion.getTiempoProd();
		this.detalle=confeccion.getDetalle();
		this.areasProduccion=new ArrayList<>();
		this.insumos=new ArrayList<>();
		for (AreaProduccionEntity areaProduccionEntity : confeccion.getAreasProduccion()) {
			this.areasProduccion.add(new AreaProduccion(areaProduccionEntity));
		}
		for (InsumoEntity insumoEntity : confeccion.getInsumos()) {
			this.insumos.add(new Insumo(insumoEntity));
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Confeccion(int id, int tiempoProd, String detalle, ArrayList<AreaProduccion> areaProduccion, ArrayList<Insumo> insumos){
		this.id=id;
		this.tiempoProd=tiempoProd;
		this.detalle=detalle;
		this.areasProduccion=areaProduccion;
		this.insumos=insumos;
	}
	
	public Confeccion(int tiempoProd, String detalle, ArrayList<AreaProduccion> areaProduccion, ArrayList<Insumo> insumos){
		this.tiempoProd=tiempoProd;
		this.detalle=detalle;
		this.areasProduccion=areaProduccion;
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

	public ArrayList<AreaProduccion> getAreasProduccion() {
		return areasProduccion;
	}

	public void setAreasProduccion(ArrayList<AreaProduccion> areaProduccion) {
		this.areasProduccion = areaProduccion;
	}

	public void setInsumos(ArrayList<Insumo> insumos) {
		this.insumos = insumos;
	}
	
	public ConfeccionDto toDto(){
		
		ArrayList<InsumoDto> insumosDto= new ArrayList<>();
		for (Insumo insumo : this.insumos) {
			insumosDto.add(insumo.toDto());
		}
		
		ArrayList<AreaProduccionDto> areasProduccionDto = new ArrayList<>();
		for (AreaProduccion areaProduccion2 : this.areasProduccion) {
			areasProduccionDto.add(areaProduccion2.toDto());
		}
		
		return new ConfeccionDto(tiempoProd, detalle,areasProduccionDto, insumosDto);
	}
}
