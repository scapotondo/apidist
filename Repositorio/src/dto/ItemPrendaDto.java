package dto;


public class ItemPrendaDto {

	private int cantidad;
	private String talle;
	private String color;
	private float importe;
	private PrendaDto prenda;
	private OrdenDeProduccionDto lote;
	
	public ItemPrendaDto(int cantidad, String talle, String color,float importe, PrendaDto prenda, OrdenDeProduccionDto lote ){
		this.cantidad=cantidad;
		this.talle=talle;
		this.color=color;
		this.importe=importe;
		this.prenda=prenda;
		this.lote = lote;
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

	public PrendaDto getPrenda() {
		return prenda;
	}

	public void setPrenda(PrendaDto prenda) {
		this.prenda = prenda;
	}

	public OrdenDeProduccionDto getLote() {
		return lote;
	}

	public void setLote(OrdenDeProduccionDto lote) {
		this.lote = lote;
	}
	
}
