package negocio;

import java.util.ArrayList;

import dto.AreaProduccionDto;
import dto.LineaProduccionDto;
import dto.OrdenDeProduccionDto;

public class AreaProduccion {

	private String nombre;
	private ArrayList<LineaProduccion> lineasProduccion;
	private ArrayList<OrdenDeProduccion> ordenesProduccion;
	
	public AreaProduccion(String nombre,ArrayList<LineaProduccion> lineasProduccion,ArrayList<OrdenDeProduccion> ordenesProduccion){
		this.nombre=nombre;
		this.lineasProduccion= lineasProduccion;
		this.ordenesProduccion=ordenesProduccion;
	}
	
	public void asignarLineaProduccion(Confeccion confeccion, MateriaPrima materia, String ubicacion){
		
	}
	
	public boolean hayLineasLibres(){
		return true;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<LineaProduccion> getLineasProduccion() {
		return lineasProduccion;
	}

	public void setLineasProduccion(ArrayList<LineaProduccion> lineasProduccion) {
		this.lineasProduccion = lineasProduccion;
	}

	public ArrayList<OrdenDeProduccion> getOrdenesProduccion() {
		return ordenesProduccion;
	}

	public void setOrdenesProduccion(ArrayList<OrdenDeProduccion> ordenesProduccion) {
		this.ordenesProduccion = ordenesProduccion;
	}

	public void agregarOrdenProduccion(OrdenDeProduccion orden){
		
	}
	
	public AreaProduccionDto toDto(){
		ArrayList<LineaProduccionDto> lineasProduccionDto = new ArrayList<>();
		ArrayList<OrdenDeProduccionDto> ordenesProduccionDto = new ArrayList<>();
		
		for (LineaProduccion lineaDeProduccion : lineasProduccion) {
			lineasProduccionDto.add(lineaDeProduccion.toDto());
		}
		for (OrdenDeProduccion ordenDeProduccion : ordenesProduccion) {
			ordenesProduccionDto.add(ordenDeProduccion.toDto());
		}
		return new AreaProduccionDto(nombre, lineasProduccionDto, ordenesProduccionDto);
	}
}
