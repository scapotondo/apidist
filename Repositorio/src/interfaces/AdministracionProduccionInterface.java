package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.AreaProduccionDto;
import dto.MateriaPrimaDto;
import dto.SucursalDto;

public interface AdministracionProduccionInterface extends Remote{

	public ArrayList<AreaProduccionDto> getAreasProduccion() throws RemoteException;
	
	public ArrayList<MateriaPrimaDto> getMateriasPrimas() throws RemoteException;
	
	public ArrayList<SucursalDto> getSucursales() throws RemoteException;
}
