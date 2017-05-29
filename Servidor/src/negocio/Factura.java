package negocio;

import java.sql.Date;
import java.util.ArrayList;

public abstract class Factura {
	
	public static final String RAZON_SOCIAL_VENDEDOR = "El caracol S.A.";
	public static final String DOMICILIO_VENDEDOR = "Av. Martin Garcia 500";
	public static final String TELEFONO_VENDEDOR = "4301-3000";
	public static final String DATOS_IVA_VENDEDOR = "Responsable Inscripto";
	public static final String CUIT_VENDEDOR = "30-12341234-1";
	
	private String razonSocialVendedor;
	private String domicilioVendedor;
	private String telefonoVendedor;
	private String datosIvaVendedor;
	private String cuitVendedor;
	
	private int nroComprobante;
	private Date fecha;
	
	private String nombreComprador;
	private String domicilioComprador;
	private String cuitComprador;
	
	private String condicionesVenta; //efectivo, cheque, cuenta corriente
	private ArrayList<ItemFactura> items; //elemento, cantidad, precio unitario
	private float precio;
	
	public Factura(int nroComprobante, Date fecha, String nombreComprador, String domicilioComprador, String cuit, 
			String comprador, String condicionesVenta, ArrayList<ItemFactura> items, float precio){
		
		this.razonSocialVendedor = RAZON_SOCIAL_VENDEDOR;
		this.domicilioVendedor = DOMICILIO_VENDEDOR;
		this.telefonoVendedor = TELEFONO_VENDEDOR;
		this.datosIvaVendedor = DATOS_IVA_VENDEDOR;
		this.cuitVendedor = CUIT_VENDEDOR;
		this.nroComprobante = nroComprobante;
		this.fecha = fecha;
		this.nombreComprador = nombreComprador;
		this.domicilioComprador = domicilioComprador;
		this.cuitComprador = cuit;
		this.condicionesVenta = condicionesVenta;
		this.items = items;
		this.precio = precio;
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

	public int getNroComprobante() {
		return nroComprobante;
	}

	public void setNroComprobante(int nroComprobante) {
		this.nroComprobante = nroComprobante;
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

	public ArrayList<ItemFactura> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemFactura> items) {
		this.items = items;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public float getTotal(){
		return (float) (this.getPrecio() * 1.21);
	}

}
