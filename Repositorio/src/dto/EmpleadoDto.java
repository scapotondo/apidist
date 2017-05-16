package dto;

public class EmpleadoDto {

	private String nombre;
	private String domicilio;
	private String telefono;
	private int legajo;
	
	public EmpleadoDto(String nombre, String domicilio, String telefono, int legajo){
		this.nombre=nombre;
		this.domicilio=domicilio;
		this.telefono=telefono;
		this.legajo=legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	

}