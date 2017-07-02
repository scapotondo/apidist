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
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import negocio.MovimientoPrenda;
import negocio.TipoMovimientoStockPrendaEnum;

@Entity
@Table(name="MovimiendoPrenda")
public class MovimientoPrendaEntity implements Serializable{


	public TipoMovimientoStockPrendaEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimientoStockPrendaEnum tipo) {
		this.tipo = tipo;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private int cantidad;
	private Date fecha;
	private String encargado;
	private String quienAutorizo;
	private String destino;
	
	@JoinColumn(name="codigoPrenda")
	private PrendaEntity prenda;
	
	@Column(columnDefinition="integer", nullable = false)
    @Type(
        type = "negocio.TipoMovimientoStockPrendaEnum", 
        parameters = { 
        	@Parameter(name = "enumClass", value = "negocio.TipoMovimientoStockPrendaEnum"),
        	@Parameter(name = "identifierMethod", value = "toInt"),
        	@Parameter(name = "valueOfMethod", value = "fromInt")
        }
    )
	private TipoMovimientoStockPrendaEnum tipo;
	
	@ManyToMany()
	@JoinColumn(name="codigoPrenda")
	private List<StockPrendaEntity> lotes;
	
	public MovimientoPrendaEntity(){}
	
	public MovimientoPrendaEntity(MovimientoPrenda movimiento){
		this.id = movimiento.getId();
		this.cantidad=movimiento.getCantidad();
		this.fecha=movimiento.getFecha();
		this.encargado=movimiento.getEncargado();
		this.quienAutorizo=movimiento.getQuienAutorizo();
		this.destino=movimiento.getDestino();
		this.tipo=movimiento.getTipo();
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
