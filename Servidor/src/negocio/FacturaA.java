package negocio;

import java.sql.Date;
import java.util.ArrayList;

public class FacturaA extends Factura{

	
	
	public FacturaA(int nroComprobante, Date fecha, String nombreComprador, String domicilioComprador, String cuit,
			String comprador, String condicionesVenta, ArrayList<ItemFactura> items, float precio) {
		
		super(nroComprobante, fecha, nombreComprador, domicilioComprador, cuit, comprador, condicionesVenta, items,
				precio);
	}
	
	public float getIva(){
		return (float) (this.getPrecio() * 0.21);
	}

	@Override
	public float getTotal() {
		return (float) (this.getPrecio() * 1.21);
	}
	
}
