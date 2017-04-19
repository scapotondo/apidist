package negocio;

import java.util.Date;

public class MovimientoMateriaPrima {

	private String estado;
	private int cantidad;
	private Date fecha;
	private MateriaPrima materiaPrima;
	
	public MovimientoMateriaPrima(String estado, int cantidad, Date fecha, MateriaPrima materiaPrima){
		this.estado=estado;
		this.cantidad=cantidad;
		this.fecha=fecha;
		this.materiaPrima=materiaPrima;
	}
}
