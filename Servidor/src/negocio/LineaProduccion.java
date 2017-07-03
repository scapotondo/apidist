package negocio;

import dao.LineaProduccionDao;
import dto.LineaProduccionDto;
import entity.LineaProduccionEntity;
import entity.OrdenDeProduccionCompletaEntity;
import entity.OrdenDeProduccionParcialEntity;

public class LineaProduccion {
	public static final String OCUPADO = "Ocupado";
	public static final String LIBRE = "Libre";
	
	private int numero;
	private String estado;
	private Float tiempoLiberarse;
	private String trabajo;
	private OrdenDeProduccion orden;
	
	public LineaProduccion(){}
	
	public LineaProduccion(LineaProduccionEntity linea){
		this.numero=linea.getNumero();
		this.estado= linea.getEstado();
		this.tiempoLiberarse=linea.getTiempoLiberarse();
		this.trabajo=linea.getTrabajo();
		
		if(linea.getOrden() != null){
			if(linea.getOrden().getClass().getName().equals("entity.OrdenDeProduccionCompletaEntity"))
				this.orden=new OrdenProduccionCompleta((OrdenDeProduccionCompletaEntity) linea.getOrden());
			
			else
				this.orden=new OrdenProduccionParcial((OrdenDeProduccionParcialEntity) linea.getOrden());
		}
	}
	
	public LineaProduccion(int numero, String estado, Float tiempoLiberarse, String trabajo,OrdenDeProduccion orden){
		this.numero=numero;
		this.estado= estado;
		this.tiempoLiberarse=tiempoLiberarse;
		this.trabajo=trabajo;
		this.orden = orden;
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
	
	public OrdenDeProduccion getOrden() {
		return orden;
	}

	public void setOrden(OrdenDeProduccion orden) {
		this.orden = orden;
	}

	public void asignarTrabajo(String trabajo, Float tiempo, OrdenDeProduccion orden){
		this.setTiempoLiberarse(tiempo);
		this.setTrabajo(trabajo);
		this.setEstado(OCUPADO);
		this.orden = orden;
		modificar();
	}
	
	public void Liberar(){
		this.setTiempoLiberarse(null);
		this.setTrabajo(null);
		this.setEstado(LIBRE);
		this.setOrden(null);
		modificar();
	}
	
	public void modificar(){
		LineaProduccionDao.getInstance().Modificar(this);
	}
	
	public LineaProduccionDto toDto(){
		return new LineaProduccionDto(numero, estado, tiempoLiberarse, trabajo);
	}

}
