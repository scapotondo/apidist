package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	