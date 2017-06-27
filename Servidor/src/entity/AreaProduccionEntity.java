package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import negocio.AreaProduccion;
import negocio.LineaProduccion;
import negocio.OrdenDeProduccion;
import negocio.OrdenProduccionCompleta;
import negocio.OrdenProduccionParcial;

@Entity
@Table(name="AreaProduccion")
public class AreaProduccionEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;
	
	private String nombre;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="areaProduccion_id")
	private List<LineaProduccionEntity> lineasProduccion;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="areaProduccion_id")
	private List<OrdenDeProduccionEntity> ordenesProduccion;

	public AreaProduccionEntity(){}
	
	public AreaProduccionEntity(AreaProduccion areaProduccion){
		this.codigo = areaProduccion.getCodigo();
		this.nombre = areaProduccion.getNombre();
		
		this.lineasProduccion = new ArrayList<LineaProduccionEntity>();
		if(areaProduccion.getLineasProduccion() != null){
			for (LineaProduccion lineaProduccion : areaProduccion.getLineasProduccion()) {
				this.lineasProduccion.add(new LineaProduccionEntity(lineaProduccion));
			}
		}
		this.ordenesProduccion = new ArrayList<OrdenDeProduccionEntity>();
		for (OrdenDeProduccion orden : areaProduccion.getOrdenesProduccion()) {
			
			if(orden.getClass().getName().equals("negocio.OrdenProduccionCompleta"))
				this.ordenesProduccion.add(new OrdenDeProduccionCompletaEntity( (OrdenProduccionCompleta) orden));
			
			if(orden.getClass().getName().equals("negocio.OrdenProduccionParcial"))
				this.ordenesProduccion.add(new OrdenDeProduccionParcialEntity((OrdenProduccionParcial) orden));
		}
	}

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
