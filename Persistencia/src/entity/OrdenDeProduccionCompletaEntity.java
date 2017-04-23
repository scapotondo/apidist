package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OrdenDeProduccionCompleta")
public class OrdenDeProduccionCompletaEntity extends OrdenDeProduccionEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ordenCompleta_id; 
	
	public OrdenDeProduccionCompletaEntity(){}
}
