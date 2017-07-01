
package controller;

import java.util.ArrayList;

import dao.OrdenDeCompraDao;
import dto.OrdenDeCompraDto;
import negocio.EstadoOrdenProduccion;
import negocio.OrdenDeCompra;


public class AreaComprasController {
	private static AreaComprasController instance;
	
	public static AreaComprasController getInstance(){
		if(instance == null)
			instance = new AreaComprasController();
		
		return instance;
	}
	
	
	public void comprar(OrdenDeCompraDto ordenDto){
		OrdenDeCompra orden = OrdenDeCompraDao.getInstance().getById(ordenDto.getId());
		Float precio = orden.getCantidad() * orden.getPrecioUnitario();
		
		AlmacenController.getInstance().agregarStockMateriaPrima(orden.getMateriaPrima(), orden.getCantidad(), precio);
		
		orden.setEstado(OrdenDeCompra.REALIZADA);
		orden.getOrdenProduccion().setEstado(EstadoOrdenProduccion.PENDIENTE);
		
		AlmacenController.getInstance().reservarMateriaPrima(orden.getMateriaPrima(), orden.getCantidad(), orden.getOrdenProduccion());
	}
	public void generarNotaDeCredito(){
		
	}
	public void generarNotaDeDebito(){
		
	}
	public ArrayList<Integer> getNroOrdenCompra(){
		return null;
	}

}
