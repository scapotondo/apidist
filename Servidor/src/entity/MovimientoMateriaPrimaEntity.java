package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import negocio.*;

@Entity
@Table(name="MovimientoMateriaPrima")
public class MovimientoMateriaPrimaEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "estado")
	private EstadoMovimientoMateriaPrima estado;
	
	private int cantidad;
	private Date fecha;
	
	@ManyToMany()
	@JoinColumn(name="codigoMP")
	private List<StockMateriaPrimaEntity> stocksReservados;
	
	@ManyToOne()
	@Column(nullable=true)
	private OrdenDeProduccionEntity lote;
	
	public MovimientoMateriaPrimaEntity(){}
	public MovimientoMateriaPrimaEntity(MovimientoMateriaPrima movimientoMateriaPrima){
		this.id = movimientoMateriaPrima.getId();
		this.estado = movimientoMateriaPrima.getEstado();
		this.cantidad = movimientoMateriaPrima.getCantidad();
		this.fecha = movimientoMateriaPrima.getFecha();
		
		ArrayList<StockMateriaPrimaEntity> stocks = new ArrayList<>();
		for (StockMateriaPrima stockMateriaPrima : movimientoMateriaPrima.getStocksReservados()) {
			stocks.add(new StockMateriaPrimaEntity(stockMateriaPrima));
		}
		this.stocksReservados = stocks;
		if(movimientoMateriaPrima.getLote() != null){
			if(movimientoMateriaPrima.getLote().getClass().getName().equals("negocio.OrdenProduccionCompleta"))
				this.lote = new OrdenDeProduccionCompletaEntity( (OrdenProduccionCompleta) movimientoMateriaPrima.getLote());
				
			if(movimientoMateriaPrima.getLote().getClass().getName().equals("negocio.OrdenProduccionParcial"))
				this.lote = new OrdenDeProduccionParcialEntity((OrdenProduccionParcial) movimientoMateriaPrima.getLote());
		
		}else
			this.lote= null;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public List<StockMateriaPrimaEntity> getStocksReservados() {
		return stocksReservados;
	}
	public void setStocksReservados(List<StockMateriaPrimaEntity> stocksReservados) {
		this.stocksReservados = stocksReservados;
	}
	public OrdenDeProduccionEntity getLote() {
		return lote;
	}
	public void setLote(OrdenDeProduccionEntity lote) {
		this.lote = lote;
	}
	
	
	
}
