package entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import negocio.EstadoOrdenProduccion;
import negocio.OrdenDeProduccion;


@Entity 
@Table(name="OrdenDeProduccion") 
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name="discriminator",discriminatorType=DiscriminatorType.STRING) 
@DiscriminatorValue(value="default")
public abstract class OrdenDeProduccionEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int nroOrden;
	
	@Column(columnDefinition="integer", nullable = false)
    @Type(
        type = "negocio.EstadoOrdenProduccion", 
        parameters = { 
        	@Parameter(name = "enumClass", value = "negocio.EstadoOrdenProduccion"),
        	@Parameter(name = "identifierMethod", value = "toInt"),
        	@Parameter(name = "valueOfMethod", value = "fromInt")
        }
    )
	private EstadoOrdenProduccion estado;
	
	private int confeccionesTerminadas;
	
	@ManyToOne()
	private PrendaEntity prenda;
	
	@OneToOne()
	private PedidoPrendasEntity pedidoPrenda;
	
	public OrdenDeProduccionEntity(){}
	public OrdenDeProduccionEntity(int nroOrden, EstadoOrdenProduccion estado, PedidoPrendasEntity pedidoPrenda, PrendaEntity prenda){
		this.estado=estado;
		this.confeccionesTerminadas=0;
		this.pedidoPrenda=pedidoPrenda;
		this.prenda=prenda;
		this.nroOrden = nroOrden;
	}
	
	public OrdenDeProduccionEntity(OrdenDeProduccion op){
		this.estado=op.getEstado();
		this.confeccionesTerminadas=op.getConfeccionesTerminadas();
		this.nroOrden = op.getNroOrden();
		this.pedidoPrenda=new PedidoPrendasEntity(op.getPedido());
		
		if(op.getPrenda()!=null)
			this.prenda=new PrendaEntity(op.getPrenda());
		else
			this.prenda=new PrendaEntity();
	}
	
	public int getNroOrden() {
		return nroOrden;
	}
	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}
	public EstadoOrdenProduccion getEstado() {
		return estado;
	}
	public void setEstado(EstadoOrdenProduccion estado) {
		this.estado = estado;
	}
	public int getConfeccionesTerminadas() {
		return confeccionesTerminadas;
	}
	public void setConfeccionesTerminadas(int confeccionesTerminadas) {
		this.confeccionesTerminadas = confeccionesTerminadas;
	}
	public PrendaEntity getPrenda() {
		return prenda;
	}
	public void setPrendas(PrendaEntity prenda) {
		this.prenda = prenda;
	}
	public PedidoPrendasEntity getPedidoPrenda() {
		return pedidoPrenda;
	}
	public void setPedidoPrenda(PedidoPrendasEntity pedidoPrenda) {
		this.pedidoPrenda = pedidoPrenda;
	}
	
	

}
