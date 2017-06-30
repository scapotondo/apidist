package dto;

import java.io.Serializable;

public class UsuarioDto implements Serializable {

	private static final long serialVersionUID = 9062961408595506567L;

	private RolUsuarioEnum rol;
	private String userName;
	private String password;
	private int codigo;
	private ClienteDto cliente;
	
	public UsuarioDto(){}
	
	public UsuarioDto(int codigo, String password, String userName, RolUsuarioEnum rol, ClienteDto cliente){
		this.codigo = codigo;
		this.password = password;
		this.userName = userName;
		this.rol = rol;
		this.cliente = cliente;
	}
	
	public RolUsuarioEnum getRol() {
		return rol;
	}
	public void setRol(RolUsuarioEnum rol) {
		this.rol = rol;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String nombre) {
		this.password = nombre;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public ClienteDto getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDto cliente) {
		this.cliente = cliente;
	}
	
}
