
package negocio;

import java.util.Date;

import dao.StockMateriaPrimaDao;
import dto.MateriaPrimaDto;
import dto.StockMateriaPrimaDto;
import entity.StockMateriaPrimaEntity;

public class StockMateriaPrima {
	
	private int numero;
	private Date fechaRecepcion;
	private float precioFinalCompra;
	private int cantidad;
	private String ubicacion;
	private MateriaPrima materiaPrima;

	
	public StockMateriaPrima(StockMateriaPrimaEntity stock, MateriaPrima materiaPrima){
		this.numero= stock.getNumero();
		this.fechaRecepcion=stock.getFechaRecepcion();
		this.precioFinalCompra=stock.getPrecioFinalCompra();
		this.cantidad=stock.getCantidad();
		this.ubicacion=stock.getUbicacion();
		this.materiaPrima= materiaPrima;
	}
	
	public StockMateriaPrima(StockMateriaPrimaEntity stock) {
		this(stock, new MateriaPrima(stock.getMateriaPrima()));
	}
	
	public StockMateriaPrima(int numero, Date fechaRecepcion,float precioFinalCompra,int cantidad,String ubicacion,
			MateriaPrima materiaPrima){
		this.numero=numero;
		this.fechaRecepcion=fechaRecepcion;
		this.precioFinalCompra=precioFinalCompra;
		this.cantidad=cantidad;
		this.ubicacion=ubicacion;
		this.materiaPrima=materiaPrima;
	}
	
	public StockMateriaPrima(Date fechaRecepcion,float precioFinalCompra,int cantidad,String ubicacion,
			MateriaPrima materiaPrima){
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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
	
	public StockMateriaPrimaDto toDto(MateriaPrimaDto materiaPrimaDto){
		return new StockMateriaPrimaDto(numero, fechaRecepcion, precioFinalCompra, cantidad, ubicacion, materiaPrimaDto);
	}
	
	public StockMateriaPrimaDto toDto(){
		return this.toDto(this.materiaPrima.toDto());
	}
	
	public void saveMe(){
		StockMateriaPrimaDao.getInstance().CrearStockMateriaPrima(this);
	}
	
	public void updateMe(){
		StockMateriaPrimaDao.getInstance().modificarStockMateriaPrima(this);
	}
	
	public void deleteMe(){
		StockMateriaPrimaDao.getInstance().eliminarStockMateriaPrima(this);
	}
}
