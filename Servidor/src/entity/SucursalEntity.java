package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Embeddable
@Table(name="Sucursal")
public class SucursalEntity implements Serializable{
	

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
