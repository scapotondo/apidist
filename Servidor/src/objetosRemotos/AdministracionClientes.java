package objetosRemotos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import controller.Controller;
import dto.ClienteDto;
import interfaces.AdministracionClientesInterface;

public class AdministracionClientes extends UnicastRemoteObject implements AdministracionClientesInterface{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdministracionClientes() throws RemoteException {
		super();
	}

	public void AltaCliente(ClienteDto cliente){
		Controller.getInstance().AltaCliente(cliente);
	}
	
	public void ModificarCliente(ClienteDto cliente){
		Controller.getInstance().ModificarCliente(cliente);
	}
	
	public void EliminarCliente(ClienteDto cliente){
		Controller.getInstance().EliminarCliente(cliente);
	}
	
	public ClienteDto BuscarClientePorId(ClienteDto cliente){
		return Controller.getInstance().BuscarClientePorId(cliente);
	}
	
	public ArrayList<ClienteDto> BuscarClientes(){
		return Controller.getInstance().BuscarClientes();
	}
}
