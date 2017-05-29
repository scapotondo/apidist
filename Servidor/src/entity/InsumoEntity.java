package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import negocio.Insumo;

@Entity
@Table(name="Insumo")
public class InsumoEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int cantidad;
	private int desperdicio;
	
	@OneToOne()
	private MateriaPrimaEntity materiaPrima;
	
	public InsumoEntity(){}
	public InsumoEntity(Insumo insumo){
		this.cantidad = insumo.getCantidad();
		this.desperdicio = insumo.getDesperdicio();
		this.materiaPrima = new MateriaPrimaEntity(insumo.getMateriaPrima());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getDesperdicio() {
		return desperdicio;
	}

	public void setDesperdicio(int desperdicio) {
		this.desperdicio = desperdicio;
	}

	public MateriaPrimaEntity getMateriaPrima() {
		return materiaPrima;
	}

	public void setMateriaPrima(MateriaPrimaEntity materiaPrima) {
		this.materiaPrima = materiaPrima;
	}

	
}
