package negocio;


import dto.InsumoDto;
import entity.InsumoEntity;

public class Insumo {
	private int cantidad;
	private int desperdicio;
	private MateriaPrima materiaPrima;
	
	
	public Insumo(InsumoEntity insumo){
		this.cantidad=insumo.getCantidad();
		this.desperdicio=insumo.getDesperdicio();
		this.materiaPrima=new MateriaPrima(insumo.getMateriaPrima());
	}
	
	public Insumo(int cantidad, int desperdicio, MateriaPrima materiaPrima){
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

	public void setMateriaPrima(MateriaPrima materiaPrima) {
		this.materiaPrima = materiaPrima;
	}

	public MateriaPrima getMateriaPrima(){
		return this.materiaPrima;
	}
	
	public InsumoDto toDto(){
		return new InsumoDto(cantidad, desperdicio, materiaPrima.toDto());
	}
}
