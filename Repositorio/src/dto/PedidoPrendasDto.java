package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class PedidoPrendasDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int nroPedido;
	private Date fechaProbableDespacho;
	private String estado;
	private Date fechaGeneracion;
	private Date fechaRealDespacho;
	private OrdenDeProduccionDto ordenProduccion;
	private ClienteDto cliente;
	private ArrayList<ItemPrendaDto> items;
	
	public PedidoPrendasDto(int nroPedido, Date fechaProbableDespacho, String estado, Date fechaGeneracion,
			Date fechaRealDespacho, OrdenDeProduccionDto ordenProduccion, ClienteDto cliente, ArrayList<ItemPrendaDto> items){
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

	public OrdenDeProduccionDto getOrdenProduccion() {
		return ordenProduccion;
	}

	public void setOrdenProduccion(OrdenDeProduccionDto ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}

	public ClienteDto getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDto cliente) {
		this.cliente = cliente;
	}

	public ArrayList<ItemPrendaDto> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemPrendaDto> items) {
		this.items = items;
	}
	

}
