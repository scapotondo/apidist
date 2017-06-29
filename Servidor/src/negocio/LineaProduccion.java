package negocio;

import dao.LineaProduccionDao;
import dto.LineaProduccionDto;
import entity.LineaProduccionEntity;

public class LineaProduccion {
	public static final String OCUPADO = "Ocupado";
	public static final String LIBRE = "Libre";
	
	private int numero;
	private String estado;
	private Float tiempoLiberarse;
	private String trabajo;
	
	public LineaProduccion(){}
	
	public LineaProduccion(LineaProduccionEntity linea){
		this.numero=linea.getNumero();
		this.estado= linea.getEstado();
		this.tiempoLiberarse=linea.getTiempoLiberarse();
		this.trabajo=linea.getTrabajo();
	}
	
	public LineaProduccion(int numero, String estado, Float tiempoLiberarse, String trabajo){
		this.numero=numero;
		this.estado= estado;
		this.tiempoLiberarse=tiempoLiberarse;
		this.trabajo=trabajo;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Float getTiempoLiberarse() {
		return tiempoLiberarse;
	}

	public void setTiempoLiberarse(Float tiempoLiberarse) {
		this.tiempoLiberarse = tiempoLiberarse;
	}

	public String getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}

	
	public void asignarTrabajo(String trabajo, Float tiempo){
		this.setTiempoLiberarse(tiempo);
		this.setTrabajo(trabajo);
		this.setEstado(OCUPADO);
		modificar();
	}
	
	//TODO: checkear si el trabajo y tiempo cuando esta vacio lo dejamos en null o ponemos un valor pro defecto.
	public void Liberar(){
		this.setTiempoLiberarse(null);
		this.setTrabajo(null);
		this.setEstado(LIBRE);
		modificar();
	}
	
	public void modificar(){
		LineaProduccionDao.getInstance().Modificar(this);
	}
	
	public LineaProduccionDto toDto(){
		return new LineaProduccionDto(numero, estado, tiempoLiberarse, trabajo);
	}

}
