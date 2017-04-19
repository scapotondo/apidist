package negocio;

import java.util.ArrayList;

public class Insumo {
	private int cantidad;
	private int desperdicio;
	private MateriaPrima materiaPrima;
	
	public Insumo(int cantidad, int desperdicio, MateriaPrima materiaPrima){
		this.cantidad=cantidad;
		this.desperdicio=desperdicio;
		this.materiaPrima=materiaPrima;
	}

	public ArrayList<MateriaPrima> getMateriaPrima(){
		return null;
	}
}
