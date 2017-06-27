package controller;

import java.util.ArrayList;

import dao.PedidoPrendasDao;
import dto.PedidoPrendasDto;
import negocio.EstadoPedidoPrenda;
import negocio.ItemPrenda;
import negocio.PedidoPrendas;

public class DespachoController {

	private static DespachoController instance;
	
	
	private DespachoController(){}
	
	public static DespachoController getInstance(){
		if(instance == null)
			instance = new DespachoController();
		
		return instance;
	}
	
	
	public void despacharPedido(PedidoPrendas pedido, String encargado){
		for (ItemPrenda item : pedido.getItems()) {
			AlmacenController.getInstance().disminuirStockPrendaDespacho(item.getPrenda(), item.getCantidad(), item.getTalle(), item.getColor(), encargado);
		}
		pedido.setEstado(EstadoPedidoPrenda.Terminado);
		pedido.modificame();
	}
	
	public ArrayList<PedidoPrendasDto> GetPedidosADespachar(){
		ArrayList<PedidoPrendas> pedidos = PedidoPrendasDao.getInstance().BuscarPedidosPrendasDespacho();
		
		ArrayList<PedidoPrendasDto> pedidosDespacho = new ArrayList<PedidoPrendasDto>();
		for (PedidoPrendas pedidoPrendas : pedidos) {
			pedidosDespacho.add(pedidoPrendas.toDto());
		}
		
		return pedidosDespacho;
	}

}
