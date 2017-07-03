package negocio;

import java.util.ArrayList;
import java.util.Date;

import dao.MovimientoPrendaDao;
import dto.MovimientoPrendaDto;
import entity.MovimientoPrendaEntity;
import entity.StockPrendaEntity;
import exceptions.ApplicationException;

public class MovimientoPrenda {

	private int cantidad;
	private Date fecha;
	private String encargado;
	private String quienAutorizo;
	private String destino;
	private Prenda prenda;
	private int id;
	private TipoMovimientoStockPrendaEnum tipo;
	private ArrayList<StockPrenda> lotes;
	
	public MovimientoPrenda(int cantidad, Date fecha, String encargado, String quienAutorizo,
			String destino, Prenda prenda, TipoMovimientoStockPrendaEnum tipo, ArrayList<StockPrenda> lotes){
		this.cantidad=cantidad;
		this.fecha=fecha;
		this.encargado=encargado;
		this.quienAutorizo=quienAutorizo;
		this.destino=destino;
		this.prenda=prenda;
		this.lotes=lotes;
		this.tipo = tipo;
	}
	
	public MovimientoPrenda(MovimientoPrendaEntity movimiento){
		this.cantidad=movimiento.getCantidad();
		this.fecha=movimiento.getFecha();
		this.encargado=movimiento.getEncargado();
		this.quienAutorizo=movimiento.getQuienAutorizo();
		this.destino=movimiento.getDestino();
		this.prenda=new Prenda(movimiento.getPrenda());
		
		try {
			this.tipo=TipoMovimientoStockPrendaEnum.fromInt(movimiento.getTipo());
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		this.lotes = new ArrayList<>();
		
		for (StockPrendaEntity stockPrendaEntity : movimiento.getLotes()) 
			lotes.add(new StockPrenda(stockPrendaEntity));
		
		try {
			this.tipo = TipoMovimientoStockPrendaEnum.fromInt(movimiento.getTipo());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}
	
	public TipoMovimientoStockPrendaEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimientoStockPrendaEnum tipo) {
		this.tipo = tipo;
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

	public String getEncargado() {
		return encargado;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	public String getQuienAutorizo() {
		return quienAutorizo;
	}

	public void setQuienAutorizo(String quienAutorizo) {
		this.quienAutorizo = quienAutorizo;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}
	
	public MovimientoPrendaDto toDto(){
		return new MovimientoPrendaDto(id, cantidad, fecha, encargado, quienAutorizo, destino, prenda.toDto(), tipo.toString());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void saveMe() {
		MovimientoPrendaDao.getInstance().CrearMovimientoPrenda(this);
	}
	
}
