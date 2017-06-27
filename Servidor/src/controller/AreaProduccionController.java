package controller;

import java.util.ArrayList;

import dao.PedidoPrendasDao;
import dto.OrdenDeProduccionDto;
import negocio.PedidoPrendas;

public class AreaProduccionController {

	private static AreaProduccionController instance;
	
	public AreaProduccionController getInstance(){
		if(instance == null)
			instance = new AreaProduccionController();
		
		return instance;
	}
	
	public ArrayList<OrdenDeProduccionDto> getOrdenesProduccion(){
		ArrayList<OrdenDeProduccionDto> ordenesDto = new ArrayList<OrdenDeProduccionDto>();
		
		ArrayList<PedidoPrendas> pedidos = PedidoPrendasDao.getInstance().BuscarPedidosPrendasProduccion();
		
		for (PedidoPrendas pedidoPrendas : pedidos) {
			ordenesDto.add(pedidoPrendas.getOrdenProduccion().toDto());
		}
		
		return ordenesDto;
	}
	
	
	
}
