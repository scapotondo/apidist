package interfaces;

import java.rmi.*;
import java.util.ArrayList;

import dto.ClienteDto;
import dto.PedidoPrendasDto;
import exceptions.*;

public interface AdministracionPedidoInterface extends Remote{

	public PedidoPrendasDto CrearPedido(PedidoPrendasDto pedido) throws RemoteException, PedidoException;
	
	public void AprobarPedidoAdmin(PedidoPrendasDto pedidoDto) throws RemoteException, PedidoException;
	
	public PedidoPrendasDto BuscarPedido(int nroPedido)throws RemoteException;
	
	public void RechazarPedidoAdmin(PedidoPrendasDto pedidoDto, String descripcion) throws RemoteException, ApplicationException, PedidoException;
	
	public void AceptarPedidoCliente(int nroPedido) throws RemoteException, PedidoException;
	
	public void RechazarPedidoCliente(int nroPedido) throws RemoteException, PedidoException;

	public ArrayList<PedidoPrendasDto> getPedidosDespacho() throws RemoteException;

	public ArrayList<PedidoPrendasDto> getPedidosAceptados(ClienteDto cliente) throws RemoteException;
	
	public ArrayList<PedidoPrendasDto> getPedidosPendientesAceptacionCliente(ClienteDto cliente) throws RemoteException;
	
	public ArrayList<PedidoPrendasDto> getPedidosPendientesAceptacionAdmin()throws RemoteException;
	
}
