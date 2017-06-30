package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.ClienteDto;
import dto.PedidoPrendasDto;

public interface AdministracionPedidoInterface extends Remote{

	public PedidoPrendasDto CrearPedido(PedidoPrendasDto pedido) throws RemoteException;
	
	public void AprobarPedidoAdmin(PedidoPrendasDto pedidoDto) throws RemoteException;
	
	public PedidoPrendasDto BuscarPedido(int nroPedido)throws RemoteException;
	
	public void RechazarPedidoAdmin(PedidoPrendasDto pedidoDto, String descripcion) throws RemoteException;
	
	public void AceptarPedidoCliente(int nroPedido) throws RemoteException;
	
	public void RechazarPedidoCliente(int nroPedido) throws RemoteException;

	public ArrayList<PedidoPrendasDto> getPedidosAceptados(ClienteDto cliente) throws RemoteException;
	
}
