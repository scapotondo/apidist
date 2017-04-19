package negocio;

import java.util.ArrayList;

public abstract class OrdenDeProduccion {

	private String estado;
	private ArrayList<MateriaPrima> materiaPrimaReservada;
	private int confeccionesTerminadas;
	private PedidoPrendas pedido;
	private Prenda prenda;
	
	public OrdenDeProduccion(String estadoo,ArrayList<MateriaPrima> materiaPrimaReservada, PedidoPrendas pedido, Prenda prenda){
		this.estado=estadoo;
		this.materiaPrimaReservada=materiaPrimaReservada;
		this.confeccionesTerminadas=0;
		this.pedido=pedido;
		this.prenda=prenda;
	}
	
	public abstract int getCantidad();
	
}
