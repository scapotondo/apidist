package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MovimientoMateriaPrima")
public class MovimientoMateriaPrimaEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int mmp_id;
	
	private String estado;
	private int cantidad;
	private Date fecha;
	
	@ManyToOne()
	@JoinColumn(name="codigo")
	private MateriaPrimaEntity materiaPrima;
	
	public MovimientoMateriaPrimaEntity(){}
}
