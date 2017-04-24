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

}
