package exceptions;

import java.rmi.RemoteException;

public class OrdenCompraException extends RemoteException {
	
	private static final long serialVersionUID = 1L;
	
	public OrdenCompraException(String message) {
		super(message);
	}
}