package negocio;

import java.util.Date;

import dao.StockPrendaDao;
import dto.StockPrendaDto;
import entity.StockPrendaEntity;

public class StockPrenda {
	
	
	private ColorPrenda color;
	private String talle;
	private OrdenDeProduccion lote;
	private Date fecha;
	private float costoProduccion;
	private int cantidad;
	private String ubicacion;
	private EstadoStockPrenda estado;
	private Prenda prenda;
	
	
	public StockPrenda(StockPrendaEntity stock){
		this.color=stock.getColor();
		this.talle=stock.getTalle();
		//TODO: ver aca tambien la orden como hacer por ser abstracta
		//this.lote=new OrdenDeProduccion(stock.getLote());
		this.fecha=stock.getFecha();
		this.costoProduccion=stock.getCostoProduccion();
		this.cantidad=stock.getCantidad();
		this.ubicacion=stock.getUbicacion();
		this.estado=stock.getEstado();
		this.prenda=new Prenda(stock.getPrenda());
	}
	
	public StockPrenda(ColorPrenda color,String talle,OrdenDeProduccion lote,Date fecha,float costoProduccion,int cantidad,
			String ubicacion,EstadoStockPrenda estado,Prenda prenda){
		this.color=color;
		this.talle=talle;
		this.lote=lote;
		this.fecha=fecha;
		this.costoProduccion=costoProduccion;
		this.cantidad=cantidad;
		this.ubicacion=ubicacion;
		this.estado=estado;
		this.prenda=prenda;
	}

	public ColorPrenda getColor() {
		return color;
	}

	public void setColor(ColorPrenda color) {
		this.color = color;
	}

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}

	public OrdenDeProduccion getLote() {
		return lote;
	}

	public void setLote(OrdenDeProduccion lote) {
		this.lote = lote;
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

	public EstadoStockPrenda getEstado() {
		return estado;
	}

	public void setEstado(EstadoStockPrenda estado) {
		this.estado = estado;
	}

	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}

	public void disminuirCantidad(int cantidad){
		this.cantidad = this.cantidad - cantidad;
	}
	
	public void saveMe(){
		StockPrendaDao.getInstance().CrearStockPrenda(this);
	}

	public void updateMe(){
		StockPrendaDao.getInstance().ModificarStockPrenda(this);
	}
	
	public void deleteMe(){
		StockPrendaDao.getInstance().EliminarStockPrenda(this);
	}

	public StockPrendaDto toDto(){
		return new StockPrendaDto(color.toString(), talle, lote.toDto(), fecha, costoProduccion, cantidad, ubicacion, estado+"",
				prenda.toDto());
	}

}
