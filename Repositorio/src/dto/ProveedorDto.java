package dto;

public class ProveedorDto {

	private String telefono;
	private String nombre;
	private String domicilio;
	private String cuit;
	private String cbu;
	
	public ProveedorDto(String telefono, String nombre, String domicilio, String cuit, String cbu){
		this.telefono=telefono;
		this.nombre=nombre;
		this.domicilio=domicilio;
		this.cuit=cuit;
		this.cbu=cbu;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getCbu() {
		return cbu;
	}

	public void setCbu(String cbu) {
		this.cbu = cbu;
	}
	
}
