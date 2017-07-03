package negocio;

import java.util.ArrayList;
import java.util.Date;

public class FacturaA extends Factura{

	
	
	public FacturaA(int nroComprobante, Date fecha, String nombreComprador, String domicilioComprador, String cuit,
			 String condicionesVenta, ArrayList<ItemFactura> items, float precio) {
		
		super(nroComprobante, fecha, nombreComprador, domicilioComprador, cuit, condicionesVenta, items,
				precio);
	}
	
	public FacturaA( Date fecha, String nombreComprador, String domicilioComprador, String cuit,
			 String condicionesVenta, ArrayList<ItemFactura> items, float precio) {
		
		super( fecha, nombreComprador, domicilioComprador, cuit, condicionesVenta, items, precio);
	}
	
	
	public float getIva(){
		return (float) (this.getPrecio() * 0.21);
	}

	@Override
	public float getTotal() {
		return (float) (this.getPrecio() + this.getIva());
	}
	
}
