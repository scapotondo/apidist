package dto;

import java.io.Serializable;
import java.util.ArrayList;


public class AreaComprasDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<OrdenDeCompraDto> ordenesCompras;
	
	public AreaComprasDto(ArrayList<OrdenDeCompraDto> ordenesCompras){
		this.ordenesCompras=ordenesCompras;
	}

	public ArrayList<OrdenDeCompraDto> getOrdenesCompras() {
		return ordenesCompras;
	}

	public void setOrdenesCompras(ArrayList<OrdenDeCompraDto> ordenesCompras) {
		this.ordenesCompras = ordenesCompras;
	}
	
}
