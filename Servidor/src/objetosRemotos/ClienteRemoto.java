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
	
	public void altaCliente(ClienteDto cliente){
		Controller.getInstance().AltaCliente(cliente);
	}
	
	public ClienteDto BuscarClientePorId(ClienteDto cliente){
		return null;
	}
	
	public ArrayList<ClienteDto> BuscarClientes(){
		return Controller.getInstance().BuscarClientes();
	}
}
