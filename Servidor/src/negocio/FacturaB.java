package negocio;

import java.sql.Date;
import java.util.ArrayList;

public class FacturaB extends Factura{

	public FacturaB(int nroComprobante, Date fecha, String nombreComprador, String domicilioComprador, String cuit,
			String comprador, String condicionesVenta, ArrayList<ItemFactura> items, float precio) {
		
		super(nroComprobante, fecha, nombreComprador, domicilioComprador, cuit, comprador, condicionesVenta, items,
				precio);
	}

	@Override
	public float getTotal() {
		return (float) (this.getPrecio() * 1.21);
	}

}
