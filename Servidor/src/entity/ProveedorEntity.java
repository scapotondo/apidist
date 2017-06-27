package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import negocio.Proveedor;

@Entity
@Table(name="Proveedor")
public class ProveedorEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String telefono;
	private String nombre;
	private String domicilio;
	private String cuit;
	private String cbu;
	
	public ProveedorEntity(){}
	
	public ProveedorEntity(int id,String telefono,String nombre,String domicilio, String cuit, String cbu){
		this.id=id;
		this.telefono=telefono;
		this.nombre=nombre;
		this.domicilio=domicilio;
		this.cuit=cuit;
		this.cbu=cbu;
	}
	
	public ProveedorEntity(Proveedor proveedor){
		this.id=proveedor.getId();
		this.telefono=proveedor.getTelefono();
		this.nombre=proveedor.getNombre();
		this.domicilio=proveedor.getDomicilio();
		this.cuit=proveedor.getCuit();
		this.cbu=proveedor.getCbu();
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
	
	
}