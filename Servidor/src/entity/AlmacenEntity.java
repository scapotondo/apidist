package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
	private int id;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="almacen_Id")
	private List<MovimientoPrendaEntity> movimientosPrendas;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="almacen_Id")
	private List<MovimientoMateriaPrimaEntity> movimientosMateriaPrima;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="almacen_Id")
	private List<StockPrendaEntity> stockPrendas;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="almacen_Id")
	private List<StockMateriaPrimaEntity> stockMateriaPrima;
}
