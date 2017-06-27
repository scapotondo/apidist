package entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import negocio.ItemPrenda;

@Entity
@Embeddable
@Table(name="ItemPrenda")
public class ItemPrendaEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int cantidad;
	private String talle;
	private String color;
	private float importe;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="codigo")
	private PrendaEntity prenda;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="nroOrden")
	private OrdenDeProduccionEntity lote;
	
	public ItemPrendaEntity(){}
	
	public ItemPrendaEntity(int cantidad, String talle, String color,float importe, PrendaEntity prenda, OrdenDeProduccionEntity lote ){
		this.cantidad=cantidad;
		this.talle=talle;
		this.color=color;
		this.importe=importe;
		this.prenda=prenda;
		this.lote = lote;
	}
	
	public ItemPrendaEntity(ItemPrenda itemPrenda){
		this.id = itemPrenda.getId();
		this.cantidad = itemPrenda.getCantidad();
		this.talle = itemPrenda.getTalle();
		this.color = itemPrenda.getColor();
		this.importe = itemPrenda.getImporte();
		this.prenda = new PrendaEntity(itemPrenda.getPrenda());
		//TODO shevisar aca tambien
		//this.lote = new ordendeproducc
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getTalle() {
		return talle;
	}
	public void setTalle(String talle) {
		this.talle = talle;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	public PrendaEntity getPrenda() {
		return prenda;
	}
	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}
	public OrdenDeProduccionEntity getLote() {
		return lote;
	}
	public void setLote(OrdenDeProduccionEntity lote) {
		this.lote = lote;
	}
	
	
}
