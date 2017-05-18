package objetosRemotos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import controller.Controller;
import dto.ClienteDto;
import interfaces.ClienteInterface;

public class ClienteRemoto extends UnicastRemoteObject implements ClienteInterface{
	
	public ClienteRemoto() throws RemoteException {
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
