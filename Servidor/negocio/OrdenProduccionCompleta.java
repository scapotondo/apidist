package negocio;

import java.util.ArrayList;

public class OrdenProduccionCompleta extends OrdenDeProduccion{

	public OrdenProduccionCompleta(String estadoo,ArrayList<MateriaPrima> materiaPrimaReservada, PedidoPrendas pedido, Prenda prenda) {
		super(estadoo,materiaPrimaReservada,pedido,prenda);
	}
	@Override
	public int getCantidad() {
		// TODO Auto-generated method stub
		return 0;
	}

}
