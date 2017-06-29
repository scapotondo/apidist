package objetosRemotos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import controller.AlmacenController;
import dto.MovimientoMateriaPrimaDto;
import dto.MovimientoPrendaDto;
import dto.StockMateriaPrimaDto;
import dto.StockPrendaDto;
import interfaces.AdministracionAlmacenInterface;

public class AdministracionAlmacen extends UnicastRemoteObject implements AdministracionAlmacenInterface{

	private static final long serialVersionUID = 1L;

	public AdministracionAlmacen() throws RemoteException {
		super();
	}

	public ArrayList<MovimientoPrendaDto> getMovimientosPrendas() throws RemoteException {
		return AlmacenController.getInstance().getMovimientosPrendas();
	}

	public ArrayList<MovimientoMateriaPrimaDto> getMovimientosMateriaPrima() throws RemoteException {
		return AlmacenController.getInstance().getMovimientosMateriaPrima();
	}

	public ArrayList<StockMateriaPrimaDto> getStockMateriaPrima() throws RemoteException {
		return AlmacenController.getInstance().getStockMateriaPrima();
	}

	public ArrayList<StockPrendaDto> getStockPrendas() throws RemoteException {
		return AlmacenController.getInstance().getStockPrendas();
	}

}
