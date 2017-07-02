package dto;

import java.io.Serializable;

public class ModificacionStockDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5176494368432528586L;
	
	int cantidad;
	String tipo;
	
	public ModificacionStockDto(int cantidad, String tipo) {
		this.cantidad = cantidad;
		this.tipo = tipo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
