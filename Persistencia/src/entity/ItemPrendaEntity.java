package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Embeddable
@Table(name="ItemPrenda")
public class ItemPrendaEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne(targetEntity=PedidoPrendasEntity.class)
	@Embedded
	private PedidoPrendasEntity pedidoPrenda;
	
	private int cantidad;
	private String talle;
	private String color;
	private float importe;
	
	@Embedded
	private PrendaEntity prenda;
	
	@Embedded
	private OrdenDeProduccionEntity lote;
	
	public ItemPrendaEntity(){}
	public ItemPrendaEntity(int cantidad, String talle, String color,float importe, PrendaEntity prenda, OrdenDeProduccionEntity lote ){
		this.cantidad=cantidad;
		this.talle=talle;
		this.color=color;
		this.importe=importe;
		this.prenda=prenda;
	}
	
}
