package dto;

import java.util.ArrayList;


public class AreaComprasDto {
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
