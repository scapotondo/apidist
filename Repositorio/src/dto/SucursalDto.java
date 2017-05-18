package dto;

import java.io.Serializable;
import java.util.ArrayList;


public class SucursalDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int numero;
	private String nombre;
	private String direccion;
	private ArrayList<String> horarios;
	private EmpleadoDto gerente;
	private ArrayList<EmpleadoDto> empleados;
	private ArrayList<PedidoPrendasDto> pedidos;
	
	public SucursalDto(){}
	
	public SucursalDto(int numero, String nombre, String direccion, ArrayList<String> horarios,
			ArrayList<EmpleadoDto> empleados,ArrayList<PedidoPrendasDto> pedidos){
		this.numero = numero;
		this.nombre = nombre;
		this.direccion = direccion;
		this.horarios = horarios;
		//TODO:asignar gerente en base al actor rol
		//this.gerente = gerente;
		if(pedidos!=null)
			this.pedidos = pedidos;
		else
			this.pedidos= new ArrayList<PedidoPrendasDto>();
		
		if(empleados !=null)
			this.empleados = empleados;
		else
			this.empleados= new ArrayList<EmpleadoDto>();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ArrayList<String> getHorarios() {
		return horarios;
	}

	public void setHorarios(ArrayList<String> horarios) {
		this.horarios = horarios;
	}

	public EmpleadoDto getGerente() {
		return gerente;
	}

	public void setGerente(EmpleadoDto gerente) {
		this.gerente = gerente;
	}

	public ArrayList<EmpleadoDto> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<EmpleadoDto> empleados) {
		this.empleados = empleados;
	}

	public ArrayList<PedidoPrendasDto> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<PedidoPrendasDto> pedidos) {
		this.pedidos = pedidos;
	}
	
}
