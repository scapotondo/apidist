package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="OrdenDeCompra")
public class OrdenDeCompraEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne()
	private MateriaPrimaEntity materiaPrima;
	
	private Date fechaGeneracion;
	private Date fechaProbableDespacho;
	private Date fechaRealDespacho;
	private int cantidad;
	private float precioUnitario;
	
	@ManyToOne(targetEntity=AreaComprasEntity.class)
	private AreaComprasEntity areaCompras;
	
	@OneToOne()
	@JoinColumn(name="nroOrden")
	private OrdenDeProduccionEntity ordenProduccion;
	
	@OneToOne()
	@JoinColumn(name="id")
	private ProveedorEntity proveedor;

}
