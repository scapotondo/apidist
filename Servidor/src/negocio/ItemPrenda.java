package negocio;

public class ItemPrenda {

	private int cantidad;
	private String talle;
	private String color;
	private float importe;
	private Prenda prenda;
	
	public ItemPrenda(int cantidad, String talle, String color,float importe, Prenda prenda ){
		this.cantidad=cantidad;
		this.talle=talle;
		this.color=color;
		this.importe=importe;
		this.prenda=prenda;
	}
	
	public boolean hayStocksuficiente(){
		return true;
	}
}
