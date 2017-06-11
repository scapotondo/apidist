package controller;

import java.util.ArrayList;

import negocio.MateriaPrima;
import negocio.OrdenDeCompra;


public class AreaComprasController {
	private static AreaComprasController instance;
	
	private ArrayList<OrdenDeCompra> ordenesCompras;
	

	private AreaComprasController(){
		this.ordenesCompras = new ArrayList<OrdenDeCompra>();
	}
	
	public static AreaComprasController getInstance(){
		if(instance == null)
			instance = new AreaComprasController();
		
		return instance;
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
