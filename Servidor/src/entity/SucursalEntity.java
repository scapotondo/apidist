package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
import negocio.PedidoPrendas;
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
	
	@OneToMany(mappedBy="sucursal")
	private List<ClienteEntity> cliente;
	
	@OneToMany()
	@JoinColumn(name="sucursal_id")
	private List<PedidoPrendasEntity> pedidos;
	
	@OneToMany()
	@JoinColumn(name="sucursal_id")
	private List<EmpleadoEntity> empleados;
	
	public SucursalEntity(){}
	public SucursalEntity(int numero, String nombre, String direccion, List<String> horarios,
			List<EmpleadoEntity> empleados, List<PedidoPrendasEntity> pedidos){
		this.numero = numero;
		this.nombre = nombre;
		this.direccion = direccion;
		this.horarios = horarios;
		this.pedidos = pedidos;
		this.empleados = empleados;
	}
	
	public SucursalEntity(Sucursal sucursal) {
		this.numero = sucursal.getNumero();
		this.nombre = sucursal.getNombre();
		this.direccion = sucursal.getDireccion();
		this.horarios = sucursal.getHorarios();
		this.pedidos= new ArrayList<PedidoPrendasEntity>();
		if(sucursal.getPedidos()!= null){
			for (PedidoPrendas pedido : sucursal.getPedidos()) {
				this.pedidos.add(new PedidoPrendasEntity(pedido));
			}	
		}
		this.empleados=new ArrayList<EmpleadoEntity>();
		if(sucursal.getEmpleados()!=null){
			for (Empleado empleado : sucursal.getEmpleados()) {
				this.empleados.add(new EmpleadoEntity(empleado));
			}
		}
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
	public List<PedidoPrendasEntity> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<PedidoPrendasEntity> pedidos) {
		this.pedidos = pedidos;
	}
	public List<EmpleadoEntity> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(List<EmpleadoEntity> empleados) {
		this.empleados = empleados;
	}
}
