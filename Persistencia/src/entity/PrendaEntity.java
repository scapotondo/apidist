package entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Embeddable
@Table(name="Prenda")
public class PrendaEntity implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int nroPedido;
	
	@ManyToOne(targetEntity=OrdenDeProduccionEntity.class)
	private OrdenDeProduccionEntity ordenDeProduccion;
}
