package controller;

import java.util.ArrayList;

import dao.OrdenDeProduccionDao;
import dto.AreaProduccionDto;
import dto.OrdenDeProduccionDto;
import negocio.Confeccion;
import negocio.EstadoConfeccion;
import negocio.OrdenDeProduccion;

public class AreaProduccionController {

	private static AreaProduccionController instance;
	
	public AreaProduccionController getInstance(){
		if(instance == null)
			instance = new AreaProduccionController();
		
		return instance;
	}
	
	public ArrayList<OrdenDeProduccionDto> getOrdenesProduccion(AreaProduccionDto areaProduccion){
		ArrayList<OrdenDeProduccionDto> ordenesDto = new ArrayList<OrdenDeProduccionDto>();
		
		ArrayList<OrdenDeProduccion> ordenesIncompletas = OrdenDeProduccionDao.getInstance().getOrdenesIncompletas();
		
		for (OrdenDeProduccion ordenIncompleta : ordenesIncompletas) {
			
			for (Confeccion confeccion: ordenIncompleta.getPrenda().getConfecciones()) {
				if(confeccion.getEstado() == EstadoConfeccion.INCOMPLETO ){
					if(confeccion.getAreaProduccion().getCodigo() == areaProduccion.getCodigo())
						ordenesDto.add(ordenIncompleta.toDto());
					break;
				}
					
			}
		}
		
		return ordenesDto;
	}
	
	
	
}
