package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.PrendaDto;


public interface PrendaInterface extends Remote {

	
	public void AltaPrenda(PrendaDto prendaDto) throws RemoteException;
	
	public void EliminarPrenda(PrendaDto prendaDto) throws RemoteException;
	
	public PrendaDto BuscarPrendaPorId(PrendaDto prendaDto) throws RemoteException;
	
	public void ModificarPrenda(PrendaDto prendaDto) throws RemoteException;
	
	public ArrayList<PrendaDto> BuscarPrendas() throws RemoteException;
}
