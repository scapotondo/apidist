package negocio;

import java.util.Date;

import dao.StockMateriaPrimaDao;
import dto.StockMateriaPrimaDto;
import entity.StockMateriaPrimaEntity;

public class StockMateriaPrima {
	
	private OrdenDeCompra lote;
	private Date fechaRecepcion;
	private float precioFinalCompra;
	private int cantidad;
	private String ubicacion;
	private MateriaPrima materiaPrima;

	
	public StockMateriaPrima(StockMateriaPrimaEntity stock){
		this.lote=new OrdenDeCompra(stock.getLote());
		this.fechaRecepcion=stock.getFechaRecepcion();
		this.precioFinalCompra=stock.getPrecioFinalCompra();
		this.cantidad=stock.getCantidad();
		this.ubicacion=stock.getUbicacion();
		this.materiaPrima= new MateriaPrima(stock.getMateriaPrima());
	}
	
	public StockMateriaPrima(OrdenDeCompra lote,Date fechaRecepcion,float precioFinalCompra,int cantidad,String ubicacion,
			MateriaPrima materiaPrima){
		this.lote=lote;
		this.fechaRecepcion=fechaRecepcion;
		this.precioFinalCompra=precioFinalCompra;
		this.cantidad=cantidad;
		this.ubicacion=ubicacion;
		this.materiaPrima=materiaPrima;
	}

	
	public MateriaPrima getMateriaPrima() {
		return materiaPrima;
	}

	public void setMateriaPrima(MateriaPrima materiaPrima) {
		this.materiaPrima = materiaPrima;
	}

	public OrdenDeCompra getLote() {
		return lote;
	}

	public void setLote(OrdenDeCompra lote) {
		this.lote = lote;
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
	
	
	public void disminuirCantidad(int cantidad){
		this.cantidad= this.cantidad - cantidad;
	}
	
	public StockMateriaPrimaDto toDto(){
		return new StockMateriaPrimaDto(lote.toDto(), fechaRecepcion, precioFinalCompra, cantidad, ubicacion);
	}
	
	public void saveMe(){
		StockMateriaPrimaDao.getInstance().CrearStockMateriaPrima(this);
	}
}
