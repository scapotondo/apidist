package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import negocio.StockMateriaPrima;

@Entity
@Table(name="StockMateriaPrima")
public class StockMateriaPrimaEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int numero;
	
	@ManyToOne()
	private MateriaPrimaEntity materiaPrima;
	
	private Date fechaRecepcion;
	private float precioFinalCompra;
	private int cantidad;
	private String ubicacion;
	
	public StockMateriaPrimaEntity(){}
	
	public StockMateriaPrimaEntity(StockMateriaPrima mp){
		this(mp, new MateriaPrimaEntity(mp.getMateriaPrima()));
	}

	public StockMateriaPrimaEntity(StockMateriaPrima mp, MateriaPrimaEntity mpEntity){
		this.numero=mp.getNumero();
		this.materiaPrima=mpEntity;
		this.fechaRecepcion=mp.getFechaRecepcion();
		this.precioFinalCompra=mp.getPrecioFinalCompra();
		this.cantidad=mp.getCantidad();
		this.ubicacion=mp.getUbicacion();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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

}
