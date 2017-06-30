	package objetosRemotos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import controller.Controller;
import dto.UsuarioDto;
import interfaces.AdministracionUsuariosInterface;

public class AdministracionUsuarios extends UnicastRemoteObject implements AdministracionUsuariosInterface{

	private static final long serialVersionUID = 692523953057761750L;

	public AdministracionUsuarios() throws RemoteException {
		super();
	}

	@Override
	public UsuarioDto Login(String userName, String password)throws RemoteException {
		return Controller.getInstance().Login(userName, password);
	}

	@Override
	public UsuarioDto getUsuario(int codigo) throws RemoteException {
		return Controller.getInstance().getUsuario(codigo);
	}
}
