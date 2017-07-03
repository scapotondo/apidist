package negocio;

import java.util.ArrayList;

import dto.AreaProduccionDto;
import dto.LineaProduccionDto;
import dto.OrdenDeProduccionDto;
import entity.AreaProduccionEntity;
import entity.LineaProduccionEntity;
import entity.OrdenDeProduccionCompletaEntity;
import entity.OrdenDeProduccionEntity;
import entity.OrdenDeProduccionParcialEntity;

public class AreaProduccion {

	private String nombre;
	private ArrayList<LineaProduccion> lineasProduccion;
	private ArrayList<OrdenDeProduccion> ordenesProduccion;
	private int codigo;

	public AreaProduccion(AreaProduccionEntity area) {
		this.codigo = area.getCodigo();
		this.nombre = area.getNombre();
		this.lineasProduccion = new ArrayList<>();
		for (LineaProduccionEntity lineaProduccionEntity : area.getLineasProduccion()) {
			this.lineasProduccion.add(new LineaProduccion(lineaProduccionEntity));
		}
		this.ordenesProduccion = new ArrayList<>();

		OrdenDeProduccion orden = null;

		for (OrdenDeProduccionEntity OrdenDeProduccionEntity : area.getOrdenesProduccion()) {
			if (OrdenDeProduccionEntity != null) {
				if (OrdenDeProduccionEntity.getClass().getName().equals("entity.OrdenDeProduccionCompletaEntity"))
					orden = new OrdenProduccionCompleta((OrdenDeProduccionCompletaEntity) OrdenDeProduccionEntity);

				if (OrdenDeProduccionEntity.getClass().getName().equals("entity.OrdenDeProduccionParcialEntity"))
					orden = new OrdenProduccionParcial((OrdenDeProduccionParcialEntity) OrdenDeProduccionEntity);

				this.ordenesProduccion.add(orden);
			}
		}
	}

	public AreaProduccion(String nombre, ArrayList<LineaProduccion> lineasProduccion,
			ArrayList<OrdenDeProduccion> ordenesProduccion) {
		this.nombre = nombre;
		this.lineasProduccion = lineasProduccion;
		this.ordenesProduccion = ordenesProduccion;
	}

	public AreaProduccion(int codigo, String nombre, ArrayList<LineaProduccion> lineasProduccion,
			ArrayList<OrdenDeProduccion> ordenesProduccion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.lineasProduccion = lineasProduccion;
		this.ordenesProduccion = ordenesProduccion;
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

	public ArrayList<LineaProduccion> getLineasProduccion() {
		return lineasProduccion;
	}

	public void setLineasProduccion(ArrayList<LineaProduccion> lineasProduccion) {
		this.lineasProduccion = lineasProduccion;
	}

	public ArrayList<OrdenDeProduccion> getOrdenesProduccion() {
		return ordenesProduccion;
	}

	public void setOrdenesProduccion(ArrayList<OrdenDeProduccion> ordenesProduccion) {
		this.ordenesProduccion = ordenesProduccion;
	}

	public void asignarLineaProduccion(ProcesoProduccion proceso, OrdenDeProduccion orden) {
		if (hayLineasLibres()) {
			LineaProduccion linea = new LineaProduccion();
			for (LineaProduccion lineaProduccion : lineasProduccion) {
				if (lineaProduccion.getEstado().equals(LineaProduccion.LIBRE)) {
					linea = lineaProduccion;
					break;
				}
			}

			linea.asignarTrabajo(proceso.getConfeccion().getDetalle(), proceso.getConfeccion().getTiempoProd() , orden.getNroOrden());
		}
	}

	public boolean hayLineasLibres() {
		for (LineaProduccion lineaProduccion : this.lineasProduccion) {
			if (lineaProduccion.getEstado().equals(LineaProduccion.LIBRE))
				return true;
		}

		return false;
	}

	public void liberarLineaProduccion(int nroLinea) {
		for (LineaProduccion lineaProduccion : this.lineasProduccion) {
			if (lineaProduccion.getNumero() == nroLinea)
				lineaProduccion.Liberar();
		}
	}

	public AreaProduccionDto toDto() {
		ArrayList<LineaProduccionDto> lineasProduccionDto = new ArrayList<>();
		ArrayList<OrdenDeProduccionDto> ordenesProduccionDto = new ArrayList<>();

		for (LineaProduccion lineaDeProduccion : lineasProduccion) {
			lineasProduccionDto.add(lineaDeProduccion.toDto());
		}
		for (OrdenDeProduccion ordenDeProduccion : ordenesProduccion) {
			ordenesProduccionDto.add(ordenDeProduccion.toDto());
		}
		return new AreaProduccionDto(this.codigo, nombre, lineasProduccionDto, ordenesProduccionDto);
	}
}
