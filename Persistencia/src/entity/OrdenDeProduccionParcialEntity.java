package entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OrdenDeProduccionParcial")
public class OrdenDeProduccionParcialEntity extends OrdenDeProduccionEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ordenParcial_id;
	
	@ElementCollection
	private List<String> tallesValidos;
	
	@ElementCollection
	private List<String> coloresValidos;
}
