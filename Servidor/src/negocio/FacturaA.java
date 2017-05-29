package negocio;

import java.sql.Date;

public class FacturaA extends Factura{

	
	
	public FacturaA(int nroComprobante, Date fecha, String nombreComprador, String domicilioComprador, String cuit,
			String comprador, String condicionesVenta, String descripcion, float precio) {
		
		super(nroComprobante, fecha, nombreComprador, domicilioComprador, cuit, comprador, condicionesVenta, descripcion,
				precio);
	}
	
	public float getIva(){
		return (float) (this.getPrecio() * 0.21);
	}
	
}
