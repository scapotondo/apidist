package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import negocio.MovimientoPrenda;

@Entity
@Table(name="MovimiendoPrenda")
public class MovimientoPrendaEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private int cantidad;
	private Date fecha;
	private String talle;
	private String color;
	private String encargado;
	private String quienAutorizo;
	private String destino;
	
	@ManyToOne()
	@JoinColumn(name="codigoPrenda")
	private PrendaEntity prenda;
	
	public MovimientoPrendaEntity(){}
	
	public MovimientoPrendaEntity(int cantidad, Date fecha, String talle, String color, String encargado, String quienAutorizo,
			String destino){
		
		this.cantidad=cantidad;
		this.fecha=fecha;
		this.talle=talle;
		this.color=color;
		this.encargado=encargado;
		this.quienAutorizo=quienAutorizo;
		this.destino=destino;
	} 
	
	public MovimientoPrendaEntity(MovimientoPrenda movimiento){
		this.id = movimiento.getId();
		this.cantidad=movimiento.getCantidad();
		this.fecha=movimiento.getFecha();
		this.talle=movimiento.getTalle();
		this.color=movimiento.getColor();
		this.encargado=movimiento.getEncargado();
		this.quienAutorizo=movimiento.getQuienAutorizo();
		this.destino=movimiento.getDestino();
	} 

}
