package entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="OrdenDeProduccion")
@DiscriminatorValue(value="parcial")
public class OrdenDeProduccionParcialEntity extends OrdenDeProduccionEntity {
	
	@ElementCollection
	private List<String> tallesValidos;
	
	@ElementCollection
	private List<String> coloresValidos;
	
	public OrdenDeProduccionParcialEntity(){}
}
	