package exceptions;

import java.rmi.RemoteException;

public class SucursalException extends RemoteException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SucursalException(String message) {
		super(message);
	}
}
