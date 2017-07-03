
package controller;

import java.util.ArrayList;
import java.util.Calendar;

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
		
		AlmacenController.getInstance().agregarStockMateriaPrima(orden.getMateriaPrima(), orden.getCantidad(), precio, orden.getOrdenProduccion());
		
		orden.setEstado(OrdenDeCompra.REALIZADA);
		orden.setFechaRealDespacho(Calendar.getInstance().getTime());
		orden.getOrdenProduccion().setEstado(EstadoOrdenProduccion.PENDIENTE);
		orden.getOrdenProduccion().modificame();
		orden.modificame();
		
		AlmacenController.getInstance().reservarMateriaPrima(orden.getMateriaPrima(), orden.getCantidad(), orden.getOrdenProduccion());
	}
	
	public ArrayList<OrdenDeCompraDto> getOrdenesPendientes(){
		ArrayList<OrdenDeCompraDto> ordenesDto = new ArrayList<OrdenDeCompraDto>();
		ArrayList<OrdenDeCompra> ordenes = OrdenDeCompraDao.getInstance().getOrdenesDeCompraPendientes();
		
		if(ordenes == null)
			return null;
		
		for (OrdenDeCompra ordenDeCompra : ordenes) {
			ordenesDto.add(ordenDeCompra.toDto());
		}
		
		return ordenesDto;
	}
	

}
