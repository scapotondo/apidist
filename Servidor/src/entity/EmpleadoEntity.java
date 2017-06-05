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

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int legajo;
	private String nombre;
	private String domicilio;
	private String telefono;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "rol")
	private Rol rol;
	
	public EmpleadoEntity(){}
	public EmpleadoEntity(String nombre, String domicilio, String telefono, int legajo,Rol rol){
		this.nombre=nombre;
		this.domicilio=domicilio;
		this.telefono=telefono;
		this.legajo=legajo;
		this.rol=rol;
	}
	public EmpleadoEntity(Empleado empleado){
		this.nombre = empleado.getNombre();
		this.domicilio = empleado.getDomicilio();
		this.telefono = empleado.getTelefono();
		this.legajo = empleado.getLegajo();
		this.rol=empleado.getRol();
		this.legajo = empleado.getLegajo();		
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

	
}
