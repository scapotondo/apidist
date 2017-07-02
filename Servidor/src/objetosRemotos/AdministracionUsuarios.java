	package objetosRemotos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.hibernate.HibernateException;

import controller.Controller;
import dto.UsuarioDto;
import exceptions.UsuarioException;
import interfaces.AdministracionUsuariosInterface;

public class AdministracionUsuarios extends UnicastRemoteObject implements AdministracionUsuariosInterface{

	private static final long serialVersionUID = 692523953057761750L;

	public AdministracionUsuarios() throws RemoteException {
		super();
	}

	@Override
	public UsuarioDto LoginCliente(String userName, String password)throws RemoteException {
		return Controller.getInstance().LoginCliente(userName, password);
	}

	@Override
	public UsuarioDto getUsuarioCliente(int codigo) throws RemoteException, UsuarioException {
		try {
			return Controller.getInstance().getUsuarioCliente(codigo);
		} catch (HibernateException ex) {
			throw new UsuarioException(ex.getMessage());
		}
	}
	
	@Override
	public UsuarioDto LoginEmpleado(String userName, String password)throws RemoteException {
		return Controller.getInstance().LoginEmpleado(userName, password);
	}
	
	@Override
	public UsuarioDto getUsuarioEmpleado(int codigo) throws RemoteException, UsuarioException {
		try {
			return Controller.getInstance().getUsuarioEmpleado(codigo);
		} catch (HibernateException ex) {
			throw new UsuarioException(ex.getMessage());
		}
	}
}
