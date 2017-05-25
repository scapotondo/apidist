package objetosRemotos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import controller.Controller;
import dto.PrendaDto;
import interfaces.AdministracionPrendasInterface;

public class AdministracionPrendas extends UnicastRemoteObject implements AdministracionPrendasInterface{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdministracionPrendas() throws RemoteException {
		super();
	}

	@Override
	public void AltaPrenda(PrendaDto prendaDto) throws RemoteException {

		Controller.getInstance().AltaPrenda(prendaDto);
	}

	@Override
	public void EliminarPrenda(PrendaDto prendaDto) throws RemoteException {

		Controller.getInstance().EliminarPrenda(prendaDto);
	}

	@Override
	public PrendaDto BuscarPrendaPorNumero(PrendaDto prendaDto) throws RemoteException {
		
		return Controller.getInstance().BuscarPrendaPorNumero(prendaDto);
	}

	@Override
	public void ModificarPrenda(PrendaDto prendaDto) throws RemoteException {
		Controller.getInstance().ModificarPrenda(prendaDto);
		
	}

	@Override
	public ArrayList<PrendaDto> BuscarPrendas() throws RemoteException {
		return Controller.getInstance().BuscarPrendas();
	}

	@Override
	public ArrayList<PrendaDto> GetPrendasDisponibles() throws RemoteException {
		// TODO Auto-generated method stub
		return Controller.getInstance().GetPrendasDisponibles();
	}

}
