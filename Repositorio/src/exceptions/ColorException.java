package exceptions;

import java.rmi.RemoteException;

public class ColorException extends RemoteException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ColorException(String message) {
		super(message);
	}
}
