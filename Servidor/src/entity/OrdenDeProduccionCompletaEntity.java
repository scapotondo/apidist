package entity;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity 
@Table(name="OrdenDeProduccion")
@DiscriminatorValue(value="completa")
public class OrdenDeProduccionCompletaEntity extends OrdenDeProduccionEntity {
	public OrdenDeProduccionCompletaEntity(){}
}
