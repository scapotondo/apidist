package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import negocio.StockPrenda;

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
	
	public StockPrendaEntity(String color,String talle, Date fecha, float costoProduccion, int cantidad, String ubicacion,
			String estado,PrendaEntity prenda,OrdenDeProduccionEntity lote){
		
		this.color=color;
		this.talle=talle;
		this.fecha=fecha;
		this.costoProduccion=costoProduccion;
		this.cantidad=cantidad;
		this.ubicacion=ubicacion;
		this.estado=estado;
		this.prenda=prenda;
		this.lote=lote;
	}
	
	public StockPrendaEntity(StockPrenda sp){
		//terminar
		this.color=sp.getColor();
		this.talle=sp.getTalle();
		this.fecha=sp.getFecha();
		this.costoProduccion=sp.getCostoProduccion();
		this.cantidad=sp.getCantidad();
		this.ubicacion=sp.getUbicacion();
		this.estado=sp.getEstado();
		if(sp.getPrenda()!= null)
			this.prenda=new PrendaEntity(sp.getPrenda());
		else
			this.prenda=new PrendaEntity();
		//TODO: revisar aca las op 
//		if(sp.getLote()!= null)
//			this.lote=new OrdenDeProduccionEntity(sp.getLote());
//		else
//			this.lote=new OrdenDeProduccionEntity();
	}
	
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getCostoProduccion() {
		return costoProduccion;
	}

	public void setCostoProduccion(float costoProduccion) {
		this.costoProduccion = costoProduccion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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
