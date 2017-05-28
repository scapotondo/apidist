package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import negocio.AreaCompras;
import negocio.OrdenDeCompra;

@Entity
@Table(name="AreaCompras")
public class AreaComprasEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToMany()
	@JoinColumn(name="areaCompras_id")
	private List<OrdenDeCompraEntity> ordenesDeCompra;
	
	public AreaComprasEntity(){}
	
	public AreaComprasEntity(AreaCompras areaCompras){
		this.id = areaCompras.getId();
		this.ordenesDeCompra = new ArrayList<OrdenDeCompraEntity>();
		if(areaCompras.getOrdenesCompras() != null){
			for (OrdenDeCompra ordenDeCompra : areaCompras.getOrdenesCompras()) {
				this.ordenesDeCompra.add(new OrdenDeCompraEntity(ordenDeCompra));
			}
		}
	}
}
