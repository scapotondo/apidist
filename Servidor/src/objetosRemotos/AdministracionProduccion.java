package objetosRemotos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import controller.Controller;
import dto.AreaProduccionDto;
import dto.MateriaPrimaDto;
import interfaces.AdministracionProduccionInterface;

public class AdministracionProduccion extends UnicastRemoteObject implements AdministracionProduccionInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdministracionProduccion() throws RemoteException {
		super();
	}

	@Override
	public ArrayList<AreaProduccionDto> getAreasProduccion() throws RemoteException{
		return Controller.getInstance().GetAreasProduccion();
	}

	@Override
	public ArrayList<MateriaPrimaDto> getMateriasPrimas() throws RemoteException {
		return Controller.getInstance().GetMateriasPrimas();
	}
	

}
