package negocio;

import dto.EmpleadoDto;
import dto.RolUsuarioEnum;
import entity.EmpleadoEntity;

public class Empleado {

	private String nombre;
	private String domicilio;
	private String telefono;
	private int legajo;
	private Rol rol;
	private String usuario;
	private String password;
	private RolUsuarioEnum rolUsuario;
	
	public Empleado (EmpleadoEntity empleado){
		this.nombre=empleado.getNombre();
		this.domicilio=empleado.getDomicilio();
		this.telefono=empleado.getTelefono();
		this.legajo=empleado.getLegajo();
		this.rol=empleado.getRol();
		this.usuario = empleado.getUsuario();
		this.password = empleado.getPassword();
		this.rolUsuario = RolUsuarioEnum.fromString(empleado.getRolUsuario());
	}
	
	public Empleado(String nombre, String domicilio, String telefono, int legajo,Rol rol, String usuario, String password,
			RolUsuarioEnum rolUsuario){
		this.nombre=nombre;
		this.domicilio=domicilio;
		this.telefono=telefono;
		this.legajo=legajo;
		this.rol=rol;
		this.usuario = usuario;
		this.password = password;
		this.rolUsuario = rolUsuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
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
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RolUsuarioEnum getRolUsuario() {
		return rolUsuario;
	}

	public void setRolUsuario(RolUsuarioEnum rolUsuario) {
		this.rolUsuario = rolUsuario;
	}

	public EmpleadoDto toDto(){
		return new EmpleadoDto(this.nombre, this.domicilio, this.telefono, this.legajo, this.rol+"", this.rolUsuario.toString());
	}
	
}
