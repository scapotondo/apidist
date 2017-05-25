package exceptions;

import java.rmi.RemoteException;

public class PrendaException extends RemoteException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PrendaException(String message) {
		super(message);
	}
}
