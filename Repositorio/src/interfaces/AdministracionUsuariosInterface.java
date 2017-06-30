package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dto.UsuarioDto;

public interface AdministracionUsuariosInterface extends Remote {
	public UsuarioDto Login (String userName, String password) throws RemoteException;
	
	public UsuarioDto getUsuario (int codigo) throws RemoteException;
}
