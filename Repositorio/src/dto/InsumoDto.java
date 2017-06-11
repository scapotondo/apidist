package dto;

import java.io.Serializable;

public class InsumoDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int cantidad;
	private int desperdicio;
	private MateriaPrimaDto materiaPrima;
	
	public InsumoDto(int cantidad, int desperdicio, MateriaPrimaDto materiaPrima){
		this.cantidad=cantidad;
		this.desperdicio=desperdicio;
		this.materiaPrima=materiaPrima;
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

	@Override
	public String toString() {
		return this.cantidad + " " + this.materiaPrima.getNombre() ;
	}
	
}
