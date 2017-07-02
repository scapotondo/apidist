package negocio;

import java.util.List;

import dao.OrdenDeProduccionDao;
import dto.OrdenDeProduccionDto;
import entity.OrdenDeProduccionEntity;
import exceptions.ColorException;

public abstract class OrdenDeProduccion {
	
	private int nroOrden;
	private EstadoOrdenProduccion estado;
	private int confeccionesTerminadas;
	private PedidoPrendas pedido;
	private Prenda prenda;
	
	public OrdenDeProduccion(){}
	public OrdenDeProduccion(OrdenDeProduccionEntity op){
		try {
			this.nroOrden = op.getNroOrden();
			this.estado=EstadoOrdenProduccion.fromInt(op.getEstado());
			this.confeccionesTerminadas=op.getConfeccionesTerminadas();
			this.pedido=new PedidoPrendas(op.getPedidoPrenda());
			this.prenda=new Prenda(op.getPrenda());
			
		} catch (ColorException e) {
			e.printStackTrace();
		}
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
	
	public void terminarConfeccion(Confeccion confeccion){
		int index = 0;
		boolean hayConfeccionesRestantes = false;
		
		for (Confeccion confeccionEvaluada : this.prenda.getConfecciones()) {
			if(confeccionEvaluada.getId() == confeccion.getId())
				index = this.prenda.getConfecciones().indexOf(confeccionEvaluada);
			
			else if (confeccionEvaluada.getEstado().equals(EstadoConfeccion.INCOMPLETO))
				hayConfeccionesRestantes = true;
		}
		confeccion.setEstado(EstadoConfeccion.COMPLETO);
		
		this.prenda.getConfecciones().set(index, confeccion);
		this.prenda.modificame();
		
		if(!hayConfeccionesRestantes){
			this.estado = EstadoOrdenProduccion.TERMINADA;
			this.modificame();
		}
	}
	
	public OrdenDeProduccion saveMe(){
		 return OrdenDeProduccionDao.getInstance().crearOrden(this);
	}
	
	public void modificame(){
		OrdenDeProduccionDao.getInstance().modificame(this);
	}
	
	public OrdenDeProduccionDto toDto(){
		
		return new OrdenDeProduccionDto(nroOrden, estado.toString(), pedido.toDto(), prenda.toDto());
	}
	public abstract List<String> getTalles();
	public abstract List<String> getColores();
	
}
