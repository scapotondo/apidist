package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import negocio.Empleado;
import negocio.Rol;

@Entity
@Embeddable
@Table(name="Empleado")
public class EmpleadoEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int legajo;
	private String nombre;
	private String domicilio;
	private String telefono;
	private String usuario;
	private String password;
	private String rolUsuario;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "rol")
	private Rol rol;
	
	public EmpleadoEntity(){}
	
	public EmpleadoEntity(Empleado empleado){
		this.nombre = empleado.getNombre();
		this.domicilio = empleado.getDomicilio();
		this.telefono = empleado.getTelefono();
		this.legajo = empleado.getLegajo();
		this.rol=empleado.getRol();
		this.legajo = empleado.getLegajo();		
		this.usuario = empleado.getUsuario();
		this.password = empleado.getPassword();
		this.rolUsuario = empleado.getRolUsuario().toString();
	}
	
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
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
	public String getRolUsuario() {
		return rolUsuario;
	}
	public void setRolUsuario(String rolUsuario) {
		this.rolUsuario = rolUsuario;
	}
}
