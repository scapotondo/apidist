package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import negocio.OrdenDeProduccion;
import negocio.ProcesoProduccion;


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
	
	private int estado;
	
	private int confeccionesTerminadas;
	
	@ManyToOne()
	private PrendaEntity prenda;
	
	@OneToOne()
	private PedidoPrendasEntity pedidoPrenda;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<ProcesoProduccionEntity> procesos;
	
	public OrdenDeProduccionEntity(){}

	public OrdenDeProduccionEntity(OrdenDeProduccion op){
		this.estado=op.getEstado().toInt();
		this.confeccionesTerminadas=op.getConfeccionesTerminadas();
		this.nroOrden = op.getNroOrden();
		this.pedidoPrenda=new PedidoPrendasEntity(op.getPedido());
		this.procesos = new ArrayList<>();
		
		if(op.getPrenda()!=null)
			this.prenda=new PrendaEntity(op.getPrenda());
		else
			this.prenda=new PrendaEntity();
		
		if (op.getProcesos() != null) 
			for (ProcesoProduccion p : op.getProcesos()) 
				procesos.add(new ProcesoProduccionEntity(p));
	}
	
	public List<ProcesoProduccionEntity> getProcesos() {
		return procesos;
	}

	public void setProcesos(List<ProcesoProduccionEntity> procesos) {
		this.procesos = procesos;
	}
	
	public int getNroOrden() {
		return nroOrden;
	}
	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}
	
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
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
