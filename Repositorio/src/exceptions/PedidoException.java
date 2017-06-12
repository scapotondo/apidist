package exceptions;

import java.rmi.RemoteException;

public class PedidoException extends RemoteException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PedidoException (String message) {
		super(message);
	}
}
