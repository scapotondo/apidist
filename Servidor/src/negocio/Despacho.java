package negocio;

import java.util.ArrayList;

public class Despacho {

	private Almacen almacen;
	private ArrayList<PedidoPrendas> pedidosPrenda;
	private Administracion administracion;
	private int id;
	
	public Despacho(Almacen almacen,ArrayList<PedidoPrendas> pedidosPrenda,Administracion administracion){
		this.almacen=almacen;
		this.pedidosPrenda=pedidosPrenda;
		this.administracion=administracion;
	}
	
	public void completarPedidos(ArrayList<StockPrenda> prendas, PedidoPrendas pedido){
		
	}
	public void armarPedido(PedidoPrendas pedido){
		
	}
	public void despacharPedido(PedidoPrendas pedido){
		
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public ArrayList<PedidoPrendas> getPedidosPrenda() {
		return pedidosPrenda;
	}

	public void setPedidosPrenda(ArrayList<PedidoPrendas> pedidosPrenda) {
		this.pedidosPrenda = pedidosPrenda;
	}

	public Administracion getAdministracion() {
		return administracion;
	}

	public void setAdministracion(Administracion administracion) {
		this.administracion = administracion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
