package negocio;

import java.util.ArrayList;

import dto.EmpleadoDto;
import dto.PedidoPrendasDto;
import dto.SucursalDto;

public class Sucursal {
	
	private int numero;
	private String nombre;
	private String direccion;
	private ArrayList<String> horarios;
	private Empleado gerente;
	private ArrayList<Empleado> empleados;
	private ArrayList<PedidoPrendas> pedidos;
	
	public Sucursal(int numero, String nombre, String direccion, ArrayList<String> horarios, Empleado gerente,
			ArrayList<Empleado> empleados,ArrayList<PedidoPrendas> pedidos){
		this.numero = numero;
		this.nombre = nombre;
		this.direccion = direccion;
		this.horarios = horarios;
		this.gerente = gerente;
		this.empleados = empleados;
		this.pedidos = pedidos;
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

	public Empleado getGerente() {
		return gerente;
	}

	public void setGerente(Empleado gerente) {
		this.gerente = gerente;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}

	public ArrayList<PedidoPrendas> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<PedidoPrendas> pedidos) {
		this.pedidos = pedidos;
	}

	public void aceptarPedido(PedidoPrendas pedido){
		
	}
	
	public void addNuevoPedido(PedidoPrendas pedido){
		pedidos.add(pedido);
	}
	
	public void rechazarPedido(PedidoPrendas pedido, String descripcion){
		
	}
	
	
	public SucursalDto toDto(){
		ArrayList<EmpleadoDto> empleadosDto = new ArrayList<EmpleadoDto>();
		ArrayList<PedidoPrendasDto> pedidosDto = new ArrayList<PedidoPrendasDto>();
		for (PedidoPrendas pedidoPrendas : pedidos) {
			pedidosDto.add(pedidoPrendas.toDto());
		}
		for (Empleado empleado : empleados) {
			empleadosDto.add(empleado.toDto());
		}
		
		return new SucursalDto(numero, nombre, direccion, horarios, gerente.toDto(), empleadosDto, pedidosDto);
	}
}
