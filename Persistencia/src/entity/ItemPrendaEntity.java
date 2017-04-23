package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Embeddable
@Table(name="ItemPrenda")
public class ItemPrendaEntity implements Serializable{
	
	@ManyToOne(targetEntity=PedidoPrendasEntity.class)
	@Embedded
	private PedidoPrendasEntity pedidoPrenda;
	
}
