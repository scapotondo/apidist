package negocio;

import dto.ProveedorDto;
import entity.ProveedorEntity;

public class Proveedor {

	private int id;

	private String telefono;
	private String nombre;
	private String domicilio;
	private String cuit;
	private String cbu;
	
	
	public Proveedor(ProveedorEntity proveedor){
		this.telefono=proveedor.getTelefono();
		this.nombre=proveedor.getNombre();
		this.domicilio=proveedor.getDomicilio();
		this.cuit=proveedor.getCuit();
		this.cbu=proveedor.getCbu();
		this.id=proveedor.getId();
	}
	public Proveedor(String telefono, String nombre, String domicilio, String cuit, String cbu){
		this.telefono=telefono;
		this.nombre=nombre;
		this.domicilio=domicilio;
		this.cuit=cuit;
		this.cbu=cbu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public ProveedorDto toDto(){
		return new ProveedorDto(telefono, nombre, domicilio, cuit, cbu);
	}
	
}
