package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Confeccion")
public class ConfeccionEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private int tiempoProd;
	private String detalle;
	
	@OneToMany()
	@JoinColumn(name="confeccion_id")
	private List<AreaProduccionEntity> areaProduccion;
	
	@OneToMany()
	@JoinColumn(name="confeccion_id")
	private List<InsumoEntity> insumos;
	
	public ConfeccionEntity(){}
}
