package exceptions;

import java.rmi.RemoteException;

public class UsuarioException extends RemoteException{

	private static final long serialVersionUID = 1L;

	public UsuarioException(String mensaje){
		super(mensaje);
	}
}
