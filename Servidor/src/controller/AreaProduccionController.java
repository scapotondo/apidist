package controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dao.AreaProduccionDao;
import dao.ConfeccionDao;
import dao.OrdenDeProduccionDao;
import dto.AreaProduccionDto;
import dto.ConfeccionDto;
import dto.OrdenDeProduccionDto;
import exceptions.ApplicationException;
import exceptions.AreaProduccionException;
import exceptions.ColorException;
import exceptions.RemoteObjectNotFoundException;
import negocio.AreaProduccion;
import negocio.ColorPrenda;
import negocio.Confeccion;
import negocio.EstadoConfeccion;
import negocio.EstadoOrdenProduccion;
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
			throws RemoteObjectNotFoundException, AreaProduccionException, ApplicationException, ColorException {
		
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
			
			if(!faltaTerminar(orden)){
				orden.setEstado(EstadoOrdenProduccion.TERMINADA);
				orden.modificame();
				

				if(orden.getClass().getName().equals("negocio.OrdenProduccionCompleta")){
					for (String talle : orden.getPrenda().getTallesValidos()) {
						for (ColorPrenda color : orden.getPrenda().getColoresValidos()) {
							AlmacenController.getInstance().agregarStockPrenda(orden.getPrenda(), orden.getPrenda().getCantidadAProducir(),
									talle, color.toString(), orden);
						}
					}
					
				}else{
					for (String talle : orden.getTalles()) {
						for (String color : orden.getColores()) {
							AlmacenController.getInstance().agregarStockPrenda(orden.getPrenda(), orden.getCantidad(),talle, color, orden);
						}
					}
				}
					
			}

		} else {
			String mensaje = "En este momento no hay lineas de produccion disponibles, por favor intente en otro momento";
			throw new AreaProduccionException(mensaje);
		}

	}
	
	public ConfeccionDto buscarConfeccionParaOrden(ConfeccionDto confeccionDto) throws RemoteException, ApplicationException {
		return ConfeccionDao.getInstance().buscarConfeccion(confeccionDto).toDto();
	}

	public OrdenDeProduccionDto buscarOrdenProduccion(OrdenDeProduccionDto ordenDto) throws RemoteException, RemoteObjectNotFoundException {
		return OrdenDeProduccionDao.getInstance().getBuscarOrden(ordenDto).toDto();
	}
	
	private boolean faltaTerminar(OrdenDeProduccion orden){
		boolean flag = false;
		
		for (Confeccion confeccion : orden.getPrenda().getConfecciones()) {
			if(confeccion.getEstado().equals(EstadoConfeccion.INCOMPLETO))
				flag = true;
		}
		
		return flag;
	}
	
}
