package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="AreaProduccion")
public class AreaProduccionEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;
	
	@ManyToOne(targetEntity=ConfeccionEntity.class)
	private ConfeccionEntity confeccion;
	
	private String nombre;
	
	@OneToMany(mappedBy="areaProduccion")
	private List<LineaProduccionEntity> lineasProduccion;
	
	@OneToMany(mappedBy="areaProduccion")
	private List<OrdenDeProduccionEntity> ordenesProduccion;
	
	public AreaProduccionEntity(){}
}
