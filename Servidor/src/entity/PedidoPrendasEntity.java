package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import negocio.ItemPrenda;
import negocio.PedidoPrendas;

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
	private ClienteEntity cliente;
	
	@OneToOne()
	private OrdenDeProduccionEntity ordenProduccion;
	
	@OneToMany()
	@JoinColumn(name="pedidoPrenda_id")
	private List<ItemPrendaEntity> items;
	
	public PedidoPrendasEntity(){}
	public PedidoPrendasEntity(int nroPedido, Date fechaProbableDespacho, String estado, Date fechaGeneracion,
			Date fechaRealDespacho, OrdenDeProduccionEntity ordenProduccion, ClienteEntity cliente, List<ItemPrendaEntity> items){
		this.nroPedido=nroPedido;
		this.fechaProbableDespacho=fechaProbableDespacho;
		this.estado=estado;
		this.fechaGeneracion=fechaGeneracion;
		this.fechaRealDespacho=fechaRealDespacho;
		this.cliente=cliente;
		this.ordenProduccion=ordenProduccion;
		this.items=items;
	}
	
	public PedidoPrendasEntity(PedidoPrendas pedido){
		this.nroPedido=pedido.getNroPedido();
		this.fechaProbableDespacho=pedido.getFechaProbableDespacho();
		this.estado=pedido.getEstado();
		this.fechaGeneracion=pedido.getFechaGeneracion();
		this.fechaRealDespacho=pedido.getFechaProbableDespacho();
		this.cliente=new ClienteEntity(pedido.getCliente());
		
		
		//this.ordenProduccion=pedido.getOrdenProduccion.getOrdenProduccion();
		ArrayList<ItemPrendaEntity> items = new ArrayList<>();
		for (ItemPrenda itemPrenda : pedido.getItems()) {
			items.add(new ItemPrendaEntity(itemPrenda));
		}
		this.items=items;
	}
	
	public int getNroPedido() {
		return nroPedido;
	}
	public void setNroPedido(int nroPedido) {
		this.nroPedido = nroPedido;
	}
	public Date getFechaProbableDespacho() {
		return fechaProbableDespacho;
	}
	public void setFechaProbableDespacho(Date fechaProbableDespacho) {
		this.fechaProbableDespacho = fechaProbableDespacho;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}
	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}
	public Date getFechaRealDespacho() {
		return fechaRealDespacho;
	}
	public void setFechaRealDespacho(Date fechaRealDespacho) {
		this.fechaRealDespacho = fechaRealDespacho;
	}
	public ClienteEntity getCliente() {
		return cliente;
	}
	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}
	public OrdenDeProduccionEntity getOrdenProduccion() {
		return ordenProduccion;
	}
	public void setOrdenProduccion(OrdenDeProduccionEntity ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}
	public List<ItemPrendaEntity> getItems() {
		return items;
	}
	public void setItems(List<ItemPrendaEntity> items) {
		this.items = items;
	}
	
}
