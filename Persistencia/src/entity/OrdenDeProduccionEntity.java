package entity;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Embeddable
@Table(name="OrdenDeProduccion")
public class OrdenDeProduccionEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int nroOrden;
	
	private String estado;
	
	@OneToMany(mappedBy="ordenDeProduccion")
	private List<MateriaPrimaEntity> materiaPrimaReservada;
	
	private int confeccionesTerminadas;
	
	@OneToMany(mappedBy="ordenDeProduccion")
	@Embedded
	private List<PrendaEntity> prendas;
	
	@OneToOne
	@Embedded
	private PedidoPrendasEntity pedidoPrenda;
	
	public OrdenDeProduccionEntity(){}
	public OrdenDeProduccionEntity(int nroOrden, String estado, List<MateriaPrimaEntity> materiaPrimaReservada, PedidoPrendasEntity pedidoPrenda, List<PrendaEntity> prendas){
		this.estado=estado;
		this.materiaPrimaReservada=materiaPrimaReservada;
		this.confeccionesTerminadas=0;
		this.pedidoPrenda=pedidoPrenda;
		this.prendas=prendas;
		this.nroOrden = nroOrden;
	}

}
