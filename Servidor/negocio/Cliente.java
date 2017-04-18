package negocio;

import java.util.ArrayList;

public class Cliente {
	
	private float limiteCredito;
	private String formaPago;
	private float cuentaCorriente;
	private String cuit;
	private String nombre;
	private String razonSocial;
	private String telefono;
	private String direccionEnvio;
	private String direccionFacturacion;
	private int legajo;
	private ArrayList<PedidoPrendas> pedidosAceptados;
	private Sucursal sucursal;
	
	public Cliente(float limiteCredito,String formaPago, float cuentaCorriente, String cuit, String nombre, String razonSocial,
			String telefono, String direccionEnvio,String direccionFacturacion, int legajo, Sucursal sucursal ){
		
		this.limiteCredito=limiteCredito;
		this.formaPago=formaPago;
		this.cuentaCorriente=cuentaCorriente;
		this.cuit=cuit;
		this.nombre=nombre;
		this.razonSocial=razonSocial;
		this.telefono=telefono;
		this.direccionEnvio=direccionEnvio;
		this.direccionFacturacion=direccionFacturacion;
		this.legajo=legajo;
		this.sucursal=sucursal;
		this.pedidosAceptados= new ArrayList<PedidoPrendas>();
	}
	
	public void addNuevoPedidoAceptado(PedidoPrendas pedido){
		pedidosAceptados.add(pedido);
	}
	
	public void addNuevoPedidoRechazado(PedidoPrendas pedido, String descripcion){
		//ver como manejar la descripcion en el pedido rechazado. puede ser agregar un campo en
		// PedidoPrendas y que si es aceptado diga "Aceptado"
	}

}
