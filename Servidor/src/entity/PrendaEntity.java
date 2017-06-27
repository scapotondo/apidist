package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import negocio.ColorPrenda;
import negocio.Confeccion;
import negocio.Prenda;
import negocio.StockPrenda;


@Entity
@Embeddable
@Table(name="Prenda")
public class PrendaEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
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
	private List<Integer> coloresValidos;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="prenda_id")
	private List<ConfeccionEntity> confecciones;
	
	@OneToMany(mappedBy="prenda", cascade = CascadeType.ALL)
	private List<StockPrendaEntity> stock;
	
	public PrendaEntity(){}
	
	public PrendaEntity(int codigo, boolean esDiscontinuo, int cantidadAProducir, String nombre, String descripcion, 
			float porsentajeGanancia, ArrayList<String>tallesValidos, ArrayList<Integer>coloresValidos,
			ArrayList<ConfeccionEntity> confecciones, ArrayList<StockPrendaEntity> stock){
		
		this.codigo=codigo;
		this.esDiscontinuo=esDiscontinuo;
		this.cantidadAProducir=cantidadAProducir;
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.porsentajeGanancia=porsentajeGanancia;
		
		if(tallesValidos!=null)
			this.tallesValidos=tallesValidos;
		else
			this.tallesValidos= new ArrayList<>();
		
		if(coloresValidos!=null)
			this.coloresValidos=coloresValidos;
		else
			this.coloresValidos=new ArrayList<>();
		
		if(confecciones!=null)
			this.confecciones=confecciones;
		else
			this.confecciones= new ArrayList<>();
		
		if(stock!=null)
			this.stock=stock;
		else
			this.stock=new ArrayList<>();
	}

	public PrendaEntity(Prenda prenda){
		this.codigo=prenda.getCodigo();
		this.esDiscontinuo=prenda.getEsDiscontinuo();
		this.cantidadAProducir=prenda.getCantidadAProducir();
		this.nombre=prenda.getNombre();
		this.descripcion=prenda.getDescripcion();
		this.porsentajeGanancia=prenda.getPorsentajeGanancia();
		this.tallesValidos= new ArrayList<>();
		this.coloresValidos=new ArrayList<>();
		this.confecciones= new ArrayList<ConfeccionEntity>();
		this.stock=new ArrayList<>();
		
		if(prenda.getTallesValidos()!=null)
			this.tallesValidos=prenda.getTallesValidos();
		
		if(prenda.getColoresValidos()!=null)
			for (ColorPrenda color : prenda.getColoresValidos())
				this.coloresValidos.add(color.toInt());
		
		if(prenda.getConfecciones()!=null)
			for (Confeccion confeccion : prenda.getConfecciones())
				this.confecciones.add(new ConfeccionEntity(confeccion));
	
		if(stock!=null)
			for (StockPrenda stock : prenda.getStock())
				this.stock.add(new StockPrendaEntity(stock));
	}
		
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

	public List<Integer> getColoresValidos() {
		return coloresValidos;
	}

	public void setColoresValidos(List<Integer> coloresValidos) {
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
