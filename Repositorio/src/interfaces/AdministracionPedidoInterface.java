package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.PedidoPrendasDto;

public interface AdministracionPedidoInterface extends Remote{

	public void CrearPedido(PedidoPrendasDto pedido) throws RemoteException;
	
	
	public void AprobarPedidoAdmin(int nroPedido, int nroSucursal) throws RemoteException;
	
	public PedidoPrendasDto BuscarPedido(int nroPedido)throws RemoteException;
	
	public void RechazarPedidoAdmin(int nroPedido, int nroSucursal, String descripcion) throws RemoteException;
	
	public void AceptarPedidoCliente(int nroPedido) throws RemoteException;
	
	public void RechazarPedidoCliente(int nroPedido) throws RemoteException;
	
}
