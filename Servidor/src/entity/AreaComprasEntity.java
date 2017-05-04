package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="AreaCompras")
public class AreaComprasEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToMany()
	@JoinColumn(name="areaCompras_id")
	private List<OrdenDeCompraEntity> ordenDeCompra;
}
