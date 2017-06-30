package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import negocio.ItemFactura;

@Entity
@Table(name="ItemFactura")
public class ItemFacturaEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String descripcion;
	private int cantidad;
	
	public ItemFacturaEntity(){}
	
	public ItemFacturaEntity(String descripcion, int cantidad ){
		
		this.descripcion=descripcion;
		this.cantidad= cantidad;
	}
	public ItemFacturaEntity(ItemFactura factura ){
		
		this.id=factura.getId();
		this.descripcion=factura.getDescripcion();
		this.cantidad= factura.getCantidad();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
