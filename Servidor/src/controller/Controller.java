package controller;

import java.util.ArrayList;

import dao.ClienteDao;
import dao.SucursalDao;
import dto.*;
import negocio.*;

public class Controller {
	
	private ArrayList<PedidoPrendas> pedidos;
	private ArrayList<OrdenDeProduccion> ordenesProduccion;
	private ArrayList<MateriaPrima> materiaPrima;
	private ArrayList<Sucursal> sucursales;
	private AreaProduccion areaProduccion;
	private AreaCompras areaCompras;
	private Almacen almacen;
	private Despacho despacho;
	
	private static Controller instance;
	private Controller(){}
	
	public static Controller getInstance(){
		if(instance==null)
			instance=new Controller();
		return instance;
	}
	
	public void AltaCliente(ClienteDto cliente) {
		Administracion.getInstance().AltaCliente(cliente, SucursalDao.getInstance().getSucursalById(cliente.getSucursal().getNumero()));
	}
}
