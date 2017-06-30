package entity;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Type;
import negocio.Cliente;

@Entity
@Table(name="Cliente")
@Embeddable
public class ClienteEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int legajo;
	
	@Column(nullable=false)
	@Type(type = "float")
	private float limiteCredito;
	
	@Column(nullable=false)
	private String formaPago;
	private float cuentaCorriente;
	
	@Column(nullable=false)
	private String cuit;
	
	@Column(nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private String razonSocial;
	private String telefono;
	private String direccionEnvio;
	
	@Column(nullable=false)
	private String direccionFacturacion;
	
	@ManyToOne()
	private SucursalEntity sucursal;
	
	public ClienteEntity(){}
	public ClienteEntity(float limiteCredito,String formaPago, float cuentaCorriente, String cuit, String nombre, String razonSocial,
						String telefono, String direccionEnvio,String direccionFacturacion,
						SucursalEntity sucursal ){
		
		this.limiteCredito=limiteCredito;
		this.formaPago=formaPago;
		this.cuentaCorriente=cuentaCorriente;
		this.cuit=cuit;
		this.nombre=nombre;
		this.razonSocial=razonSocial;
		this.telefono=telefono;
		this.direccionEnvio=direccionEnvio;
		this.direccionFacturacion=direccionFacturacion;
		this.sucursal=sucursal;
	}
	
	public ClienteEntity(Cliente cliente ){
		
		this.limiteCredito=cliente.getLimiteCredito();
		this.formaPago=cliente.getFormaPago();
		this.cuentaCorriente=cliente.getCuentaCorriente();
		this.cuit=cliente.getCuit();
		this.nombre=cliente.getNombre();
		this.razonSocial=cliente.getRazonSocial();
		this.telefono=cliente.getTelefono();
		this.direccionEnvio=cliente.getDireccionEnvio();
		this.direccionFacturacion=cliente.getDireccionFacturacion();
		this.legajo=cliente.getLegajo();
		this.sucursal=new SucursalEntity(cliente.getSucursal());
	}
	
	
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	public float getLimiteCredito() {
		return limiteCredito;
	}
	public void setLimiteCredito(float limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	public float getCuentaCorriente() {
		return cuentaCorriente;
	}
	public void setCuentaCorriente(float cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccionEnvio() {
		return direccionEnvio;
	}
	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}
	public String getDireccionFacturacion() {
		return direccionFacturacion;
	}
	public void setDireccionFacturacion(String direccionFacturacion) {
		this.direccionFacturacion = direccionFacturacion;
	}
	public SucursalEntity getSucursal() {
		return sucursal;
	}
	public void setSucursal(SucursalEntity sucursal) {
		this.sucursal = sucursal;
	}
}
