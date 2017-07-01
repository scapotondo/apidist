
package negocio;

import java.util.Date;

import dao.OrdenDeCompraDao;
import dto.OrdenDeCompraDto;
import entity.OrdenDeCompraEntity;
import entity.OrdenDeProduccionCompletaEntity;
import entity.OrdenDeProduccionParcialEntity;

public class OrdenDeCompra {
	
	public static final String PENDIENTE = "pendiente";
	public static final String REALIZADA = "realizada";
	

	private int id;
	
	private Date fechaGeneracion;
	private Date fechaProbableDespacho;
	private Date fechaRealDespacho;
	private int cantidad;
	private float precioUnitario;
	private OrdenDeProduccion ordenProduccion;
	private Proveedor proveedor;
	private MateriaPrima materiaPrima;
	private String estado;
	

	public OrdenDeCompra(OrdenDeCompraEntity oc){
		this.fechaGeneracion=oc.getFechaGeneracion();
		this.fechaProbableDespacho=oc.getFechaProbableDespacho();
		this.fechaRealDespacho=oc.getFechaRealDespacho();
		this.cantidad=oc.getCantidad();
		this.precioUnitario=oc.getPrecioUnitario();
		this.materiaPrima= new MateriaPrima(oc.getMateriaPrima());
		this.proveedor=new Proveedor(oc.getProveedor());
		
		if(oc.getOrdenProduccion().getClass().getName().equals("entity.OrdenDeProduccionCompletaEntity"))
			this.ordenProduccion=new OrdenProduccionCompleta((OrdenDeProduccionCompletaEntity) oc.getOrdenProduccion());
		
		if(oc.getOrdenProduccion().getClass().getName().equals("entity.OrdenDeProduccionParcialEntity"))
			this.ordenProduccion=new OrdenProduccionParcial((OrdenDeProduccionParcialEntity) oc.getOrdenProduccion());
		
		this.estado = oc.getEstado(); 
	}
	
	public OrdenDeCompra(Date fechaGeneracion,Date fechaProbableDespacho,Date fechaRealDespacho,int cantidad,
			float precioUnitario,OrdenDeProduccion ordenProduccion,Proveedor proveedor, String estado){
		this.fechaGeneracion=fechaGeneracion;
		this.fechaProbableDespacho=fechaProbableDespacho;
		this.fechaRealDespacho=fechaRealDespacho;
		this.cantidad=cantidad;
		this.precioUnitario=precioUnitario;
		this.ordenProduccion=ordenProduccion;
		this.proveedor=proveedor;
		this.estado = estado;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MateriaPrima getMateriaPrima() {
		return materiaPrima;
	}
	
	public void setMateriaPrima(MateriaPrima materiaPrima) {
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

	public OrdenDeProduccion getOrdenProduccion() {
		return ordenProduccion;
	}

	public void setOrdenProduccion(OrdenDeProduccion ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public float calcularPrecioFinal(){
		return this.precioUnitario*this.cantidad;
	}
	
	public OrdenDeCompraDto toDto(){
		return new OrdenDeCompraDto(fechaGeneracion, fechaProbableDespacho, fechaRealDespacho, cantidad, precioUnitario,
				ordenProduccion.toDto(), proveedor.toDto(), id, this.materiaPrima.toDto());
	}
	
	public void saveMe(){
		OrdenDeCompraDao.getInstance().crearOrdenDeCompra(this);
	}
	
	public void modificame(){
		OrdenDeCompraDao.getInstance().modificarOrdenDeCompra(this);
	}
}
