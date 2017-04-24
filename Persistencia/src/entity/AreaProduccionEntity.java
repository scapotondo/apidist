package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="AreaProduccion")
public class AreaProduccionEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;
	
	private String nombre;
	
	@OneToMany()
	@JoinColumn(name="areaProduccion_id")
	private List<LineaProduccionEntity> lineasProduccion;
	
	@OneToMany()
	@JoinColumn(name="areaProduccion_id")
	private List<OrdenDeProduccionEntity> ordenesProduccion;
	
	public AreaProduccionEntity(){}
}
