package objetosRemotos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dto.PrendaDto;
import interfaces.AdministracionPrendasInterface;
import negocio.Administracion;

public class AdministracionPrendas extends UnicastRemoteObject implements AdministracionPrendasInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdministracionPrendas() throws RemoteException {
		super();
	}

	@Override
	public void AltaPrenda(PrendaDto prendaDto) throws RemoteException {
		Administracion.getInstance().AltaPrenda(prendaDto);
	}

	@Override
	public void EliminarPrenda(PrendaDto prendaDto) throws RemoteException {
		Administracion.getInstance().EliminarPrenda(prendaDto);
	}

	@Override
	public PrendaDto BuscarPrendaPorId(PrendaDto prendaDto) throws RemoteException {
		return Administracion.getInstance().BuscarPrendaPorId(prendaDto).toDto();
	}

	@Override
	public void ModificarPrenda(PrendaDto prendaDto) throws RemoteException {
		Administracion.getInstance().ModificarPrenda(prendaDto);
	}

	@Override
	public ArrayList<PrendaDto> BuscarPrendas() throws RemoteException {
		return Administracion.getInstance().BuscarPrendas();
	}

}
