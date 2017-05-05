package dto;


public class InsumoDto {

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
	
}
