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
	private int id;
	
	@OneToMany()
	@JoinColumn(name="almacen_Id")
	private List<MovimientoPrendaEntity> movimientosPrendas;
	
	@OneToMany()
	@JoinColumn(name="almacen_Id")
	private List<MovimientoMateriaPrimaEntity> movimientosMateriaPrima;
	
	@OneToMany()
	@JoinColumn(name="almacen_Id")
	private List<StockPrendaEntity> stockPrendas;
	
	@OneToMany()
	@JoinColumn(name="almacen_Id")
	private List<StockMateriaPrimaEntity> stockMateriaPrima;
}
