package objetosRemotos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import controller.Controller;
import dto.PedidoPrendasDto;
import interfaces.AdministracionPedidoInterface;

public class AdministracionPedidos extends UnicastRemoteObject implements AdministracionPedidoInterface {

	private static final long serialVersionUID = 1L;

	public AdministracionPedidos() throws RemoteException {
		super();
	}

	@Override
	public void CrearPedido(PedidoPrendasDto pedido) throws RemoteException {
		Controller.getInstance().CrearPedidoPrendas(pedido);
	}

	@Override
	public void AprobarPedidoAdmin(int nroPedido, int nroSucursal) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PedidoPrendasDto BuscarPedido(int nroPedido) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void RechazarPedidoAdmin(int nroPedido, int nroSucursal, String descripcion) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AceptarPedidoCliente(int nroPedido) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RechazarPedidoCliente(int nroPedido) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	
}
