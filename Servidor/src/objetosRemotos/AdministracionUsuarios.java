package objetosRemotos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import controller.Controller;
import dto.UsuarioDto;
import interfaces.AdministracionUsuariosInterface;

public class AdministracionUsuarios extends UnicastRemoteObject implements AdministracionUsuariosInterface{

	/**
	 * 
	 */
	private static final long serialVersionUID = 692523953057761750L;

	public AdministracionUsuarios() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public UsuarioDto Login(String userName, String password) {
		return Controller.getInstance().Login(userName, password);
	}
}
