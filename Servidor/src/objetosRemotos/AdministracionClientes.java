package objetosRemotos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import controller.AdministracionController;
import dto.ClienteDto;
import interfaces.AdministracionClientesInterface;
import negocio.Cliente;

public class AdministracionClientes extends UnicastRemoteObject implements AdministracionClientesInterface{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdministracionClientes() throws RemoteException {
		super();
	}

	public void AltaCliente(ClienteDto cliente) throws RemoteException {
		AdministracionController.getInstance().AltaCliente(cliente);
	}
	
	public void ModificarCliente(ClienteDto cliente) throws RemoteException {
		AdministracionController.getInstance().ModificarCliente(cliente);
	}
	
	public void EliminarCliente(ClienteDto cliente) throws RemoteException {
		AdministracionController.getInstance().EliminarCliente(cliente);
	}
	
	public ClienteDto BuscarClientePorId(ClienteDto clienteDto) throws RemoteException {
		Cliente cliente = AdministracionController.getInstance().BuscarClientePorId(clienteDto);
		
		if(cliente == null)
			return new ClienteDto();
		
		return cliente.toDto();
	}
	
	public ArrayList<ClienteDto> BuscarClientes() throws RemoteException {
		return AdministracionController.getInstance().BuscarClientes();
	}
}
