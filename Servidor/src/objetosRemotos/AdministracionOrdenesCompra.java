package objetosRemotos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import controller.AreaComprasController;
import dto.OrdenDeCompraDto;

public class AdministracionOrdenesCompra extends UnicastRemoteObject implements interfaces.AdministracionOrdenesCompra{

	private static final long serialVersionUID = 1L;

	public AdministracionOrdenesCompra() throws RemoteException {
		super();
	}

	@Override
	public ArrayList<OrdenDeCompraDto> getOrdenesPendientes() throws RemoteException {
		return AreaComprasController.getInstance().getOrdenesPendientes();
	}

	@Override
	public void aceptarOrden(OrdenDeCompraDto orden) throws RemoteException {
		AreaComprasController.getInstance().comprar(orden);
	}

}
