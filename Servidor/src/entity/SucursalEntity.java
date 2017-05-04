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
}
