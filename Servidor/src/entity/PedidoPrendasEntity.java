package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import negocio.ItemPrenda;
import negocio.OrdenProduccionCompleta;
import negocio.OrdenProduccionParcial;
import negocio.PedidoPrendas;

@Entity
@Table(name="PedidoPrendas")
@Embeddable
public class PedidoPrendasEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int nroPedido;
	
	@Column(nullable=true)
	private Date fechaProbableDespacho;
	
	@Column(nullable=false)
	private int estado;
	
	@Column(nullable=false)
	private Date fechaGeneracion;
	
	@Column(nullable=true)
	private Date fechaRealDespacho;
	
	@ManyToOne()
	private ClienteEntity cliente;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private OrdenDeProduccionEntity ordenProduccion;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="pedidoPrenda_id")
	private List<ItemPrendaEntity> items;
	
	public PedidoPrendasEntity(){}
	
	public PedidoPrendasEntity(PedidoPrendas pedido, ClienteEntity cliente){
		this.nroPedido=pedido.getNroPedido();
		this.fechaProbableDespacho=pedido.getFechaProbableDespacho();
		this.estado=pedido.getEstado().toInt();
		this.fechaGeneracion=pedido.getFechaGeneracion();
		this.fechaRealDespacho=pedido.getFechaProbableDespacho();
		this.cliente=cliente;
		
		if (pedido.getOrdenProduccion() != null) {
			if(pedido.getOrdenProduccion().getClass().getName().equals("negocio.OrdenProduccionCompleta"))
				this.ordenProduccion = new OrdenDeProduccionCompletaEntity( (OrdenProduccionCompleta) pedido.getOrdenProduccion(), this);
				
			if(pedido.getOrdenProduccion().getClass().getName().equals("negocio.OrdenProduccionParcial"))
				this.ordenProduccion = new OrdenDeProduccionParcialEntity((OrdenProduccionParcial) pedido.getOrdenProduccion(), this);
		}
		
		ArrayList<ItemPrendaEntity> items = new ArrayList<>();
		for (ItemPrenda itemPrenda : pedido.getItems()) 
			items.add(new ItemPrendaEntity(itemPrenda));
		
		this.items=items;
	}
	
	public PedidoPrendasEntity(PedidoPrendas pedido){
		this(pedido, new ClienteEntity(pedido.getCliente()));
	}
	
	public PedidoPrendasEntity(PedidoPrendas pedido, PrendaEntity prenda, OrdenDeProduccionEntity orden){
		this.nroPedido=pedido.getNroPedido();
		this.fechaProbableDespacho=pedido.getFechaProbableDespacho();
		this.estado=pedido.getEstado().toInt();
		this.fechaGeneracion=pedido.getFechaGeneracion();
		this.fechaRealDespacho=pedido.getFechaProbableDespacho();
		this.cliente=new ClienteEntity(pedido.getCliente());
		this.ordenProduccion = orden;
		
		ArrayList<ItemPrendaEntity> items = new ArrayList<>();
		for (ItemPrenda itemPrenda : pedido.getItems()) 
			items.add(new ItemPrendaEntity(itemPrenda, prenda));
		
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
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
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
