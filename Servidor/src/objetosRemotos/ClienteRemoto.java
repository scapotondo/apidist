package objetosRemotos;

import java.util.ArrayList;

import controller.Controller;
import dto.ClienteDto;

public class ClienteRemoto {
	private static ClienteRemoto instance;
	private ClienteRemoto(){}
	
	public static ClienteRemoto getInstance(){
		if(instance==null)
			instance=new ClienteRemoto();
		return instance;
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
