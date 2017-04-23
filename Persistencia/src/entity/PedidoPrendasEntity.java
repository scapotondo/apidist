package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

import negocio.Cliente;
import negocio.ItemPrenda;
import negocio.OrdenDeProduccion;

@Entity
@Table(name="PedidoPrendas")
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
	
	
	//private OrdenDeProduccion ordenProduccion;
	
	@ManyToOne(targetEntity=ClienteEntity.class)
	private Cliente cliente;
	
	//private ArrayList<ItemPrenda> items;
	
	public PedidoPrendasEntity(int nroPedido, Date fechaProbableDespacho, String estado, Date fechaGeneracion,
			Date fechaRealDespacho, /* OrdenDeProduccion ordenProduccion */ Cliente cliente /* ArrayList<ItemPrenda> items*/){
		this.nroPedido=nroPedido;
		this.fechaProbableDespacho=fechaProbableDespacho;
		this.estado=estado;
		this.fechaGeneracion=fechaGeneracion;
		this.fechaRealDespacho=fechaRealDespacho;
		//this.ordenProduccion=ordenProduccion;
		this.cliente=cliente;
		//this.items=items;
	}
}
