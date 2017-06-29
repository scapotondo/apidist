package interfaces;

import java.rmi.Remote;

import dto.UsuarioDto;

public interface AdministracionUsuariosInterface extends Remote {
	public UsuarioDto Login (String userName, String password);
}
