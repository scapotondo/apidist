package controller;

import java.util.ArrayList;

import dao.AreaProduccionDao;
import dao.ConfeccionDao;
import dao.OrdenDeProduccionDao;
import dto.AreaProduccionDto;
import dto.ConfeccionDto;
import dto.OrdenDeProduccionDto;
import exceptions.ApplicationException;
import exceptions.AreaProduccionException;
import exceptions.RemoteObjectNotFoundException;
import negocio.AreaProduccion;
import negocio.Confeccion;
import negocio.EstadoConfeccion;
import negocio.Insumo;
import negocio.OrdenDeProduccion;

public class AreaProduccionController {

	private static AreaProduccionController instance;

	public static AreaProduccionController getInstance() {
		if (instance == null)
			instance = new AreaProduccionController();

		return instance;
	}

	public ArrayList<OrdenDeProduccionDto> getOrdenesProduccion(AreaProduccionDto areaProduccion) {
		ArrayList<OrdenDeProduccionDto> ordenesDto = new ArrayList<OrdenDeProduccionDto>();

		ArrayList<OrdenDeProduccion> ordenesIncompletas = OrdenDeProduccionDao.getInstance().getOrdenesIncompletas();

		for (OrdenDeProduccion ordenIncompleta : ordenesIncompletas) {

			for (Confeccion confeccion : ordenIncompleta.getPrenda().getConfecciones()) {
				if (confeccion.getEstado() == EstadoConfeccion.INCOMPLETO) {
					if (confeccion.getAreaProduccion().getCodigo() == areaProduccion.getCodigo())
						ordenesDto.add(ordenIncompleta.toDto());
					break;
				}
			}
		}

		return ordenesDto;
	}

	public void IniciarProduccion(OrdenDeProduccionDto ordenDto, AreaProduccionDto areaDto , ConfeccionDto confeccionDto)
			throws RemoteObjectNotFoundException, AreaProduccionException, ApplicationException {
		AreaProduccion area = AreaProduccionDao.getInstance().getById(areaDto);
		OrdenDeProduccion orden = OrdenDeProduccionDao.getInstance().getBuscarOrden(ordenDto);
		Confeccion confeccion = ConfeccionDao.getInstance().buscarConfeccion(confeccionDto);
		
		if (area.hayLineasLibres()) {
			
			// disminuyo materia prima para la confeccion en el almacen
			for (Insumo insumo : confeccion.getInsumos()) {

				AlmacenController.getInstance().disminuirStockMateriaPrima(insumo.getMateriaPrima(),
						insumo.getCantidad(), orden);
			}

			area.asignarLineaProduccion(confeccion);

			orden.terminarConfeccion(confeccion);

		} else {
			String mensaje = "En este momento no hay lineas de produccion disponibles, por favor intente en otro momento";
			throw new AreaProduccionException(mensaje);
		}

	}
	
	
	

}
