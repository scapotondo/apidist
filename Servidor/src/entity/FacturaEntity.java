package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import negocio.Factura;
import negocio.ItemFactura;

@Entity
@Table(name="Factura")
public class FacturaEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
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
	
	private float precio;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<ItemFacturaEntity> items;
	
	public FacturaEntity(){}
	
	public FacturaEntity(int nroComprobante, Date fecha, String nombreComprador, String domicilioComprador, String cuit,
			String comprador, String condicionesVenta, List<ItemFacturaEntity> items, float precio, String razonSocialVendedor,
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
		this.items = items;
		this.precio = precio;
	}
	
	public FacturaEntity(Factura factura){
		
		this.razonSocialVendedor = factura.getRazonSocialVendedor();
		this.domicilioVendedor = factura.getDomicilioVendedor();
		this.telefonoVendedor = factura.getTelefonoVendedor();
		this.datosIvaVendedor = factura.getDatosIvaVendedor();
		this.cuitVendedor = factura.getCuitVendedor();
		this.nroComprobante = factura.getNroComprobante();
		this.fecha = factura.getFecha();
		this.nombreComprador = factura.getNombreComprador();
		this.domicilioComprador = factura.getDomicilioComprador();
		this.cuitComprador = factura.getCuitComprador();
		this.condicionesVenta = factura.getCondicionesVenta();
		this.precio = factura.getPrecio();

		ArrayList<ItemFacturaEntity> items = new ArrayList<ItemFacturaEntity>();
		for (ItemFactura itemFactura : factura.getItems()) {
			items.add(new ItemFacturaEntity(itemFactura));
		}
		this.items = items;
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


	public List<ItemFacturaEntity> getItems() {
		return items;
	}

	public void setItems(List<ItemFacturaEntity> items) {
		this.items = items;
	}

	public void setNroComprobante(int nroComprobante) {
		this.nroComprobante = nroComprobante;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	
}
