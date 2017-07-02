package negocio;

import java.util.ArrayList;

import dao.ConfeccionDao;
import dto.ConfeccionDto;
import dto.InsumoDto;
import entity.ConfeccionEntity;
import entity.InsumoEntity;

public class Confeccion {
	
	private int id;
	private Float tiempoProd;
	private String detalle;
	private AreaProduccion areaProduccion;
	private ArrayList<Insumo> insumos;
	private EstadoConfeccion estado;
	
	public Confeccion(){}
	
	public Confeccion(ConfeccionEntity confeccion){
		this.id=confeccion.getId();
		this.tiempoProd=confeccion.getTiempoProd();
		this.detalle=confeccion.getDetalle();
		this.areaProduccion=new AreaProduccion(confeccion.getAreaProduccion());
		this.insumos=new ArrayList<>();
		
		for (InsumoEntity insumoEntity : confeccion.getInsumos()) {
			this.insumos.add(new Insumo(insumoEntity));
		}
		this.estado = EstadoConfeccion.fromInt(confeccion.getEstado());
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Confeccion(int id, Float tiempoProd, String detalle, AreaProduccion areaProduccion, ArrayList<Insumo> insumos, EstadoConfeccion estado){
		this.id=id;
		this.tiempoProd=tiempoProd;
		this.detalle=detalle;
		this.areaProduccion=areaProduccion;
		this.insumos=insumos;
		this.estado = estado;
	}
	
	public Confeccion(Float tiempoProd, String detalle, AreaProduccion areaProduccion, ArrayList<Insumo> insumos, EstadoConfeccion estado){
		this.tiempoProd = tiempoProd;
		this.detalle = detalle;
		this.areaProduccion = areaProduccion;
		this.insumos = insumos;
		this.estado = estado;
	}
	
	public ArrayList<Insumo> getInsumos(){
		return insumos;
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

	public AreaProduccion getAreaProduccion() {
		return areaProduccion;
	}

	public void setAreaProduccion(AreaProduccion areaProduccion) {
		this.areaProduccion = areaProduccion;
	}

	public void setInsumos(ArrayList<Insumo> insumos) {
		this.insumos = insumos;
	}
	
	public EstadoConfeccion getEstado() {
		return estado;
	}

	public void setEstado(EstadoConfeccion estado) {
		this.estado = estado;
	}

	public ConfeccionDto toDto(){
		ArrayList<InsumoDto> insumosDto= new ArrayList<>();
		for (Insumo insumo : this.insumos) {
			insumosDto.add(insumo.toDto());
		}
		
		return new ConfeccionDto(tiempoProd, detalle, areaProduccion.toDto(), insumosDto, estado.toString(), id);
	}
	
	public void saveMe() {
		ConfeccionDao.getInstance().crearConfeccion(this);
	}
	
	public String toString() {
		return this.detalle;
	}
}
