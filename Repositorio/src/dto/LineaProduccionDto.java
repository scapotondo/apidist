package dto;

import java.io.Serializable;

public class LineaProduccionDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int numero;
	private String estado;
	private Float tiempoLiberarse;
	private String trabajo;
	
	public LineaProduccionDto(int numero, String estado, Float tiempoLiberarse, String trabajo){
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

	public Float getTiempoLiberarse() {
		return tiempoLiberarse;
	}

	public void setTiempoLiberarse(Float tiempoLiberarse) {
		this.tiempoLiberarse = tiempoLiberarse;
	}

	public String getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}
	
}
