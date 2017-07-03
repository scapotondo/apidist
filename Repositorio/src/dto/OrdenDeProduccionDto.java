package dto;

import java.io.Serializable;
import java.util.ArrayList;


public class OrdenDeProduccionDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int nroOrden;
	private String estado;
	private int confeccionesTerminadas;
	private PedidoPrendasDto pedido;
	private PrendaDto prenda;
	private ArrayList<ProcesoProduccionDto> procesos;
	
	public OrdenDeProduccionDto(){}
	
	public OrdenDeProduccionDto(int nroOrden, String estado, PedidoPrendasDto pedido, PrendaDto prenda, ArrayList<ProcesoProduccionDto> procesos){
		this.nroOrden = nroOrden;
		this.estado=estado;
		this.confeccionesTerminadas=0;
		this.pedido=pedido;
		this.prenda=prenda;
		this.procesos=procesos;
	}

	public ArrayList<ProcesoProduccionDto> getProcesos() {
		return procesos;
	}

	public void setProcesos(ArrayList<ProcesoProduccionDto> procesos) {
		this.procesos = procesos;
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

	public int getConfeccionesTerminadas() {
		return confeccionesTerminadas;
	}

	public void setConfeccionesTerminadas(int confeccionesTerminadas) {
		this.confeccionesTerminadas = confeccionesTerminadas;
	}

	public PedidoPrendasDto getPedido() {
		return pedido;
	}

	public void setPedido(PedidoPrendasDto pedido) {
		this.pedido = pedido;
	}

	public PrendaDto getPrenda() {
		return prenda;
	}

	public void setPrenda(PrendaDto prenda) {
		this.prenda = prenda;
	}
	
}
