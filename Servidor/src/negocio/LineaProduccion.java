package negocio;

import java.util.Date;

import dto.LineaProduccionDto;
import entity.LineaProduccionEntity;

public class LineaProduccion {
	private int numero;
	private String estado;
	private Date tiempoLiberarse;
	private String trabajo;
	
	public LineaProduccion(LineaProduccionEntity linea){
		this.numero=linea.getNumero();
		this.estado= linea.getEstado();
		this.tiempoLiberarse=linea.getTiempoLiberarse();
		this.trabajo=linea.getTrabajo();
	}
	
	public LineaProduccion(int numero, String estado, Date tiempoLiberarse, String trabajo){
		this.numero=numero;
		this.estado= estado;
		this.tiempoLiberarse=tiempoLiberarse;
		this.trabajo=trabajo;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getTiempoLiberarse() {
		return tiempoLiberarse;
	}

	public void setTiempoLiberarse(Date tiempoLiberarse) {
		this.tiempoLiberarse = tiempoLiberarse;
	}

	public String getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}

	public void asignarTrabajo(String trabajo, Date tiempo){
		
	}
	
	public LineaProduccionDto toDto(){
		return new LineaProduccionDto(numero, estado, tiempoLiberarse, trabajo);
	}

}
