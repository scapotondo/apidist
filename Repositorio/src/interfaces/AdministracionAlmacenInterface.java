package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.MovimientoMateriaPrimaDto;
import dto.MovimientoPrendaDto;
import dto.StockMateriaPrimaDto;
import dto.StockPrendaDto;

public interface AdministracionAlmacenInterface extends Remote{
	
	public ArrayList<MovimientoPrendaDto> getMovimientosPrendas() throws RemoteException;
	
	public ArrayList<MovimientoMateriaPrimaDto> getMovimientosMateriaPrima()throws RemoteException;
	
	public ArrayList<StockMateriaPrimaDto> getStockMateriaPrima() throws RemoteException;
	
	public ArrayList<StockPrendaDto> getStockPrendas() throws RemoteException;

}
