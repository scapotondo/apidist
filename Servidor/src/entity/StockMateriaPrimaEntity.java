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

import negocio.StockMateriaPrima;

@Entity
@Table(name="StockMateriaPrima")
public class StockMateriaPrimaEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne(targetEntity=MateriaPrimaEntity.class)
	private MateriaPrimaEntity materiaPrima;
	
	@OneToOne()
	private OrdenDeCompraEntity lote;
	
	private Date fechaRecepcion;
	private float precioFinalCompra;
	private int cantidad;
	private String ubicacion;
	
	public StockMateriaPrimaEntity(){}
	
	public StockMateriaPrimaEntity(int id, MateriaPrimaEntity materiaPrima,OrdenDeCompraEntity lote,Date fechaRecepcion,
			float precioFinalCompra,int cantidad,String ubicacion){
		
		this.id=id;
		this.materiaPrima=materiaPrima;
		this.lote=lote;
		this.fechaRecepcion=fechaRecepcion;
		this.precioFinalCompra=precioFinalCompra;
		this.cantidad=cantidad;
		this.ubicacion=ubicacion;
	}
	
	public StockMateriaPrimaEntity(StockMateriaPrima mp){
		//TODO: ver como manejar id de StockMateriaPRima porque lo uniboco es el lote supuestamente
	//	this.id=mp.getId();
		this.materiaPrima=new MateriaPrimaEntity(mp.getMateriaPrima());
		this.lote=new OrdenDeCompraEntity(mp.getLote());
		this.fechaRecepcion=mp.getFechaRecepcion();
		this.precioFinalCompra=mp.getPrecioFinalCompra();
		this.cantidad=mp.getCantidad();
		this.ubicacion=mp.getUbicacion();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MateriaPrimaEntity getMateriaPrima() {
		return materiaPrima;
	}

	public void setMateriaPrima(MateriaPrimaEntity materiaPrima) {
		this.materiaPrima = materiaPrima;
	}

	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public float getPrecioFinalCompra() {
		return precioFinalCompra;
	}

	public void setPrecioFinalCompra(float precioFinalCompra) {
		this.precioFinalCompra = precioFinalCompra;
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

	public OrdenDeCompraEntity getLote() {
		return lote;
	}

	public void setLote(OrdenDeCompraEntity lote) {
		this.lote = lote;
	}
	
	
}
