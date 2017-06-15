package negocio;

import java.util.ArrayList;

import dto.AreaProduccionDto;
import dto.LineaProduccionDto;
import dto.OrdenDeProduccionDto;
import entity.AreaProduccionEntity;
import entity.LineaProduccionEntity;

public class AreaProduccion {

	private String nombre;
	private ArrayList<LineaProduccion> lineasProduccion;
	private ArrayList<OrdenDeProduccion> ordenesProduccion;
	private int codigo;
	
	public AreaProduccion(AreaProduccionEntity area){
		this.codigo=area.getCodigo();
		this.nombre=area.getNombre();
		this.lineasProduccion=new ArrayList<>();
		for (LineaProduccionEntity lineaProduccionEntity : area.getLineasProduccion()) {
			this.lineasProduccion.add(new LineaProduccion(lineaProduccionEntity));
		}
		//falta
//		this.ordenesProduccion=new ArrayList<>();
//		for (OrdenDeProduccionEntity OrdenDeProduccionEntity : area.getOrdenesProduccion()) {
			//TODO: ver esto, falla por ser abstracta la clase
			//this.ordenesProduccion.add(new OrdenDeProduccion(OrdenDeProduccionEntity);
//			OrdenDeProduccionEntity.getClass();
//		}
	}
	
	public AreaProduccion(String nombre, ArrayList<LineaProduccion> lineasProduccion, ArrayList<OrdenDeProduccion> ordenesProduccion){
		this.nombre=nombre;
		this.lineasProduccion= lineasProduccion;
		this.ordenesProduccion=ordenesProduccion;
	}
	
	public AreaProduccion(int codigo, String nombre, ArrayList<LineaProduccion> lineasProduccion, ArrayList<OrdenDeProduccion> ordenesProduccion){
		this.codigo = codigo;
		this.nombre=nombre;
		this.lineasProduccion= lineasProduccion;
		this.ordenesProduccion=ordenesProduccion;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	
	
	public void asignarLineaProduccion(Confeccion confeccion, MateriaPrima materia, String ubicacion){
		if(hayLineasLibres()){
			LineaProduccion linea = lineasProduccion.get(0);
			String trabajo = confeccion.getDetalle() + " con " + materia.getNombre() + " en " + ubicacion;
			
			linea.asignarTrabajo(trabajo, confeccion.getTiempoProd());
		}
	}
	
	public boolean hayLineasLibres(){
		for (LineaProduccion lineaProduccion : this.lineasProduccion) {
			if(lineaProduccion.getEstado().equals(LineaProduccion.LIBRE))	
				return true;
		}
		
		return false;
	}

	public void agregarOrdenProduccion(OrdenDeProduccion orden){
		this.ordenesProduccion.add(orden);
	}
	
	public void liberarLineaProduccion(int nroLinea){
		for (LineaProduccion lineaProduccion : this.lineasProduccion) {
			if(lineaProduccion.getNumero() == nroLinea)
				lineaProduccion.Liberar();
		}
	}
	
	public AreaProduccionDto toDto(){
		ArrayList<LineaProduccionDto> lineasProduccionDto = new ArrayList<>();
		ArrayList<OrdenDeProduccionDto> ordenesProduccionDto = new ArrayList<>();
		
		for (LineaProduccion lineaDeProduccion : lineasProduccion) {
			lineasProduccionDto.add(lineaDeProduccion.toDto());
		}
//		for (OrdenDeProduccion ordenDeProduccion : ordenesProduccion) {
//			ordenesProduccionDto.add(ordenDeProduccion.toDto());
//		}
		return new AreaProduccionDto(this.codigo,nombre, lineasProduccionDto, ordenesProduccionDto);
	}
}
