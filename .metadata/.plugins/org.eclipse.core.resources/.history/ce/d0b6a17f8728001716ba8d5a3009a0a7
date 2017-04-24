package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Almacen")
public class AlmacenEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int almacen_id;
	
	@OneToMany()
	@JoinColumn(name="mp_id")
	private List<MovimientoPrendaEntity> movimientosPrendas;
	
	@OneToMany()
	@JoinColumn(name="mmp_id")
	private List<MovimientoMateriaPrimaEntity> movimientosMateriaPrima;
	
	@OneToMany()
	@JoinColumn(name="codigo")
	private List<StockPrendaEntity> stockPrendas;
	
	@OneToMany()
	@JoinColumn(name="id")
	@Column(name="stockMateriaPrima")
	private List<StockMateriaPrimaEntity> stockMateriaPrima;
}
