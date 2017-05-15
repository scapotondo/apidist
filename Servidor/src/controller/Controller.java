package controller;

import java.util.ArrayList;

import dao.SucursalDao;
import dto.ClienteDto;
import negocio.*;

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

	private Controller(){}

	public static Controller getInstance(){
		if(instance==null)
			instance=new Controller();
		
		return instance;
	}

	public void AltaCliente(ClienteDto cliente) {
		Administracion.getInstance().AltaCliente(cliente, SucursalDao.getInstance().getSucursalById(cliente.getSucursal().getNumero()));
	}

	public void ModificarCliente(ClienteDto cliente) {
		Administracion.getInstance().ModificarCliente(cliente, SucursalDao.getInstance().getSucursalById(cliente.getSucursal().getNumero()));
	}

	public ClienteDto BuscarClientePorId(ClienteDto cliente){
		return Administracion.getInstance().BuscarClientePorId(cliente);
	}

	public ArrayList<ClienteDto> BuscarClientes(){
		return Administracion.getInstance().BuscarClientes();
	}
}
