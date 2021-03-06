package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.AreaProduccionDto;
import dto.OrdenDeProduccionDto;
import exceptions.ApplicationException;
import exceptions.AreaProduccionException;
import exceptions.RemoteObjectNotFoundException;

public interface AdministracionOrdenesProduccionInterface extends Remote{

	public ArrayList<OrdenDeProduccionDto> getOrdenesAreaProduccion(AreaProduccionDto area) throws RemoteException;
	
	public void IniciarProduccion(OrdenDeProduccionDto ordenDto, AreaProduccionDto areaDto)throws RemoteException, RemoteObjectNotFoundException, AreaProduccionException,ApplicationException;
	
	public OrdenDeProduccionDto buscarOrdenProduccion(OrdenDeProduccionDto ordenDto)throws RemoteException, RemoteObjectNotFoundException;
}
