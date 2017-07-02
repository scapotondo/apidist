package negocio;

import dto.ItemPrendaDto;
import entity.ItemPrendaEntity;

public class ItemPrenda {

	private int cantidad;
	private String talle;
	private String color;
	private float importe;
	private Prenda prenda;
	private OrdenDeProduccion lote;
	private int id;
	
	
	public ItemPrenda(ItemPrendaEntity item){
		this.cantidad=item.getCantidad();
		this.talle=item.getTalle();
		this.color=item.getColor();
		this.importe=item.getImporte();
		this.prenda=new Prenda(item.getPrenda());
		//TODO: ver como manejar por ser clase abstracta
		//this.lote = new OrdenDeProduccion(item.getLote());
	}
	
	//TODO: usar ColorPrenda en lugar de string
	//TODO: es necesario tener Orden De Produccion?
	public ItemPrenda(int cantidad, String talle, String color, float importe, Prenda prenda, OrdenDeProduccion lote ){
		this.cantidad=cantidad;
		this.talle=talle;
		this.color=color;
		this.importe=importe;
		this.prenda=prenda;
		this.lote = lote;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}

	public OrdenDeProduccion getLote() {
		return lote;
	}

	public void setLote(OrdenDeProduccion lote) {
		this.lote = lote;
	}

	public boolean hayStocksuficiente(){
		return true;
	}
	
	
	public ItemPrendaDto toDto(){
		//TODO: arreglar lote que banque listas y null
		return new ItemPrendaDto(cantidad, talle, color, importe, prenda.toDto(), null);
	}

	public void disminuirCantidad(int cant){
		this.cantidad = this.cantidad - cant;
	}
	
	public Float getPrecio(){
		return this.importe * this.cantidad;
	}
}
