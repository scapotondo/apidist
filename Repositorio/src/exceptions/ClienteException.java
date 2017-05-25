package exceptions;

import java.rmi.RemoteException;

public class ClienteException extends RemoteException {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteException(String message) {
		super(message);
	}
}
