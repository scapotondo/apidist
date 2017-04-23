package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Cliente")
@Embeddable
public class ClienteEntity implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int legajo;
	
	@Column(nullable=false)
	private float limiteCredito;
	
	@Column(nullable=false)
	private String formaPago;
	private float cuentaCorriente;
	
	@Column(nullable=false)
	private String cuit;
	
	@Column(nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private String razonSocial;
	private String telefono;
	private String direccionEnvio;
	
	@Column(nullable=false)
	private String direccionFacturacion;
	
	@OneToMany(mappedBy = "cliente")
	private List<PedidoPrendasEntity> pedidosAceptados;
	
	@ManyToOne(targetEntity=SucursalEntity.class)
	@Embedded
	private SucursalEntity sucursal;
	
	@ManyToOne(targetEntity=AdministracionEntity.class)
	private AdministracionEntity administracion;
	
	public ClienteEntity(){}
	public ClienteEntity(float limiteCredito,String formaPago, float cuentaCorriente, String cuit, String nombre, String razonSocial,
						String telefono, String direccionEnvio,String direccionFacturacion, int legajo,
						ArrayList<PedidoPrendasEntity> pedidosAceptados, SucursalEntity sucursal ){
		
		this.limiteCredito=limiteCredito;
		this.formaPago=formaPago;
		this.cuentaCorriente=cuentaCorriente;
		this.cuit=cuit;
		this.nombre=nombre;
		this.razonSocial=razonSocial;
		this.telefono=telefono;
		this.direccionEnvio=direccionEnvio;
		this.direccionFacturacion=direccionFacturacion;
		this.legajo=legajo;
		this.sucursal=sucursal;
		this.pedidosAceptados= pedidosAceptados;
	}
}
