package negocio;

import java.sql.Date;

public class FacturaB extends Factura{

	public FacturaB(int nroComprobante, Date fecha, String nombreComprador, String domicilioComprador, String cuit,
			String comprador, String condicionesVenta, String descripcion, float precio) {
		super(nroComprobante, fecha, nombreComprador, domicilioComprador, cuit, comprador, condicionesVenta, descripcion,
				precio);
	}

}
