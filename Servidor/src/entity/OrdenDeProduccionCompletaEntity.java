package entity;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import negocio.OrdenDeProduccion;

@Entity 
@DiscriminatorValue(value="completa")
public class OrdenDeProduccionCompletaEntity extends OrdenDeProduccionEntity {
	private static final long serialVersionUID = 1L;
	
	public OrdenDeProduccionCompletaEntity(){}
	
	public OrdenDeProduccionCompletaEntity(OrdenDeProduccion orden){
		super(orden);
	}
	
}
