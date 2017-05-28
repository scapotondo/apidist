package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.AreaProduccionDto;
import dto.MateriaPrimaDto;

public interface AdministracionProduccionInterface extends Remote{

	public ArrayList<AreaProduccionDto> getAreasProduccion() throws RemoteException;
	
	public ArrayList<MateriaPrimaDto> getMateriasPrimas() throws RemoteException;
}
