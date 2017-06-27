package entity;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import negocio.OrdenProduccionCompleta;

@Entity 
@Table(name="OrdenDeProduccion")
@DiscriminatorValue(value="completa")
public class OrdenDeProduccionCompletaEntity extends OrdenDeProduccionEntity {
	private static final long serialVersionUID = 1L;
	
	public OrdenDeProduccionCompletaEntity(){}
	
	public OrdenDeProduccionCompletaEntity(OrdenProduccionCompleta orden){
		super(orden);
	}
	
}
