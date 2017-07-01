package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.OrdenDeCompraDto;

public interface AdministracionOrdenesCompra extends Remote {

	public ArrayList<OrdenDeCompraDto> getOrdenesPendientes() throws RemoteException;
	
	public void aceptarOrden(OrdenDeCompraDto orden) throws RemoteException;
}
