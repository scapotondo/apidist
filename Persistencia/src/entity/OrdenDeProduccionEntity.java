package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Embeddable
@Table(name="OrdenDeProduccion")
public class OrdenDeProduccionEntity implements Serializable{
	
	@OneToOne
	private PedidoPrendasEntity pedidoPrenda;

}
