package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import negocio.ColorPrenda;
import negocio.OrdenProduccionCompleta;
import negocio.OrdenProduccionParcial;
import negocio.StockPrenda;

@Entity
@Table(name="StockPrenda")
public class StockPrendaEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;
	
	@Column(columnDefinition="integer", nullable = false)
    @Type(
        type = "negocio.ColorPrenda", 
        parameters = { 
        	@Parameter(name = "enumClass", value = "negocio.ColorPrenda"),
        	@Parameter(name = "identifierMethod", value = "toInt"),
        	@Parameter(name = "valueOfMethod", value = "fromInt")
        }
    )
	private ColorPrenda color;
	
	private String talle;
	private Date fecha;
	private float costoProduccion;
	private int cantidad;
	private String ubicacion;
	private int cantidadPrendasReservadas;
	
	@ManyToOne(targetEntity=PrendaEntity.class)
	private PrendaEntity prenda;
	
	@OneToOne()
	private OrdenDeProduccionEntity lote;
	
	public StockPrendaEntity(){}
	
	public StockPrendaEntity(ColorPrenda color,String talle, Date fecha, float costoProduccion, int cantidad, String ubicacion,
			int cantidadPrendasReservadas,PrendaEntity prenda,OrdenDeProduccionEntity lote){
		
		this.color=color;
		this.talle=talle;
		this.fecha=fecha;
		this.costoProduccion=costoProduccion;
		this.cantidad=cantidad;
		this.ubicacion=ubicacion;
		this.cantidadPrendasReservadas=cantidadPrendasReservadas;
		this.prenda=prenda;
		this.lote=lote;
	}
	
	public StockPrendaEntity(StockPrenda sp){
		this.color=sp.getColor();
		this.talle=sp.getTalle();
		this.fecha=sp.getFecha();
		this.costoProduccion=sp.getCostoProduccion();
		this.cantidad=sp.getCantidad();
		this.ubicacion=sp.getUbicacion();
		this.cantidadPrendasReservadas=sp.getCantidadPrendasReservadas();
		if(sp.getPrenda()!= null)
			this.prenda=new PrendaEntity(sp.getPrenda());
		else
			this.prenda=new PrendaEntity();
		
		
		if(sp.getLote().getClass().getName().equals("negocio.OrdenProduccionCompleta"))
			this.lote = new OrdenDeProduccionCompletaEntity( (OrdenProduccionCompleta) sp.getLote());
			
		if(sp.getLote().getClass().getName().equals("negocio.OrdenProduccionParcial"))
			this.lote = new OrdenDeProduccionParcialEntity((OrdenProduccionParcial) sp.getLote());
		
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

	public PrendaEntity getPrenda() {
		return prenda;
	}

	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}

	public OrdenDeProduccionEntity getLote() {
		return lote;
	}

	public void setLote(OrdenDeProduccionEntity lote) {
		this.lote = lote;
	}
	
	
}
