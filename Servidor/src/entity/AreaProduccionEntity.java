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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<LineaProduccionEntity> getLineasProduccion() {
		return lineasProduccion;
	}

	public void setLineasProduccion(List<LineaProduccionEntity> lineasProduccion) {
		this.lineasProduccion = lineasProduccion;
	}

	public List<OrdenDeProduccionEntity> getOrdenesProduccion() {
		return ordenesProduccion;
	}

	public void setOrdenesProduccion(List<OrdenDeProduccionEntity> ordenesProduccion) {
		this.ordenesProduccion = ordenesProduccion;
	}
	
	
}
