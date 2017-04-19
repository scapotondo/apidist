package negocio;

import java.util.Date;

public class OrdenDeCompra {

	private Date fechaGeneracion;
	private Date fechaProbableDespacho;
	private Date fechaRealDespacho;
	private int cantidad;
	private float precioUnitario;
	private OrdenDeProduccion ordenProduccion;
	private Proveedor proveedor;
	
	public OrdenDeCompra(Date fechaGeneracion,Date fechaProbableDespacho,Date fechaRealDespacho,int cantidad,
			float precioUnitario,OrdenDeProduccion ordenProduccion,Proveedor proveedor){
		this.fechaGeneracion=fechaGeneracion;
		this.fechaProbableDespacho=fechaProbableDespacho;
		this.fechaRealDespacho=fechaRealDespacho;
		this.cantidad=cantidad;
		this.precioUnitario=precioUnitario;
		this.ordenProduccion=ordenProduccion;
		this.proveedor=proveedor;
	}
	
	public float calcularPrecioFinal(){
		return this.precioUnitario*this.cantidad;
	}
}
