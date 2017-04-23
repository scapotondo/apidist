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
	
	@ManyToOne(targetEntity=PedidoPrendasEntity.class)
	private List<PedidoPrendasEntity> pedidos;
	
//	private Empleado gerente;
//	private ArrayList<EmpleadoEntity> empleados;
	
	public SucursalEntity(int numero, String nombre, String direccion, ArrayList<String> horarios,/* Empleado gerente,*/
			/*ArrayList<EmpleadoEntity> empleados */ ArrayList<PedidoPrendasEntity> pedidos){
		this.numero = numero;
		this.nombre = nombre;
		this.direccion = direccion;
		this.horarios = horarios;
		this.pedidos = pedidos;
//		this.gerente = gerente;
//		this.empleados = empleados;
	}
}
