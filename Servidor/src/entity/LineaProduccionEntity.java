package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import negocio.LineaProduccion;

@Entity
@Table(name="LineaProduccion")
public class LineaProduccionEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int numero;	
	private String estado;
	private Float tiempoLiberarse;
	private String trabajo;
	
	private int codigoOrden;
	
	public LineaProduccionEntity(){}
	public LineaProduccionEntity(LineaProduccion lineaProduccion){
		this.numero = lineaProduccion.getNumero();
		this.estado = lineaProduccion.getEstado();
		this.tiempoLiberarse = lineaProduccion.getTiempoLiberarse();
		this.trabajo = lineaProduccion.getTrabajo();
		this.codigoOrden = lineaProduccion.getCodigoOrden();
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
	public int getCodigoOrden() {
		return codigoOrden;
	}
	public void setCodigoOrden(int codigoOrden) {
		this.codigoOrden = codigoOrden;
	}
	
	
}