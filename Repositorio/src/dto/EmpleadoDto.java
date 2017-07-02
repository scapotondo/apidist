package dto;

import java.io.Serializable;

public class EmpleadoDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String nombre;
	private String domicilio;
	private String telefono;
	private int legajo;
	private String rol;
	private String rolUsuario;
	
	public EmpleadoDto(){}
	
	public EmpleadoDto(String nombre, String domicilio, String telefono, int legajo, String rol, String rolUsuario){
		this.nombre=nombre;
		this.domicilio=domicilio;
		this.telefono=telefono;
		this.legajo=legajo;
		this.rol=rol;
		this.rolUsuario = rolUsuario;
	}

	public EmpleadoDto(int legajo) {
		this.legajo = legajo;
	}

	public String getRolUsuario() {
		return rolUsuario;
	}

	public void setRolUsuario(String rolUsuario) {
		this.rolUsuario = rolUsuario;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
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
