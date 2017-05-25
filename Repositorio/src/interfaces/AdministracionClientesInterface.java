package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.ClienteDto;

public interface AdministracionClientesInterface extends Remote {

	public void AltaCliente(ClienteDto cliente)throws RemoteException;
	
	public void ModificarCliente(ClienteDto cliente)throws RemoteException;
	
	public void EliminarCliente(ClienteDto cliente)throws RemoteException;
	
	public ClienteDto BuscarClientePorId(ClienteDto cliente)throws RemoteException;
	
	public ArrayList<ClienteDto> BuscarClientes()throws RemoteException;
	
}
