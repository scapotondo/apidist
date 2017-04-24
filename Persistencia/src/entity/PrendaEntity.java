package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
@Embeddable
@Table(name="Prenda")
public class PrendaEntity implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;
	
	private boolean esDiscontinuo;
	private int cantidadAProducir;
	private String nombre;
	private String descripcion;
	private float porsentajeGanancia;
	
	@ElementCollection
	private List<String> tallesValidos;
	
	@ElementCollection
	private List<String> coloresValidos;

	@OneToMany()
	@JoinColumn(name="prenda_id")
	private List<ConfeccionEntity> confecciones;
	
	@OneToMany(mappedBy="prenda")
	private List<StockPrendaEntity> stock;
	
	public PrendaEntity(){}
}
