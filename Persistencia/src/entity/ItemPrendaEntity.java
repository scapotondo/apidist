package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Embeddable
@Table(name="ItemPrenda")
public class ItemPrendaEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int nroPedido;
	
	@ManyToOne(targetEntity=PedidoPrendasEntity.class)
	@Embedded
	private PedidoPrendasEntity pedidoPrenda;
	
}
