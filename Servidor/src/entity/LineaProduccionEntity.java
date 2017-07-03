package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import negocio.LineaProduccion;
import negocio.OrdenProduccionCompleta;
import negocio.OrdenProduccionParcial;

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
	
	@ManyToOne()
	private OrdenDeProduccionEntity orden;
	
	public LineaProduccionEntity(){}
	public LineaProduccionEntity(LineaProduccion lineaProduccion){
		this.numero = lineaProduccion.getNumero();
		this.estado = lineaProduccion.getEstado();
		this.tiempoLiberarse = lineaProduccion.getTiempoLiberarse();
		this.trabajo = lineaProduccion.getTrabajo();
		
		if(lineaProduccion.getOrden() != null){
			if(lineaProduccion.getOrden().getClass().getName().equals("negocio.OrdenProduccionCompleta"))
				this.orden = new OrdenDeProduccionCompletaEntity( (OrdenProduccionCompleta) lineaProduccion.getOrden());
				
			else
				this.orden = new OrdenDeProduccionParcialEntity((OrdenProduccionParcial) lineaProduccion.getOrden());
		}
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
	public OrdenDeProduccionEntity getOrden() {
		return orden;
	}
	public void setOrden(OrdenDeProduccionEntity orden) {
		this.orden = orden;
	}
	
}