package negocio;

import java.util.ArrayList;

import dao.SucursalDao;
import dto.EmpleadoDto;
import dto.SucursalDto;
import entity.EmpleadoEntity;
import entity.SucursalEntity;

public class Sucursal {
	
	private int numero;
	private String nombre;
	private String direccion;
	private ArrayList<String> horarios;
	private Empleado gerente;
	private ArrayList<Empleado> empleados;
	
	Sucursal(SucursalEntity sucursal, boolean crearPedidos){
		this.numero = sucursal.getNumero();
		this.nombre = sucursal.getNombre();
		this.direccion = sucursal.getDireccion();
		this.horarios = new ArrayList<>();
		this.empleados = new ArrayList<>();
		
		for (EmpleadoEntity empleado : sucursal.getEmpleados()) {
			Empleado emp = new Empleado(empleado);
			
			if (emp.getRol() == Rol.Gerente)
				this.gerente = emp;
			
			empleados.add(emp);
		}
		
		for (String horario : sucursal.getHorarios())
			horarios.add(horario);
	}
	
	public Sucursal(SucursalEntity sucursal){
		this(sucursal, true);
	}
	
	public Sucursal(SucursalEntity sucursal, Cliente cliente){
		this(sucursal, false);
	}
	
	public Sucursal(int numero, String nombre, String direccion, ArrayList<String> horarios, Empleado gerente,
			ArrayList<Empleado> empleados,ArrayList<PedidoPrendas> pedidos){
		this.numero = numero;
		this.nombre = nombre;
		this.direccion = direccion;
		this.horarios = horarios;
		this.gerente = gerente;
		this.empleados = empleados;
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

	public void aceptarPedido(PedidoPrendas pedido){
		
	}
	
	public void rechazarPedido(PedidoPrendas pedido, String descripcion){
		
	}
	
	public SucursalDto toDto(){
		ArrayList<EmpleadoDto> empleadosDto = new ArrayList<EmpleadoDto>();
		
		if(this.empleados!= null)
			for (Empleado empleado : this.empleados) 
				empleadosDto.add(empleado.toDto());
		
		return new SucursalDto(numero, nombre, direccion, horarios, empleadosDto, gerente.toDto());
	}
	
	public void modificame() {
		SucursalDao.getInstance().modificarSucursal(this);
	}
}
