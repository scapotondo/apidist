package negocio;

import java.util.ArrayList;


public class AreaCompras {

	private ArrayList<OrdenDeCompra> ordenesCompras;
	
	public AreaCompras(ArrayList<OrdenDeCompra> ordenesCompras){
		this.ordenesCompras=ordenesCompras;
	}
	
	public void comprar(MateriaPrima materiaPrima,int cantidad){
		
	}
	public void generarNotaDeCredito(){
		
	}
	public void generarNotaDeDebito(){
		
	}
	public ArrayList<Integer> getNroOrdenCompra(){
		return null;
	}

	public ArrayList<OrdenDeCompra> getOrdenesCompras() {
		return ordenesCompras;
	}

	public void setOrdenesCompras(ArrayList<OrdenDeCompra> ordenesCompras) {
		this.ordenesCompras = ordenesCompras;
	}
	
}
