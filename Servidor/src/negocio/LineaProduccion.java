package negocio;

import java.util.Date;

public class LineaProduccion {
	private int numero;
	private String estado;
	private Date tiempoLiberarse;
	private String trabajo;
	
	public LineaProduccion(int numero, String estado, Date tiempoLiberarse, String trabajo){
		this.numero=numero;
		this.estado= estado;
		this.tiempoLiberarse=tiempoLiberarse;
		this.trabajo=trabajo;
	}
	
	public void asignarTrabajo(String trabajo, Date tiempo){
		
	}
	

}
