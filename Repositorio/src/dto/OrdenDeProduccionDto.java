package dto;

import java.util.ArrayList;


public class OrdenDeProduccionDto {

	private int nroOrden;
	private String estado;
	private ArrayList<MateriaPrimaDto> materiaPrimaReservada;
	private int confeccionesTerminadas;
	private PedidoPrendasDto pedido;
	private PrendaDto prenda;
	
	public OrdenDeProduccionDto(int nroOrden, String estado,ArrayList<MateriaPrimaDto> materiaPrimaReservada, PedidoPrendasDto pedido, PrendaDto prenda){
		this.nroOrden = nroOrden;
		this.estado=estado;
		this.materiaPrimaReservada=materiaPrimaReservada;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ArrayList<MateriaPrimaDto> getMateriaPrimaReservada() {
		return materiaPrimaReservada;
	}

	public void setMateriaPrimaReservada(ArrayList<MateriaPrimaDto> materiaPrimaReservada) {
		this.materiaPrimaReservada = materiaPrimaReservada;
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
