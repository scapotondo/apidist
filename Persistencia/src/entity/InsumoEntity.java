package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Insumo")
public class InsumoEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;
	
	@ManyToOne(targetEntity=ConfeccionEntity.class)
	private ConfeccionEntity confeccion;
	
	private int cantidad;
	private int desperdicio;
	
	@OneToOne()
	@JoinColumn(name="codigo")
	private MateriaPrimaEntity materiaPrima;

}
