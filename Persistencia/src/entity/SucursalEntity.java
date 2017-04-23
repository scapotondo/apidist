package entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import negocio.Empleado;
import negocio.PedidoPrendas;

@Entity
@Table(name="Sucursal")
public class SucursalEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int numero;
	
	@Column(nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private String direccion;
	
	
	private ArrayList<String> horarios;
	
	
//	private Empleado gerente;
//	private ArrayList<EmpleadoEntity> empleados;
	private ArrayList<PedidoPrendasEntity> pedidos;
	
	public SucursalEntity(int numero, String nombre, String direccion, ArrayList<String> horarios, Empleado gerente,
			/*ArrayList<EmpleadoEntity> empleados */ ArrayList<PedidoPrendasEntity> pedidos){
		this.numero = numero;
		this.nombre = nombre;
		this.direccion = direccion;
		this.horarios = horarios;
		this.gerente = gerente;
//		this.empleados = empleados;
		this.pedidos = pedidos;
	}
}
