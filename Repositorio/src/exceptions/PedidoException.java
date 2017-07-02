package exceptions;

import java.rmi.RemoteException;

public class PedidoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PedidoException (String message) {
		super(message);
	}
	
	public PedidoException (String message, StackTraceElement[] stackTrace) {
		super(message);
		
		this.setStackTrace(stackTrace);
	}
}
