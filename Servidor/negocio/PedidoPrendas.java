package negocio;

import java.util.ArrayList;
import java.util.Date;

public class PedidoPrendas {
	
	private int nroPedido;
	private Date fechaProbableDespacho;
	private String estado;
	private Date fechaGeneracion;
	private Date fechaRealDespacho;
	private OrdenDeProduccion ordenProduccion;
	private Cliente cliente;
	private ArrayList<ItemPrenda> items;
	
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
	
	public void calcularTotal(){
		
	}
	//cambiar el void a PedidoPrendasDto
	public void getPedidoPrendasDto(){
		
	}
	public void aprobarPedido(){
		
	}
	
}
