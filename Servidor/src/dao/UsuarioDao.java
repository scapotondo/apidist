package dao;

import org.hibernate.Session;

import dto.RolUsuarioEnum;
import dto.UsuarioDto;
import entity.UsuarioEntity;
import exceptions.UsuarioException;
import hibernate.HibernateUtil;
import negocio.Cliente;

public class UsuarioDao {

	private static UsuarioDao instance;
	
	public static UsuarioDao getInstance(){
		if(instance == null)
			instance = new UsuarioDao();
		
		return instance;
	}
	
	public UsuarioDto login(String userName, String password) throws UsuarioException{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		UsuarioEntity usuarioEntity = (UsuarioEntity) session.createQuery("from UsuarioEntity WHERE usuario = ? AND password = ?")
				.setParameter(0, userName)
				.setParameter(1, password);
		session.getTransaction().commit();
		session.close();
		
		if(usuarioEntity == null)
			throw new UsuarioException("El usuario no existe");
		Cliente cliente = new Cliente(usuarioEntity.getCliente());
		
		return new UsuarioDto(usuarioEntity.getCodigo(), usuarioEntity.getPassword(), usuarioEntity.getUsuario(), RolUsuarioEnum.fromString(usuarioEntity.getRol()), cliente.toDto());
	}
	
}
