package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import negocio.Empleado;
import negocio.Sucursal;

@Entity
@Table(name="Sucursal")
public class SucursalEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int numero;
	
	@Column(nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private String direccion;
	
	@ElementCollection
	private List<String> horarios;
	
	@OneToMany(mappedBy="sucursal",cascade = CascadeType.ALL)
	private List<ClienteEntity> cliente;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="sucursal_id")
	private List<EmpleadoEntity> empleados;
	
	public SucursalEntity(){
	}
	public SucursalEntity(int numero, String nombre, String direccion, List<String> horarios,
			List<EmpleadoEntity> empleados, List<PedidoPrendasEntity> pedidos){
		this.numero = numero;
		this.nombre = nombre;
		this.direccion = direccion;
		this.horarios = horarios;
		this.empleados = empleados;
	}
	
	SucursalEntity(Sucursal sucursal, boolean crearPedidos) {
		this.numero = sucursal.getNumero();
		this.nombre = sucursal.getNombre();
		this.direccion = sucursal.getDireccion();
		this.horarios = sucursal.getHorarios();
		this.empleados=new ArrayList<EmpleadoEntity>();
		
		if(sucursal.getEmpleados()!=null)
			for (Empleado empleado : sucursal.getEmpleados()) 
				this.empleados.add(new EmpleadoEntity(empleado));
	}

	public SucursalEntity(Sucursal sucursal) {
		this(sucursal, true);
	}
	
	public SucursalEntity(Sucursal sucursal, ClienteEntity clienteEntity) {
		this(sucursal, false);
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
	public List<String> getHorarios() {
		return horarios;
	}
	public void setHorarios(List<String> horarios) {
		this.horarios = horarios;
	}
	public List<ClienteEntity> getCliente() {
		return cliente;
	}
	public void setCliente(List<ClienteEntity> cliente) {
		this.cliente = cliente;
	}
	public List<EmpleadoEntity> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(List<EmpleadoEntity> empleados) {
		this.empleados = empleados;
	}
}
