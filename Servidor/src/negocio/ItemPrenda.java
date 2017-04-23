package negocio;

import entity.OrdenDeProduccionEntity;

public class ItemPrenda {

	private int cantidad;
	private String talle;
	private String color;
	private float importe;
	private Prenda prenda;
	private OrdenDeProduccion lote;
	
	public ItemPrenda(int cantidad, String talle, String color,float importe, Prenda prenda, OrdenDeProduccion lote ){
		this.cantidad=cantidad;
		this.talle=talle;
		this.color=color;
		this.importe=importe;
		this.prenda=prenda;
		this.lote = lote;
	}
	
	public boolean hayStocksuficiente(){
		return true;
	}
}
