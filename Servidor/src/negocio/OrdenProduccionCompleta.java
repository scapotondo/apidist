package negocio;

import java.util.ArrayList;

public class OrdenProduccionCompleta extends OrdenDeProduccion{

	public OrdenProduccionCompleta(int nroOrden, String estadoo,ArrayList<MateriaPrima> materiaPrimaReservada, PedidoPrendas pedido, Prenda prenda) {
		super(nroOrden, estadoo,materiaPrimaReservada,pedido,prenda);
	}
	@Override
	public int getCantidad() {
		// TODO Auto-generated method stub
		return 0;
	}

}
