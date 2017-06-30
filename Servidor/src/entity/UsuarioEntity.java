package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="Usuario")
public class UsuarioEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;
	
	private String usuario;
	private String password;
	
	private String rol;
	
	@OneToOne()
	private ClienteEntity cliente;
	
	
	public UsuarioEntity(){}
	
	
	public int getCodigo() {
		return codigo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public ClienteEntity getCliente() {
		return cliente;
	}


	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}
	
	
	
	
}
