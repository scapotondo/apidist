package controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dao.AreaProduccionDao;
import dao.OrdenDeProduccionDao;
import dto.AreaProduccionDto;
import dto.LineaProduccionDto;
import dto.OrdenDeProduccionDto;
import exceptions.ApplicationException;
import exceptions.AreaProduccionException;
import exceptions.ColorException;
import exceptions.RemoteObjectNotFoundException;
import negocio.AreaProduccion;
import negocio.EstadoOrdenProduccion;
import negocio.EstadoPedidoPrenda;
import negocio.EstadoProcesoProduccion;
import negocio.Insumo;
import negocio.LineaProduccion;
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

				area.asignarLineaProduccion(primerProceso, orden);
				
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

	public AreaProduccionDto getAreaProduccion(AreaProduccionDto area){
		return AreaProduccionDao.getInstance().getById(area).toDto();
	}

	public ArrayList<LineaProduccionDto> getLineasOcupadas(AreaProduccionDto area) throws RemoteException {
		
		ArrayList<LineaProduccionDto> lineasDto = new ArrayList<LineaProduccionDto>();
		
		ArrayList<LineaProduccion> lineas = AreaProduccionDao.getInstance().getLineasOcupadas(area);
		for (LineaProduccion lineaProduccion : lineas) {
			lineasDto.add(lineaProduccion.toDto());
		}
		
		return lineasDto;
	}
	
	public void liberarLinea(int numero) throws RemoteObjectNotFoundException, ColorException{
		LineaProduccion linea = AreaProduccionDao.getInstance().getLineaId(numero);
		
		OrdenDeProduccionDto ordenDto = new OrdenDeProduccionDto();
		ordenDto.setNroOrden(linea.getCodigoOrden());
		
		OrdenDeProduccion orden = OrdenDeProduccionDao.getInstance().getBuscarOrden(ordenDto);
		
		ProcesoProduccion proceso = new ProcesoProduccion();
		
		boolean procesosPendientes = false;
		
		for (ProcesoProduccion procesoProd : orden.getProcesos()) {
			if(procesoProd.getEstado().equals(EstadoProcesoProduccion.PRODUCCION))
				proceso = procesoProd;
				
			else if (procesoProd.getEstado().equals(EstadoProcesoProduccion.INCOMPLETO))
				procesosPendientes = true;
		}
		
		proceso.setEstado(EstadoProcesoProduccion.COMPLETO);
		proceso.modificar();
		
		linea.Liberar();
		
		if(procesosPendientes == false){
			orden.setEstado(EstadoOrdenProduccion.TERMINADA);
			orden.modificame();
			
			for (String talle : orden.getTalles()) {
				for (String  color : orden.getColores()) {
					
					AlmacenController.getInstance().agregarStockPrenda(orden.getPrenda(), orden.getCantidad(), talle, color, orden);
				}
			}
			
			orden.getPedido().setEstado(EstadoPedidoPrenda.Despacho);
			orden.getPedido().modificame();
		}
		
	}
	
}
