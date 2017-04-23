package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="PedidoPrendas")
@Embeddable
public class PedidoPrendasEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int nroPedido;
	
	@Column(nullable=false)
	private Date fechaProbableDespacho;
	
	@Column(nullable=false)
	private String estado;
	
	@Column(nullable=false)
	private Date fechaGeneracion;
	
	@Column(nullable=false)
	private Date fechaRealDespacho;
	
	@ManyToOne(targetEntity=ClienteEntity.class)
	@Embedded
	private ClienteEntity cliente;
	
	//private OrdenDeProduccion ordenProduccion;
	//private ArrayList<ItemPrenda> items;
	
	public PedidoPrendasEntity(int nroPedido, Date fechaProbableDespacho, String estado, Date fechaGeneracion,
			Date fechaRealDespacho, /* OrdenDeProduccion ordenProduccion */ ClienteEntity cliente /* ArrayList<ItemPrenda> items*/){
		this.nroPedido=nroPedido;
		this.fechaProbableDespacho=fechaProbableDespacho;
		this.estado=estado;
		this.fechaGeneracion=fechaGeneracion;
		this.fechaRealDespacho=fechaRealDespacho;
		this.cliente=cliente;
		//this.ordenProduccion=ordenProduccion;
		//this.items=items;
	}
}
