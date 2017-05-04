package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="StockPrenda")
public class StockPrendaEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;
	
	private String color;
	private String talle;
	private Date fecha;
	private float costoProduccion;
	private int cantidad;
	private String ubicacion;
	private String estado;
	
	@ManyToOne(targetEntity=PrendaEntity.class)
	private PrendaEntity prenda;
	
	@OneToOne()
	private OrdenDeProduccionEntity lote;
	
	public StockPrendaEntity(){}
}
