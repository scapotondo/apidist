package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import dao.PedidoPrendasDao;
import dto.EmpleadoDto;
import dto.PedidoPrendasDto;
import negocio.Cliente;
import negocio.EstadoPedidoPrenda;
import negocio.Factura;
import negocio.FacturaA;
import negocio.FacturaB;
import negocio.ItemFactura;
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
	
	public void despacharPedido(PedidoPrendasDto pedidoDto, EmpleadoDto encargadoDto){
		PedidoPrendas pedido = PedidoPrendasDao.getInstance().BuscarPedidoPrendas(pedidoDto.getNroPedido());
		if (!pedido.getEstado().equals(EstadoPedidoPrenda.Despacho))
			return;
		
		for (ItemPrenda item : pedido.getItems()) 
			AlmacenController.getInstance().disminuirStockPrendaDespacho(item.getPrenda(), item.getCantidad(), item.getTalle(), item.getColor(), encargadoDto.getNombre());
		
		pedido.setEstado(EstadoPedidoPrenda.Terminado);
		pedido.modificame();
		
		Factura factura ;
		
		Cliente cliente = pedido.getCliente();
		
		ArrayList<ItemFactura>itemsFactura = new ArrayList<>();
		for (ItemPrenda item : pedido.getItems()) {
			itemsFactura.add(new ItemFactura(item.getPrenda().getDescripcion(), item.getCantidad()));
		}
		
		if(pedido.getCliente().getFormaPago().equals("FACTURAA"))
			factura = new FacturaA((Date) Calendar.getInstance().getTime(), cliente.getNombre(), cliente.getDireccionFacturacion(), cliente.getCuit(), cliente.getFormaPago(), itemsFactura, pedido.calcularTotal());
		else
			factura = new FacturaB((Date) Calendar.getInstance().getTime(), cliente.getNombre(), cliente.getDireccionFacturacion(), cliente.getCuit(), cliente.getFormaPago(), itemsFactura, pedido.calcularTotal());
	
		factura.saveMe();
	}
	
	public ArrayList<PedidoPrendasDto> GetPedidosADespachar(){
		ArrayList<PedidoPrendas> pedidos = PedidoPrendasDao.getInstance().BuscarPedidosPrendasDespacho();
		
		ArrayList<PedidoPrendasDto> pedidosDespacho = new ArrayList<PedidoPrendasDto>();
		for (PedidoPrendas pedidoPrendas : pedidos)
			pedidosDespacho.add(pedidoPrendas.toDto());
		
		return pedidosDespacho;
	}

}
