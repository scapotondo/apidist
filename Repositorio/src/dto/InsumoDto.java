package dto;

import java.io.Serializable;

public class InsumoDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int cantidad;
	private int desperdicio;
	private MateriaPrimaDto materiaPrima;
	private int precio;
	
	public InsumoDto(int cantidad, int desperdicio, MateriaPrimaDto materiaPrima, int precio){
		this.cantidad=cantidad;
		this.desperdicio=desperdicio;
		this.materiaPrima=materiaPrima;
		this.precio=precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getDesperdicio() {
		return desperdicio;
	}

	public void setDesperdicio(int desperdicio) {
		this.desperdicio = desperdicio;
	}

	public MateriaPrimaDto getMateriaPrima() {
		return materiaPrima;
	}

	public void setMateriaPrima(MateriaPrimaDto materiaPrima) {
		this.materiaPrima = materiaPrima;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
}
