package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import negocio.LineaProduccion;

@Entity
@Table(name="LineaProduccion")
public class LineaProduccionEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int numero;	
	private String estado;
	private Date tiempoLiberarse;
	private String trabajo;
	
	public LineaProduccionEntity(){}
	public LineaProduccionEntity(LineaProduccion lineaProduccion){
		this.numero = lineaProduccion.getNumero();
		this.estado = lineaProduccion.getEstado();
		this.tiempoLiberarse = lineaProduccion.getTiempoLiberarse();
		this.trabajo = lineaProduccion.getTrabajo();
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
	
	
}