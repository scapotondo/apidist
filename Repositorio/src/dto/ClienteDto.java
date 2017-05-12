package dto;

import java.util.ArrayList;


public class ClienteDto {

	private float limiteCredito;
	private String formaPago;
	private float cuentaCorriente;
	private String cuit;
	private String nombre;
	private String razonSocial;
	private String telefono;
	private String direccionEnvio;
	private String direccionFacturacion;
	private int legajo;
	private ArrayList<PedidoPrendasDto> pedidosAceptados;
	private SucursalDto sucursal;
	
	public ClienteDto(float limiteCredito,String formaPago, float cuentaCorriente, String cuit, String nombre, String razonSocial,
			String telefono, String direccionEnvio,String direccionFacturacion, SucursalDto sucursal,
			ArrayList<PedidoPrendasDto> pedidosAceptados ){
		
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
		this.pedidosAceptados= pedidosAceptados;
	}
	
	public ClienteDto(float limiteCredito,String formaPago, float cuentaCorriente, String cuit, String nombre, String razonSocial,
			String telefono, String direccionEnvio,String direccionFacturacion, int legajo,SucursalDto sucursal,
			ArrayList<PedidoPrendasDto> pedidosAceptados ){
		
		this.limiteCredito=limiteCredito;
		this.formaPago=formaPago;
		this.cuentaCorriente=cuentaCorriente;
		this.cuit=cuit;
		this.nombre=nombre;
		this.legajo=legajo;
		this.razonSocial=razonSocial;
		this.telefono=telefono;
		this.direccionEnvio=direccionEnvio;
		this.direccionFacturacion=direccionFacturacion;
		this.sucursal=sucursal;
		this.pedidosAceptados= pedidosAceptados;
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

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public ArrayList<PedidoPrendasDto> getPedidosAceptados() {
		return pedidosAceptados;
	}

	public void setPedidosAceptados(ArrayList<PedidoPrendasDto> pedidosAceptados) {
		this.pedidosAceptados = pedidosAceptados;
	}

	public SucursalDto getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalDto sucursal) {
		this.sucursal = sucursal;
	}
}
