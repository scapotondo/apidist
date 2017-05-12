package entity;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;


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
	private List<MateriaPrimaEntity> materiaPrimaReservada;
	
	private int confeccionesTerminadas;
	
	@ManyToOne()
	@JoinColumn(name="ordenDeProduccion_id")
	private PrendaEntity prenda;
	
	@OneToOne()
	private PedidoPrendasEntity pedidoPrenda;
	
	public OrdenDeProduccionEntity(){}
	public OrdenDeProduccionEntity(int nroOrden, String estado, List<MateriaPrimaEntity> materiaPrimaReservada, PedidoPrendasEntity pedidoPrenda, PrendaEntity prenda){
		this.estado=estado;
		this.materiaPrimaReservada=materiaPrimaReservada;
		this.confeccionesTerminadas=0;
		this.pedidoPrenda=pedidoPrenda;
		this.prenda=prenda;
		this.nroOrden = nroOrden;
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
