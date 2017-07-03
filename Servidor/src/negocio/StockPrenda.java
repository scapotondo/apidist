
package negocio;

import java.util.Date;

import dao.StockPrendaDao;
import dto.PrendaDto;
import dto.StockPrendaDto;
import entity.OrdenDeProduccionCompletaEntity;
import entity.OrdenDeProduccionParcialEntity;
import entity.StockPrendaEntity;
import exceptions.ColorException;

public class StockPrenda {
	
	private OrdenDeProduccion lote;
	private Prenda prenda;
	private ColorPrenda color;
	private String talle;
	private Date fecha;
	private float costoProduccion;
	private int cantidad;
	private String ubicacion;
	private int cantidadPrendasReservadas;
	private int codigo;
	
	public StockPrenda(StockPrendaEntity stock, Prenda prenda){
		try {
			this.codigo=stock.getCodigo();
			this.color=ColorPrenda.fromInt(stock.getColor());
			this.talle=stock.getTalle();
	
			if(stock.getLote().getClass().getName().equals("entity.OrdenDeProduccionCompletaEntity"))
				this.lote=new OrdenProduccionCompleta((OrdenDeProduccionCompletaEntity) stock.getLote(), prenda);
			
			if(stock.getLote().getClass().getName().equals("entity.OrdenDeProduccionParcialEntity"))
				this.lote=new OrdenProduccionParcial((OrdenDeProduccionParcialEntity) stock.getLote(), prenda);
			
			this.fecha=stock.getFecha();
			this.costoProduccion=stock.getCostoProduccion();
			this.cantidad=stock.getCantidad();
			this.ubicacion=stock.getUbicacion();
			this.cantidadPrendasReservadas=stock.getCantidadPrendasReservadas();
			this.prenda=prenda;
		} catch (ColorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public StockPrenda(StockPrendaEntity stock){
		try {
			this.codigo=stock.getCodigo();
			this.color=ColorPrenda.fromInt(stock.getColor());
			this.talle=stock.getTalle();
	
			if(stock.getLote().getClass().getName().equals("entity.OrdenDeProduccionCompletaEntity"))
				this.lote=new OrdenProduccionCompleta((OrdenDeProduccionCompletaEntity) stock.getLote());
			
			if(stock.getLote().getClass().getName().equals("entity.OrdenDeProduccionParcialEntity"))
				this.lote=new OrdenProduccionParcial((OrdenDeProduccionParcialEntity) stock.getLote());
			
			this.fecha=stock.getFecha();
			this.costoProduccion=stock.getCostoProduccion();
			this.cantidad=stock.getCantidad();
			this.ubicacion=stock.getUbicacion();
			this.cantidadPrendasReservadas=stock.getCantidadPrendasReservadas();
			this.prenda=new Prenda(stock.getPrenda());
		} catch (ColorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public StockPrenda(ColorPrenda color, String talle, OrdenDeProduccion lote, Date fecha, float costoProduccion, int cantidad,
			String ubicacion, Prenda prenda){
		this.color=color;
		this.talle=talle;
		this.lote=lote;
		this.fecha=fecha;
		this.costoProduccion=costoProduccion;
		this.cantidad=cantidad;
		this.ubicacion=ubicacion;
		this.cantidadPrendasReservadas=0;
		this.prenda=prenda;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public int getCantidadPrendasReservadas() {
		return cantidadPrendasReservadas;
	}

	public void setCantidadPrendasReservadas(int cantidadPrendasReservadas) {
		this.cantidadPrendasReservadas = cantidadPrendasReservadas;
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
	
	public void reservar(int cantidad){
		this.cantidadPrendasReservadas = this.cantidadPrendasReservadas + cantidad;
		this.updateMe();
	}
	
	public void saveMe(){
		codigo = StockPrendaDao.getInstance().CrearStockPrenda(this).codigo;
	}

	public void updateMe(){
		StockPrendaDao.getInstance().ModificarStockPrenda(this);
	}
	
	public void deleteMe(){
		StockPrendaDao.getInstance().EliminarStockPrenda(this);
	}

	public StockPrendaDto toDto(PrendaDto prenda){
		return new StockPrendaDto(codigo, color.toString(), talle, lote.toDto(prenda), fecha, costoProduccion, cantidad, ubicacion, cantidadPrendasReservadas,
				prenda);
	}
	
	public StockPrendaDto toDto(){
		return new StockPrendaDto(codigo, color.toString(), talle, lote.toDto(), fecha, costoProduccion, cantidad, ubicacion, cantidadPrendasReservadas,
				prenda.toDto());
	}

}
