package negocio;

import java.util.ArrayList;

public class Sucursal {
	
	private int numero;
	private String nombre;
	private String direccion;
	private ArrayList<String> horarios;
	private Empleado gerente;
	private ArrayList<Empleado> empleados;
	private ArrayList<PedidoPrendas> pedidos;
	
	public void aceptarPedido(PedidoPrendas pedido){
		
	}
	
	public void addNuevoPedido(PedidoPrendas pedido){
		pedidos.add(pedido);
	}
	
	public void rechazarPedido(PedidoPrendas pedido, String descripcion){
		
	}
	
	private ArrayList<PedidoPrendas> getPedidosPendientes(){
		return null;
	}

}
