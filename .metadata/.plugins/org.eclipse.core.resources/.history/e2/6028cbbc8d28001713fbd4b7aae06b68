package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Embeddable
@Table(name="MateriaPrima")
public class MateriaPrimaEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;
	
	@ManyToOne(targetEntity=OrdenDeProduccionEntity.class)
	private OrdenDeProduccionEntity ordenDeProduccion;
	
	private String nombre;
	private int minimo;
	
	@OneToOne()
	private OrdenDeCompraEntity ordenDeCompra;
	
	@OneToMany(mappedBy="materiaPrima")
	private List<StockMateriaPrimaEntity> stock;
	
	public MateriaPrimaEntity(){}
	
}
