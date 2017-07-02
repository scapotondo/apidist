package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dto.EmpleadoDto;
import dto.UsuarioDto;
import exceptions.UsuarioException;

public interface AdministracionUsuariosInterface extends Remote {
	
	public UsuarioDto LoginCliente(String userName, String password) throws RemoteException, UsuarioException;
	
	public UsuarioDto LoginEmpleado(String userName, String password) throws RemoteException;
	
	public UsuarioDto getUsuarioCliente (int codigo) throws RemoteException, UsuarioException;
	
	public UsuarioDto getUsuarioEmpleado (int codigo) throws RemoteException, UsuarioException;
	
	public EmpleadoDto getEmpleado(EmpleadoDto empleado) throws RemoteException, UsuarioException;
}
