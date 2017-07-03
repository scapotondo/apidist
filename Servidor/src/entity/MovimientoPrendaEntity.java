package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import negocio.MovimientoPrenda;

@Entity
@Table(name="MovimiendoPrenda")
public class MovimientoPrendaEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private int cantidad;
	private Date fecha;
	private String encargado;
	private String quienAutorizo;
	private String destino;
	
	@ManyToOne()
	@JoinColumn(name="codigoPrenda")
	private PrendaEntity prenda;
	
	@Column(nullable = false)
	private int tipo;
	
	@ManyToMany()
	@JoinColumn(name="codigo_Lote")
	private List<StockPrendaEntity> lotes;
	
	public MovimientoPrendaEntity(){}
	
	public MovimientoPrendaEntity(MovimientoPrenda movimiento){
		this.id = movimiento.getId();
		this.cantidad=movimiento.getCantidad();
		this.fecha=movimiento.getFecha();
		this.encargado=movimiento.getEncargado();
		this.quienAutorizo=movimiento.getQuienAutorizo();
		this.destino=movimiento.getDestino();
		this.tipo=movimiento.getTipo().toInt();
		this.prenda=new PrendaEntity(movimiento.getPrenda());
	}
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public List<StockPrendaEntity> getLotes() {
		return lotes;
	}

	public void setLotes(List<StockPrendaEntity> lotes) {
		this.lotes = lotes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public PrendaEntity getPrenda() {
		return prenda;
	}

	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	} 

	
}
