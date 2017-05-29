package entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Factura")
public class FacturaEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int nroComprobante;
	
	
	private String razonSocialVendedor;
	private String domicilioVendedor;
	private String telefonoVendedor;
	private String datosIvaVendedor;
	private String cuitVendedor;
	
	private Date fecha;
	
	private String nombreComprador;
	private String domicilioComprador;
	private String cuitComprador;
	
	private String condicionesVenta; //efectivo, cheque, cuenta corriente
	private String descripcion; //elemento, cantidad, precio unitario
	private float precio;
	
	public FacturaEntity(){}
	
	public FacturaEntity(int nroComprobante, Date fecha, String nombreComprador, String domicilioComprador, String cuit,
			String comprador, String condicionesVenta, String descripcion, float precio, String razonSocialVendedor,
			String domicilioVendedor,String telefonoVendedor, String datosIvaVendedor, String cuitVendedor){
		
		this.razonSocialVendedor = razonSocialVendedor;
		this.domicilioVendedor = domicilioVendedor;
		this.telefonoVendedor = telefonoVendedor;
		this.datosIvaVendedor = datosIvaVendedor;
		this.cuitVendedor = cuitVendedor;
		this.nroComprobante = nroComprobante;
		this.fecha = fecha;
		this.nombreComprador = nombreComprador;
		this.domicilioComprador = domicilioComprador;
		this.cuitComprador = cuit;
		this.condicionesVenta = condicionesVenta;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public int getNroComprobante() {
		return nroComprobante;
	}

	public String getRazonSocialVendedor() {
		return razonSocialVendedor;
	}

	public void setRazonSocialVendedor(String razonSocialVendedor) {
		this.razonSocialVendedor = razonSocialVendedor;
	}

	public String getDomicilioVendedor() {
		return domicilioVendedor;
	}

	public void setDomicilioVendedor(String domicilioVendedor) {
		this.domicilioVendedor = domicilioVendedor;
	}

	public String getTelefonoVendedor() {
		return telefonoVendedor;
	}

	public void setTelefonoVendedor(String telefonoVendedor) {
		this.telefonoVendedor = telefonoVendedor;
	}

	public String getDatosIvaVendedor() {
		return datosIvaVendedor;
	}

	public void setDatosIvaVendedor(String datosIvaVendedor) {
		this.datosIvaVendedor = datosIvaVendedor;
	}

	public String getCuitVendedor() {
		return cuitVendedor;
	}

	public void setCuitVendedor(String cuitVendedor) {
		this.cuitVendedor = cuitVendedor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombreComprador() {
		return nombreComprador;
	}

	public void setNombreComprador(String nombreComprador) {
		this.nombreComprador = nombreComprador;
	}

	public String getDomicilioComprador() {
		return domicilioComprador;
	}

	public void setDomicilioComprador(String domicilioComprador) {
		this.domicilioComprador = domicilioComprador;
	}

	public String getCuitComprador() {
		return cuitComprador;
	}

	public void setCuitComprador(String cuitComprador) {
		this.cuitComprador = cuitComprador;
	}

	public String getCondicionesVenta() {
		return condicionesVenta;
	}

	public void setCondicionesVenta(String condicionesVenta) {
		this.condicionesVenta = condicionesVenta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	
}
