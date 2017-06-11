package controller;

import java.util.ArrayList;

import dto.*;
import exceptions.*;
import negocio.*;
import dao.*;

public class Controller {
	private static Controller instance;
	
	private ArrayList<PedidoPrendas> pedidos;
	private ArrayList<OrdenDeProduccion> ordenesProduccion;
	private ArrayList<MateriaPrima> materiaPrima;
	private ArrayList<Sucursal> sucursales;
	private AreaProduccion areaProduccion;

	//singleton
	private Controller(){}
	public static Controller getInstance(){
		if(instance==null)
			instance=new Controller();
		
		return instance;
	}

	
	public void CrearPedidoPrendas(PedidoPrendasDto pedido){
		//TODO: terminar
	}
	
	public void AprobarPedidoAdmin(int nroPedido, int nroSucursal){
		//TODO: terminar
	}
	
	public PedidoPrendas BuscarPedido(int nroPedido){
		return PedidoPrendasDao.getInstance().BuscarPedidoPrendas(nroPedido);
	}
	
	public void RechazarPedidoAdmin(int nroPedido, int nroSucursal, String descripcion){
		//TODO: terminar
	}
	
	public void AceptarPedidoCliente(int nroPedido){
		//TODO: terminar
	}
	
	public void RechazarPedidoCliente(int nroPedido){
		//TODO: terminar
	}
	
	public void GenerarDevolucion(Prenda prenda){
		//TODO: terminar
	}
	
	
	public void AumentarRealStockAlmacen(String bulto,int cantidad){
		//TODO: terminar
	}
	
	public void DisminuirRealStockAlmacen(String bulto,int cantidad){
		//TODO: terminar
	}
	
	public void DisminuirStockDefectuosoAlmacen(String lote,int cantidad){
		//TODO: terminar
	}
	
	
	public void RechazarOrdenDeCompra(int nroCompra){
		//TODO: terminar
	}
	
	public ArrayList<PedidoPrendasDto> GetPedidosADespachar(){
		//TODO: terminar
		return null;
	}
	
	public void AceptarPedidoDespacho(int nroPedido){
		//TODO: terminar
	}
	
	public void TrabajoLineaTerminado(int codigoArea, int nroLinea){
		
	}
	
	private AreaProduccion BuscarAreaProduccion(AreaProduccionDto areaProdDto){
		return AreaProduccionDao.getInstance().getById(areaProdDto);
	}
	
	public ArrayList<AreaProduccionDto> GetAreasProduccion(){
		ArrayList<AreaProduccionDto> areasProduccionDto = new ArrayList<AreaProduccionDto>();
		
		ArrayList<AreaProduccion> areasProduccion = AreaProduccionDao.getInstance().getAreasProduccion();
		for (AreaProduccion areaProduccion : areasProduccion) {
			areasProduccionDto.add(areaProduccion.toDto());
		}
		
		return areasProduccionDto;
	}
	
	public ArrayList<MateriaPrimaDto> GetMateriasPrimas(){
		ArrayList<MateriaPrimaDto> materiasPrimasDto = new ArrayList<MateriaPrimaDto>();
		
		ArrayList<MateriaPrima> materiasPrimas = MateriaPrimaDao.getInstance().getMateriasPrimas();
		for (MateriaPrima materiaPrima : materiasPrimas) {
			materiasPrimasDto.add(materiaPrima.toDto());
		}
		
		return materiasPrimasDto;
	}
	
	public ArrayList<SucursalDto> getSucursales(){
		
		ArrayList<SucursalDto> sucursalesDto = new ArrayList<SucursalDto>();
		
		ArrayList<Sucursal> sucursales = SucursalDao.getInstance().getSucursales();
		for (Sucursal sucursal : sucursales) {
			sucursalesDto.add(sucursal.toDto());
		}
		
		return sucursalesDto;
	}
	
	private Sucursal BuscarSucursal(int nroSucursal){
		
		return SucursalDao.getInstance().getSucursalById(nroSucursal);
	}
}
