package negocio;

import java.util.ArrayList;

import dao.ClienteDao;
import dao.SucursalDao;
import dto.ClienteDto;
import dto.SucursalDto;
import entity.ClienteEntity;
import exceptions.SucursalException;

public class Cliente {
	
	public static final String FACTURAA = "Factura A";
	public static final String FACTURAB = "Factura B";
	
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
	private Sucursal sucursal;
	
	
	public Cliente(ClienteEntity cliente ){
		this.legajo=cliente.getLegajo();
		this.limiteCredito=cliente.getLimiteCredito();
		this.formaPago=cliente.getFormaPago();
		this.cuentaCorriente=cliente.getCuentaCorriente();
		this.cuit=cliente.getCuit();
		this.nombre=cliente.getNombre();
		this.razonSocial=cliente.getRazonSocial();
		this.telefono=cliente.getTelefono();
		this.direccionEnvio=cliente.getDireccionEnvio();
		this.direccionFacturacion=cliente.getDireccionFacturacion();
		this.sucursal=new Sucursal(cliente.getSucursal(), this);
	}
	
	public Cliente(ClienteDto clienteDto) throws SucursalException {
		Sucursal sucursal = SucursalDao.getInstance().getSucursalById(clienteDto.getSucursal().getNumero());
		if (sucursal == null)
			throw new SucursalException("La sucursal indicada no existe");
		
		this.limiteCredito = clienteDto.getLimiteCredito();
		this.formaPago = clienteDto.getFormaPago();
		this.cuentaCorriente = clienteDto.getCuentaCorriente();
		this.cuit = clienteDto.getCuit();
		this.nombre = clienteDto.getNombre();
		this.razonSocial = clienteDto.getRazonSocial();
		this.telefono = clienteDto.getTelefono();
		this.direccionEnvio = clienteDto.getDireccionEnvio();
		this.direccionFacturacion = clienteDto.getDireccionFacturacion();
		this.sucursal = sucursal;
	}
	
	public Cliente(float limiteCredito,String formaPago,float cuentaCorriente,String cuit,String nombre, String razonSocial,
			String telefono, String direccionEnvio,String direccionFacturacion, Sucursal sucursal,
			ArrayList<PedidoPrendas> pedidosAceptados){
		
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

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	
	
	public boolean alcanzaCredito(float monto){
		if(this.cuentaCorriente - monto < -limiteCredito)
			return false;

		return true;
	}
	
	public ClienteDto toDto(){
		return new ClienteDto(limiteCredito, formaPago, cuentaCorriente, cuit, nombre, razonSocial, telefono, direccionEnvio,
				direccionFacturacion, this.sucursal.toDto(), this.legajo);
	}

	public void saveMe(){
		ClienteDao.getInstance().crearCliente(this);
	}
	
	public void modificame(){
		ClienteDao.getInstance().ModificarCliente(this);
	}
	
	public void eliminame(){
		ClienteDao.getInstance().EliminarCliente(this);
	}
}
