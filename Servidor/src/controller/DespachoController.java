package controller;

import java.util.ArrayList;

import dao.PedidoPrendasDao;
import dto.PedidoPrendasDto;
import negocio.PedidoPrendas;
import negocio.StockPrenda;

public class DespachoController {

	private static DespachoController instance;
	
	private ArrayList<PedidoPrendas> pedidosPrenda;
	
	private DespachoController(){
		this.pedidosPrenda = new ArrayList<PedidoPrendas>();
	}
	
	public static DespachoController getInstance(){
		if(instance == null)
			instance = new DespachoController();
		
		return instance;
	}
	
	
	public void completarPedidos(ArrayList<StockPrenda> prendas, PedidoPrendas pedido){
		
	}
	public void armarPedido(PedidoPrendas pedido){
		
	}
	public void despacharPedido(PedidoPrendas pedido){
		
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
