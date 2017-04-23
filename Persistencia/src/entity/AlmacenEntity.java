package entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="OrdenDeProduccion")
public class AlmacenEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
//	private ArrayList<MovimientoPrenda> movimientosPrendas;
//	private ArrayList<MovimientoMateriaPrima> movimientosMateriaPrima;
//	private ArrayList<StockPrendaEntity> stockPrendas;
//	private ArrayList<StockMateriaPrimaEntity> stockMateriaPrima;
}
