package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.OrdenDeProduccionDao;
import dto.OrdenDeProduccionDto;
import dto.PedidoPrendasDto;
import dto.PrendaDto;
import dto.ProcesoProduccionDto;
import entity.OrdenDeProduccionEntity;
import entity.ProcesoProduccionEntity;
import exceptions.ColorException;

public abstract class OrdenDeProduccion {
	
	private int nroOrden;
	private EstadoOrdenProduccion estado;
	private int confeccionesTerminadas;
	private PedidoPrendas pedido;
	private Prenda prenda;
	ArrayList<ProcesoProduccion> procesos;

	public OrdenDeProduccion(){}
	
	public OrdenDeProduccion(OrdenDeProduccionEntity op, Prenda prenda){
		try {
			this.nroOrden = op.getNroOrden();
			this.estado=EstadoOrdenProduccion.fromInt(op.getEstado());
			this.confeccionesTerminadas=op.getConfeccionesTerminadas();
			this.pedido=new PedidoPrendas(op.getPedidoPrenda(), prenda, this);
			this.prenda=prenda;
			this.procesos=new ArrayList<>();
			
			for(ProcesoProduccionEntity pe : op.getProcesos())
				procesos.add(new ProcesoProduccion(pe));
			
		} catch (ColorException e) {
			e.printStackTrace();
		}
	}
	
	public OrdenDeProduccion(OrdenDeProduccionEntity op){
		try {
			this.nroOrden = op.getNroOrden();
			this.estado=EstadoOrdenProduccion.fromInt(op.getEstado());
			this.confeccionesTerminadas=op.getConfeccionesTerminadas();
			this.pedido=new PedidoPrendas(op.getPedidoPrenda());
			this.prenda=new Prenda(op.getPrenda());
			this.procesos=new ArrayList<>();
			
			for(ProcesoProduccionEntity pe : op.getProcesos())
				procesos.add(new ProcesoProduccion(pe));
			
		} catch (ColorException e) {
			e.printStackTrace();
		}
	}
	
	public OrdenDeProduccion(OrdenDeProduccionEntity op, PedidoPrendas pedido){
		try {
			this.nroOrden = op.getNroOrden();
			this.estado=EstadoOrdenProduccion.fromInt(op.getEstado());
			this.confeccionesTerminadas=op.getConfeccionesTerminadas();
			this.pedido=pedido;
			this.prenda=new Prenda(op.getPrenda());
			this.procesos=new ArrayList<>();
			
			for(ProcesoProduccionEntity pe : op.getProcesos())
				procesos.add(new ProcesoProduccion(pe));
			
		} catch (ColorException e) {
			e.printStackTrace();
		}
	}
	
	public OrdenDeProduccion(EstadoOrdenProduccion estado, PedidoPrendas pedido, Prenda prenda, ArrayList<ProcesoProduccion> procesos){
		this.estado=estado;
		this.confeccionesTerminadas=0;
		this.pedido=pedido;
		this.prenda=prenda;
		this.procesos=procesos;
	}
	
	public ArrayList<ProcesoProduccion> getProcesos() {
		return procesos;
	}

	public void setProcesos(ArrayList<ProcesoProduccion> procesos) {
		this.procesos = procesos;
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
	
	public OrdenDeProduccion saveMe(){
		 return OrdenDeProduccionDao.getInstance().crearOrden(this);
	}
	
	public void modificame(){
		OrdenDeProduccionDao.getInstance().modificame(this);
	}
	
	public OrdenDeProduccionDto toDto(){
		ArrayList<ProcesoProduccionDto> procDtos = new ArrayList<>();
		for (ProcesoProduccion proc : procesos)
			procDtos.add(proc.toDto());
		
		return new OrdenDeProduccionDto(nroOrden, estado.toString(), pedido.toDto(), prenda.toDto(), procDtos);
	}
	
	public OrdenDeProduccionDto toDto(PedidoPrendasDto pedido){
		ArrayList<ProcesoProduccionDto> procDtos = new ArrayList<>();
		for (ProcesoProduccion proc : procesos)
			procDtos.add(proc.toDto());
		
		return new OrdenDeProduccionDto(nroOrden, estado.toString(), pedido, prenda.toDto(), procDtos);
	}
	
	public OrdenDeProduccionDto toDto(PrendaDto prenda){
		ArrayList<ProcesoProduccionDto> procDtos = new ArrayList<>();
		for (ProcesoProduccion proc : procesos)
			procDtos.add(proc.toDto());
		
		OrdenDeProduccionDto orden = new OrdenDeProduccionDto(nroOrden, estado.toString(), prenda, procDtos);
		
		PedidoPrendasDto ped = pedido.toDto(prenda, orden);
		orden.setPedido(ped);
		
		return orden;
	}
	
	public abstract List<String> getTalles();
	public abstract List<String> getColores();
	
}
