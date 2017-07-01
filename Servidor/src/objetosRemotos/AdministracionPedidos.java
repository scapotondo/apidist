package objetosRemotos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import controller.Controller;
import dto.ClienteDto;
import dto.PedidoPrendasDto;
import interfaces.AdministracionPedidoInterface;

public class AdministracionPedidos extends UnicastRemoteObject implements AdministracionPedidoInterface {

	private static final long serialVersionUID = 1L;

	public AdministracionPedidos() throws RemoteException {
		super();
	}

	public PedidoPrendasDto CrearPedido(PedidoPrendasDto pedido) throws RemoteException {
		return Controller.getInstance().CrearPedidoPrendas(pedido);
	}

	public void AprobarPedidoAdmin(PedidoPrendasDto pedidoDto) throws RemoteException {
		Controller.getInstance().AprobarPedidoAdmin(pedidoDto);
	}

	public PedidoPrendasDto BuscarPedido(int nroPedido) throws RemoteException {
		return Controller.getInstance().BuscarPedido(nroPedido).toDto();
	}

	public void RechazarPedidoAdmin(PedidoPrendasDto pedidoDto, String descripcion) throws RemoteException {
		Controller.getInstance().RechazarPedidoAdmin(pedidoDto,descripcion);
		
	}

	public void AceptarPedidoCliente(int nroPedido) throws RemoteException {
		Controller.getInstance().AceptarPedidoCliente(nroPedido);
		
	}

	public void RechazarPedidoCliente(int nroPedido) throws RemoteException {
		Controller.getInstance().RechazarPedidoCliente(nroPedido);
	}

	public ArrayList<PedidoPrendasDto> getPedidosDespacho() throws RemoteException {
		return Controller.getInstance().getPedidosDespacho();
	}
	
	public ArrayList<PedidoPrendasDto> getPedidosAceptados(ClienteDto cliente) throws RemoteException {
		return Controller.getInstance().getPedidosAceptados(cliente);
	}

	public ArrayList<PedidoPrendasDto> getPedidosPendientesAceptacionCliente(ClienteDto cliente)throws RemoteException {
		return Controller.getInstance().getPedidosPendientesAceptacionCliente(cliente);
	}

	public ArrayList<PedidoPrendasDto> getPedidosPendientesAceptacionAdmin() throws RemoteException {
		return Controller.getInstance().getPedidosPendientesAceptacionAdmin();
	}
	
}
