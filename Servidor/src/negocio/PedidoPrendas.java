package negocio;

import java.util.ArrayList;
import java.util.Date;

import dto.ItemPrendaDto;
import dto.PedidoPrendasDto;
import entity.ItemPrendaEntity;
import entity.PedidoPrendasEntity;

public class PedidoPrendas {
	
	private int nroPedido;
	private Date fechaProbableDespacho;
	private String estado;
	private Date fechaGeneracion;
	private Date fechaRealDespacho;
	private OrdenDeProduccion ordenProduccion;
	private Cliente cliente;
	private ArrayList<ItemPrenda> items;
	
	public PedidoPrendas(PedidoPrendasEntity pedido){
		this.nroPedido=pedido.getNroPedido();
		this.fechaProbableDespacho=pedido.getFechaProbableDespacho();
		this.estado=pedido.getEstado();
		this.fechaGeneracion=pedido.getFechaGeneracion();
		this.fechaRealDespacho=pedido.getFechaRealDespacho();
		this.cliente=new Cliente(pedido.getCliente());
		this.items=new ArrayList<ItemPrenda>();
		for (ItemPrendaEntity itemPrendaEntity : pedido.getItems()) {
			this.items.add(new ItemPrenda(itemPrendaEntity));
		}
		
		//TODO: ver como manejar esto ya que op es abstracto
		//this.ordenProduccion=new OrdenDeProduccion(pedido.getOrdenProduccion());
	}
	
	public PedidoPrendas(int nroPedido, Date fechaProbableDespacho, String estado, Date fechaGeneracion,
			Date fechaRealDespacho, OrdenDeProduccion ordenProduccion, Cliente cliente, ArrayList<ItemPrenda> items){
		this.nroPedido=nroPedido;
		this.fechaProbableDespacho=fechaProbableDespacho;
		this.estado=estado;
		this.fechaGeneracion=fechaGeneracion;
		this.fechaRealDespacho=fechaRealDespacho;
		this.ordenProduccion=ordenProduccion;
		this.cliente=cliente;
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

	public OrdenDeProduccion getOrdenProduccion() {
		return ordenProduccion;
	}

	public void setOrdenProduccion(OrdenDeProduccion ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<ItemPrenda> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemPrenda> items) {
		this.items = items;
	}

	public void calcularTotal(){
		
	}
	//cambiar el void a PedidoPrendasDto
	public void getPedidoPrendasDto(){
		
	}
	public void aprobarPedido(){
		
	}
	
	public PedidoPrendasDto toDto(){
		ArrayList<ItemPrendaDto> itemsDto = new ArrayList<>();
		
		for (ItemPrenda itemPrenda : items) {
			itemsDto.add(itemPrenda.toDto());
		}
		return new PedidoPrendasDto(nroPedido, fechaProbableDespacho, estado, fechaGeneracion, fechaRealDespacho, 
				ordenProduccion.toDto(), cliente.toDto(), itemsDto);
	}
	
}
