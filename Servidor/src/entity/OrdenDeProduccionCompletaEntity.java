package entity;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import negocio.OrdenProduccionCompleta;

@Entity 
@Table(name="OrdenDeProduccion")
@DiscriminatorValue(value="completa")
public class OrdenDeProduccionCompletaEntity extends OrdenDeProduccionEntity {
	public OrdenDeProduccionCompletaEntity(){}
	
	public OrdenDeProduccionCompletaEntity(OrdenProduccionCompleta orden){
		super(orden);
	}
	
}
