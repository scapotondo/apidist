package objetosRemotos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.hibernate.HibernateException;

import controller.Controller;
import dto.ClienteDto;
import dto.PedidoPrendasDto;
import exceptions.ApplicationException;
import exceptions.PedidoException;
import interfaces.AdministracionPedidoInterface;

public class AdministracionPedidos extends UnicastRemoteObject implements AdministracionPedidoInterface {

	private static final long serialVersionUID = 1L;

	public AdministracionPedidos() throws RemoteException {
		super();
	}

	public PedidoPrendasDto CrearPedido(PedidoPrendasDto pedido) throws RemoteException, PedidoException {
		try {
			return Controller.getInstance().CrearPedidoPrendas(pedido);
		} catch (HibernateException ex) {
			throw new PedidoException(ex.getMessage(), ex.getStackTrace());
		}
	}

	public void AprobarPedidoAdmin(PedidoPrendasDto pedidoDto) throws RemoteException, PedidoException {
		Controller.getInstance().AprobarPedidoAdmin(pedidoDto);
	}

	public PedidoPrendasDto BuscarPedido(int nroPedido) throws RemoteException {
		return Controller.getInstance().BuscarPedido(nroPedido).toDto();
	}

	public void RechazarPedidoAdmin(PedidoPrendasDto pedidoDto, String descripcion) throws RemoteException, ApplicationException, PedidoException {
		try{
		Controller.getInstance().RechazarPedidoAdmin(pedidoDto,descripcion);
		} catch (HibernateException ex) {
			throw new ApplicationException(ex.getMessage());
		}
	}

	public void AceptarPedidoCliente(int nroPedido) throws RemoteException, PedidoException {
		Controller.getInstance().AceptarPedidoCliente(nroPedido);
		
	}

	public void RechazarPedidoCliente(int nroPedido) throws RemoteException, PedidoException {
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
