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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public boolean getEsDiscontinuo() {
		return esDiscontinuo;
	}

	public void setEsDiscontinuo(boolean esDiscontinuo) {
		this.esDiscontinuo = esDiscontinuo;
	}

	public int getCantidadAProducir() {
		return cantidadAProducir;
	}

	public void setCantidadAProducir(int cantidadAProducir) {
		this.cantidadAProducir = cantidadAProducir;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPorsentajeGanancia() {
		return porsentajeGanancia;
	}

	public void setPorsentajeGanancia(float porsentajeGanancia) {
		this.porsentajeGanancia = porsentajeGanancia;
	}

	public List<String> getTallesValidos() {
		return tallesValidos;
	}

	public void setTallesValidos(List<String> tallesValidos) {
		this.tallesValidos = tallesValidos;
	}

	public List<String> getColoresValidos() {
		return coloresValidos;
	}

	public void setColoresValidos(List<String> coloresValidos) {
		this.coloresValidos = coloresValidos;
	}

	public List<ConfeccionEntity> getConfecciones() {
		return confecciones;
	}

	public void setConfecciones(List<ConfeccionEntity> confecciones) {
		this.confecciones = confecciones;
	}

	public List<StockPrendaEntity> getStock() {
		return stock;
	}

	public void setStock(List<StockPrendaEntity> stock) {
		this.stock = stock;
	}
	
	
}
