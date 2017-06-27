package negocio;

import dto.OrdenDeProduccionDto;
import entity.OrdenDeProduccionEntity;

public abstract class OrdenDeProduccion {
	
	private int nroOrden;
	private EstadoOrdenProduccion estado;
	private int confeccionesTerminadas;
	private PedidoPrendas pedido;
	private Prenda prenda;
	
	public OrdenDeProduccion(){}
	public OrdenDeProduccion(OrdenDeProduccionEntity op){
		
		this.nroOrden = op.getNroOrden();
		this.estado=op.getEstado();
		this.confeccionesTerminadas=op.getConfeccionesTerminadas();
		this.pedido=new PedidoPrendas(op.getPedidoPrenda());
		this.prenda=new Prenda(op.getPrenda());
	}
	
	public OrdenDeProduccion(int nroOrden, EstadoOrdenProduccion estado, PedidoPrendas pedido, Prenda prenda){
		this.nroOrden = nroOrden;
		this.estado=estado;
		this.confeccionesTerminadas=0;
		this.pedido=pedido;
		this.prenda=prenda;
	}
	
	public OrdenDeProduccion(EstadoOrdenProduccion estado, PedidoPrendas pedido, Prenda prenda){
		this.estado=estado;
		this.confeccionesTerminadas=0;
		this.pedido=pedido;
		this.prenda=prenda;
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
	public PedidoPrendas getPedido() {
		return pedido;
	}
	public void setPedido(PedidoPrendas pedido) {
		this.pedido = pedido;
	}
	public Prenda getPrenda() {
		return prenda;
	}
	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}
	public abstract int getCantidad();
	
	
	public OrdenDeProduccionDto toDto(){
		
		return new OrdenDeProduccionDto(nroOrden, estado.toString(), pedido.toDto(), prenda.toDto());
	}
	
}
