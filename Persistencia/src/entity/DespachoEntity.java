package entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Despacho")
public class DespachoEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int despacho_id;
	
	@OneToOne()
	@JoinColumn(name="almacen_id")
	private AlmacenEntity almacen;
	
	@OneToMany()
	@JoinColumn(name="nroPedido")
	private ArrayList<PedidoPrendasEntity> pedidosPrenda;
	
	@OneToOne()
	@JoinColumn(name="id")
	private AdministracionEntity administracion;
	
	public DespachoEntity(){}

}
