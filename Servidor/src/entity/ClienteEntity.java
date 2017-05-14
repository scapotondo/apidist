package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import negocio.Cliente;
import negocio.PedidoPrendas;

@Entity
@Table(name="Cliente")
@Embeddable
public class ClienteEntity implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int legajo;
	
	@Column(nullable=false)
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
	
	@OneToMany(mappedBy = "cliente")
	private List<PedidoPrendasEntity> pedidosAceptados;
	
	@ManyToOne(targetEntity=SucursalEntity.class)
	@Embedded
	private SucursalEntity sucursal;
	
	public ClienteEntity(){}
	public ClienteEntity(float limiteCredito,String formaPago, float cuentaCorriente, String cuit, String nombre, String razonSocial,
						String telefono, String direccionEnvio,String direccionFacturacion,
						ArrayList<PedidoPrendasEntity> pedidosAceptados, SucursalEntity sucursal ){
		
		this.limiteCredito=limiteCredito;
		this.formaPago=formaPago;
		this.cuentaCorriente=cuentaCorriente;
		this.cuit=cuit;
		this.nombre=nombre;
		this.razonSocial=razonSocial;
		this.telefono=telefono;
		this.direccionEnvio=direccionEnvio;
		this.direccionFacturacion=direccionFacturacion;
		this.legajo=legajo;
		this.sucursal=sucursal;
		this.pedidosAceptados= pedidosAceptados;
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
		
		this.pedidosAceptados= new ArrayList<PedidoPrendasEntity>();
		if(cliente.getPedidosAceptados()!= null){
			for (PedidoPrendas pedido : cliente.getPedidosAceptados()) {
				this.pedidosAceptados.add(new PedidoPrendasEntity(pedido));
			}
		}
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
	public List<PedidoPrendasEntity> getPedidosAceptados() {
		return pedidosAceptados;
	}
	public void setPedidosAceptados(List<PedidoPrendasEntity> pedidosAceptados) {
		this.pedidosAceptados = pedidosAceptados;
	}
	public SucursalEntity getSucursal() {
		return sucursal;
	}
	public void setSucursal(SucursalEntity sucursal) {
		this.sucursal = sucursal;
	}
	
	
	
}
