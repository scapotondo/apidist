package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import negocio.OrdenDeCompra;
import negocio.OrdenProduccionCompleta;
import negocio.OrdenProduccionParcial;

@Entity
@Table(name="OrdenDeCompra")
public class OrdenDeCompraEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne()
	private MateriaPrimaEntity materiaPrima;
	
	private Date fechaGeneracion;
	private Date fechaProbableDespacho;
	private Date fechaRealDespacho;
	private int cantidad;
	private float precioUnitario;
	
	@OneToOne()
	@JoinColumn(name="nroOrden")
	private OrdenDeProduccionEntity ordenProduccion;
	
	@OneToOne()
	@JoinColumn(name="proveedor_id")
	private ProveedorEntity proveedor;

	public OrdenDeCompraEntity(){}
	
	public OrdenDeCompraEntity(int id,MateriaPrimaEntity materiaPrima,Date fechaGeneracion,Date fechaProbableDespacho,
			Date fechaRealDespacho,int cantidad,float precioUnitario,OrdenDeProduccionEntity ordenProduccion,ProveedorEntity proveedor){
		this.id=id;
		this.materiaPrima= materiaPrima;
		this.fechaGeneracion=fechaGeneracion;
		this.fechaProbableDespacho=fechaProbableDespacho;
		this.fechaRealDespacho=fechaRealDespacho;
		this.cantidad=cantidad;
		this.precioUnitario=precioUnitario;
		this.ordenProduccion=ordenProduccion;
		this.proveedor=proveedor;
	}
	

	
	public OrdenDeCompraEntity(OrdenDeCompra orden){
		this.id=orden.getId();
		this.fechaGeneracion=orden.getFechaGeneracion();
		this.fechaProbableDespacho=orden.getFechaProbableDespacho();
		this.fechaRealDespacho=orden.getFechaRealDespacho();
		this.cantidad=orden.getCantidad();
		this.precioUnitario=orden.getPrecioUnitario();
		
		if(orden.getOrdenProduccion().getClass().getName().equals("negocio.OrdenProduccionCompleta"))
			this.ordenProduccion=new OrdenDeProduccionCompletaEntity( (OrdenProduccionCompleta) orden.getOrdenProduccion());
		
		if(orden.getOrdenProduccion().getClass().getName().equals("negocio.OrdenProduccionParcial"))
			this.ordenProduccion=new OrdenDeProduccionParcialEntity((OrdenProduccionParcial) orden.getOrdenProduccion());
		
		this.proveedor=new ProveedorEntity(orden.getProveedor());
		this.materiaPrima= new MateriaPrimaEntity(orden.getMateriaPrima());
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

	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	public Date getFechaProbableDespacho() {
		return fechaProbableDespacho;
	}

	public void setFechaProbableDespacho(Date fechaProbableDespacho) {
		this.fechaProbableDespacho = fechaProbableDespacho;
	}

	public Date getFechaRealDespacho() {
		return fechaRealDespacho;
	}

	public void setFechaRealDespacho(Date fechaRealDespacho) {
		this.fechaRealDespacho = fechaRealDespacho;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public OrdenDeProduccionEntity getOrdenProduccion() {
		return ordenProduccion;
	}

	public void setOrdenProduccion(OrdenDeProduccionEntity ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}

	public ProveedorEntity getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorEntity proveedor) {
		this.proveedor = proveedor;
	}
	
	
}
