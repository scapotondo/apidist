package controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dao.AreaProduccionDao;
import dao.OrdenDeProduccionDao;
import dto.AreaProduccionDto;
import dto.OrdenDeProduccionDto;
import exceptions.ApplicationException;
import exceptions.AreaProduccionException;
import exceptions.ColorException;
import exceptions.RemoteObjectNotFoundException;
import negocio.AreaProduccion;
import negocio.EstadoOrdenProduccion;
import negocio.EstadoProcesoProduccion;
import negocio.Insumo;
import negocio.OrdenDeProduccion;
import negocio.ProcesoProduccion;

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
			ProcesoProduccion proc = buscarProcesoIncompletoMenorOrden(ordenIncompleta.getProcesos());
			if (proc != null && proc.getConfeccion().getAreaProduccion().getCodigo() == areaProduccion.getCodigo())
				ordenesDto.add(ordenIncompleta.toDto());
		}

		return ordenesDto;
	}

	public void IniciarProduccion(OrdenDeProduccionDto ordenDto, AreaProduccionDto areaDto)
			throws RemoteObjectNotFoundException, AreaProduccionException, ApplicationException, ColorException {

		AreaProduccion area = AreaProduccionDao.getInstance().getById(areaDto);
		OrdenDeProduccion orden = OrdenDeProduccionDao.getInstance().getBuscarOrden(ordenDto); 
		
		ProcesoProduccion primerProceso = buscarProcesoIncompletoMenorOrden(orden.getProcesos());

		if (area.hayLineasLibres()) {
			if (primerProceso != null) {
				// disminuyo materia prima para la confeccion en el almacen
				for (Insumo insumo : primerProceso.getConfeccion().getInsumos()) {
					AlmacenController.getInstance().disminuirStockMateriaPrima(insumo.getMateriaPrima(),
							insumo.getCantidad(), orden);
				}

				area.asignarLineaProduccion(primerProceso);
				
				primerProceso.setEstado(EstadoProcesoProduccion.PRODUCCION);
				primerProceso.modificar();
				
				if (orden.getEstado().equals(EstadoOrdenProduccion.PENDIENTE)) {
					orden.setEstado(EstadoOrdenProduccion.PRODUCCION);
					orden.modificame();
				}
			}
		} else {
			String mensaje = "En este momento no hay lineas de produccion disponibles, por favor intente en otro momento";
			throw new AreaProduccionException(mensaje);
		}
	}

	private ProcesoProduccion buscarProcesoIncompletoMenorOrden(ArrayList<ProcesoProduccion> procesos) {
		int menor = 100;
		ProcesoProduccion primerProceso = null;
		for (ProcesoProduccion p : procesos) {
			if (p.getNroOrden() < menor && p.getEstado() == EstadoProcesoProduccion.INCOMPLETO) {
				menor = p.getNroOrden();
				primerProceso = p;
			}
		}

		return primerProceso;
	}

	public OrdenDeProduccionDto buscarOrdenProduccion(OrdenDeProduccionDto ordenDto) throws RemoteException, RemoteObjectNotFoundException {
		return OrdenDeProduccionDao.getInstance().getBuscarOrden(ordenDto).toDto();
	}
}
