package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import negocio.Despacho;
import negocio.PedidoPrendas;

@Entity
@Table(name="Despacho")
public class DespachoEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne()
	@JoinColumn(name="almacen_id")
	private AlmacenEntity almacen;
//	
//	@OneToMany()
//	@JoinColumn(name="despacho_id")
//	private List<PedidoPrendasEntity> pedidosPrenda;
//	
	public DespachoEntity(){}
//	public DespachoEntity(Despacho despacho){
//		//TODO
//		//this.almacen = new AlmacenEntity(despacho.getAlmacen());
//		this.id = despacho.getId();
//		this.pedidosPrenda = new ArrayList<PedidoPrendasEntity>();
//		if(despacho.getPedidosPrenda() != null){
//			for (PedidoPrendas pedidoPrendas : despacho.getPedidosPrenda()) {
//				this.pedidosPrenda.add(new PedidoPrendasEntity(pedidoPrendas));
//			}
//		}
//	}

}
