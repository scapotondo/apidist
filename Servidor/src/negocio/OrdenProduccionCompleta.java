package negocio;

import java.util.ArrayList;

import entity.OrdenDeProduccionCompletaEntity;

public class OrdenProduccionCompleta extends OrdenDeProduccion{

	public OrdenProduccionCompleta(int nroOrden, String estado,ArrayList<MateriaPrima> materiaPrimaReservada, PedidoPrendas pedido, Prenda prenda) {
		super(nroOrden, estado,materiaPrimaReservada,pedido,prenda);
	}
	public OrdenProduccionCompleta(OrdenDeProduccionCompletaEntity lote) {
		super(lote);
	}
	
	public OrdenProduccionCompleta() {
		super();
	}
	
	@Override
	public int getCantidad() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
