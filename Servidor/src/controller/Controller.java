package controller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dao.SucursalDao;
import dto.*;
import dto.PedidoPrendasDto;
import dto.PrendaDto;
import negocio.Administracion;
import negocio.Almacen;
import negocio.AreaCompras;
import negocio.AreaProduccion;
import negocio.Despacho;
import negocio.MateriaPrima;
import negocio.OrdenDeProduccion;
import negocio.PedidoPrendas;
import negocio.Prenda;
import negocio.Sucursal;

public class Controller {
	private static Controller instance;
	
	private ArrayList<PedidoPrendas> pedidos;
	private ArrayList<OrdenDeProduccion> ordenesProduccion;
	private ArrayList<MateriaPrima> materiaPrima;
	private ArrayList<Sucursal> sucursales;
	private AreaProduccion areaProduccion;
	private AreaCompras areaCompras;
	private Almacen almacen;
	private Despacho despacho;

	//singleton
	private Controller(){}
	public static Controller getInstance(){
		if(instance==null)
			instance=new Controller();
		
		return instance;
	}

	//TODO: ver si lo pasamos directo a administracion o no 
	public void AltaCliente(ClienteDto cliente) {
		Administracion.getInstance().AltaCliente(cliente, SucursalDao.getInstance().getSucursalById(cliente.getSucursal().getNumero()));
	}

	public void ModificarCliente(ClienteDto cliente) {
		Administracion.getInstance().ModificarCliente(cliente, SucursalDao.getInstance().getSucursalById(cliente.getSucursal().getNumero()));
	}
	
	public void EliminarCliente(ClienteDto cliente) {
		Administracion.getInstance().EliminarCliente(cliente);
	}

	public ClienteDto BuscarClientePorId(ClienteDto cliente){
		return Administracion.getInstance().BuscarClientePorId(cliente).toDto();
	}

	public ArrayList<ClienteDto> BuscarClientes(){
		return Administracion.getInstance().BuscarClientes();
	}
	
	public void AltaPrenda(PrendaDto prenda) {
		Administracion.getInstance().AltaPrenda(prenda);
	}
	public void EliminarPrenda(PrendaDto prendaDto) {

		Administracion.getInstance().EliminarPrenda(prendaDto);
	}

	public PrendaDto BuscarPrendaPorNumero(PrendaDto prendaDto) {
		
		return Administracion.getInstance().BuscarPrendaPorNumero(prendaDto).toDto();
	}

	public void ModificarPrenda(PrendaDto prendaDto) {
		Administracion.getInstance().ModificarPrenda(prendaDto);
		
	}

	public ArrayList<PrendaDto> BuscarPrendas() {
		return Administracion.getInstance().BuscarPrendas();
	}

	public ArrayList<PrendaDto> GetPrendasDisponibles(){
		//TODO: terminar
		return null;
	}
	
	//ver hasta aca si lo pasamos
	
	public PedidoPrendasDto GenerarPedidoPrendas(){
		//TODO: terminar
		return null;
	}
	
	public void AprobarPedidoAdmin(int nroPedido, int nroSucursal){
		//TODO: terminar
	}
	
	private PedidoPrendas BuscarPedido(int nroPedido){
		//TODO: terminar
		return null;
	}
	
	private Sucursal BuscarSucursal(int nroSucursal){
		//TODO: terminar
		return null;
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
	
	private AreaProduccion BuscarAreaProduccion(int codigo){
		//TODO: terminar
		return null;
	}
	
}
