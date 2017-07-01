package dto;

import java.io.Serializable;
import java.util.Date;


public class OrdenDeCompraDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int id;
	private Date fechaGeneracion;
	private Date fechaProbableDespacho;
	private Date fechaRealDespacho;
	private int cantidad;
	private float precioUnitario;
	private OrdenDeProduccionDto ordenProduccion;
	private ProveedorDto proveedor;
	private MateriaPrimaDto materiaPrima;
	
	public OrdenDeCompraDto(){}
	
	public OrdenDeCompraDto(Date fechaGeneracion,Date fechaProbableDespacho,Date fechaRealDespacho,int cantidad,
			float precioUnitario,OrdenDeProduccionDto ordenProduccion,ProveedorDto proveedor, int id, MateriaPrimaDto materiaPrima){
		this.fechaGeneracion=fechaGeneracion;
		this.fechaProbableDespacho=fechaProbableDespacho;
		this.fechaRealDespacho=fechaRealDespacho;
		this.cantidad=cantidad;
		this.precioUnitario=precioUnitario;
		this.ordenProduccion=ordenProduccion;
		this.proveedor=proveedor;
		this.id = id;
		this.materiaPrima = materiaPrima;
	}
	
	

	public MateriaPrimaDto getMateriaPrima() {
		return materiaPrima;
	}



	public void setMateriaPrima(MateriaPrimaDto materiaPrima) {
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

	public OrdenDeProduccionDto getOrdenProduccion() {
		return ordenProduccion;
	}

	public void setOrdenProduccion(OrdenDeProduccionDto ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}

	public ProveedorDto getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorDto proveedor) {
		this.proveedor = proveedor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
