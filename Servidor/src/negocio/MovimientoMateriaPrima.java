package negocio;

import java.util.ArrayList;
import java.util.Date;

import dao.MateriaPrimaDao;
import dto.MovimientoMateriaPrimaDto;
import dto.StockMateriaPrimaDto;
import entity.MovimientoMateriaPrimaEntity;
import entity.OrdenDeProduccionCompletaEntity;
import entity.OrdenDeProduccionParcialEntity;
import entity.StockMateriaPrimaEntity;

public class MovimientoMateriaPrima {

	private EstadoMovimientoMateriaPrima estado;
	private int cantidad;
	private Date fecha;
	private ArrayList<StockMateriaPrima> stocksReservados;
	private int id;
	private OrdenDeProduccion lote;
	
	public MovimientoMateriaPrima(int id,EstadoMovimientoMateriaPrima estado, int cantidad, Date fecha, ArrayList<StockMateriaPrima> stocksReservados, OrdenDeProduccion lote){
		this.id=id;
		this.estado=estado;
		this.cantidad=cantidad;
		this.fecha=fecha;
		this.stocksReservados=stocksReservados;
		this.lote=lote;
	}
	
	public MovimientoMateriaPrima(EstadoMovimientoMateriaPrima estado, int cantidad, Date fecha, ArrayList<StockMateriaPrima> stocksReservados, OrdenDeProduccion lote){
		this.estado=estado;
		this.cantidad=cantidad;
		this.fecha=fecha;
		this.stocksReservados=stocksReservados;
		this.lote= lote;
	}
	
	//constructor del alta
	public MovimientoMateriaPrima(EstadoMovimientoMateriaPrima estado, int cantidad, Date fecha, StockMateriaPrima stocksReservados){
		this.estado=estado;
		this.cantidad=cantidad;
		this.fecha=fecha;
		
		ArrayList<StockMateriaPrima> stocks = new ArrayList<>();
		stocks.add(stocksReservados);
		this.stocksReservados=stocks;
	}
	
	public MovimientoMateriaPrima(MovimientoMateriaPrimaEntity movimiento){
		this.id=movimiento.getId();
		this.estado=movimiento.getEstado();
		this.cantidad=movimiento.getCantidad();
		this.fecha=movimiento.getFecha();
		
		ArrayList<StockMateriaPrima> stocks = new ArrayList<StockMateriaPrima>();
		for (StockMateriaPrimaEntity stockMateriaPrimaEntity : movimiento.getStocksReservados()) {
			stocks.add(new StockMateriaPrima(stockMateriaPrimaEntity));
		}
		this.stocksReservados=stocks;
		
		if(movimiento.getLote().getClass().getName().equals("entity.OrdenDeProduccionCompletaEntity"))
			this.lote=new OrdenProduccionCompleta((OrdenDeProduccionCompletaEntity) movimiento.getLote());
		
		if(movimiento.getLote().getClass().getName().equals("entity.OrdenDeProduccionParcialEntity"))
			this.lote=new OrdenProduccionParcial((OrdenDeProduccionParcialEntity) movimiento.getLote());
		
	}

	public EstadoMovimientoMateriaPrima getEstado() {
		return estado;
	}

	public void setEstado(EstadoMovimientoMateriaPrima estado) {
		this.estado = estado;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public ArrayList<StockMateriaPrima> getStocksReservados() {
		return stocksReservados;
	}

	public void setStocksReservados(ArrayList<StockMateriaPrima> stocksReservados) {
		this.stocksReservados = stocksReservados;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public OrdenDeProduccion getLote() {
		return lote;
	}

	public void setLote(OrdenDeProduccion lote) {
		this.lote = lote;
	}

	public void saveMe(){
		MateriaPrimaDao.getInstance().crearMovimiento(this);
	}
	
	public MovimientoMateriaPrimaDto toDto(){
		ArrayList<StockMateriaPrimaDto> stocksDto = new ArrayList<StockMateriaPrimaDto>();
		for (StockMateriaPrima stockMateriaPrima : this.stocksReservados) {
			stocksDto.add(stockMateriaPrima.toDto());
		}
		return new MovimientoMateriaPrimaDto(id,estado+"", cantidad, fecha, stocksDto, lote.toDto());
	}
	
}
