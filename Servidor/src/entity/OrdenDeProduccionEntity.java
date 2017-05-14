package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import negocio.MateriaPrima;
import negocio.OrdenDeProduccion;
import negocio.PedidoPrendas;
import negocio.Prenda;


@Entity 
@Table(name="OrdenDeProduccion") 
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name="discriminator",discriminatorType=DiscriminatorType.STRING) 
@DiscriminatorValue(value="default")
public abstract class OrdenDeProduccionEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int nroOrden;
	
	private String estado;
	
	@OneToMany()
	@JoinColumn(name="ordenDeProduccion_id")
	private List<MateriaPrimaEntity> materiasPrimasReservadas;
	
	private int confeccionesTerminadas;
	
	@ManyToOne()
	@JoinColumn(name="ordenDeProduccion_id")
	private PrendaEntity prenda;
	
	@OneToOne()
	private PedidoPrendasEntity pedidoPrenda;
	
	public OrdenDeProduccionEntity(){}
	public OrdenDeProduccionEntity(int nroOrden, String estado, List<MateriaPrimaEntity> materiaPrimaReservada, PedidoPrendasEntity pedidoPrenda, PrendaEntity prenda){
		this.estado=estado;
		this.materiasPrimasReservadas=materiaPrimaReservada;
		this.confeccionesTerminadas=0;
		this.pedidoPrenda=pedidoPrenda;
		this.prenda=prenda;
		this.nroOrden = nroOrden;
	}
	
	public OrdenDeProduccionEntity(OrdenDeProduccion op){
		this.estado=op.getEstado();
		this.confeccionesTerminadas=op.getConfeccionesTerminadas();
		this.nroOrden = op.getNroOrden();
		this.materiasPrimasReservadas= new ArrayList<>();
		if(op.getMateriaPrimaReservada()!=null){
			for (MateriaPrima materia : op.getMateriaPrimaReservada()) {
				this.materiasPrimasReservadas.add(new MateriaPrimaEntity(materia));
			}
		}
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public List<MateriaPrimaEntity> getMateriaPrimaReservada() {
		return materiaPrimaReservada;
	}
	public void setMateriaPrimaReservada(List<MateriaPrimaEntity> materiaPrimaReservada) {
		this.materiaPrimaReservada = materiaPrimaReservada;
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
