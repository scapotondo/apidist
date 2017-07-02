package dao;

import org.hibernate.Session;

import dto.RolUsuarioEnum;
import dto.UsuarioDto;
import entity.ClienteEntity;
import entity.EmpleadoEntity;
import exceptions.UsuarioException;
import hibernate.HibernateUtil;
import negocio.Cliente;
import negocio.Empleado;

public class UsuarioDao {

	private static UsuarioDao instance;
	
	public static UsuarioDao getInstance(){
		if(instance == null)
			instance = new UsuarioDao();
		
		return instance;
	}
	
	public UsuarioDto loginCliente(String userName, String password) throws UsuarioException{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		ClienteEntity clienteEntity = (ClienteEntity)session.createQuery("from ClienteEntity WHERE usuario = ? AND password = ?")
				.setParameter(0, userName)
				.setParameter(1, password)
				.uniqueResult();
		session.getTransaction().commit();
		session.close();
		
		if(clienteEntity == null)
			throw new UsuarioException("El usuario no existe");
		Cliente cliente = new Cliente(clienteEntity);
		
		return new UsuarioDto(cliente.getLegajo(), cliente.getPassword(), cliente.getUsuario(), RolUsuarioEnum.Cliente);
	}
	
	public UsuarioDto loginEmpleado(String userName, String password) throws UsuarioException{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		EmpleadoEntity empleadoEntity = (EmpleadoEntity) session.createQuery("from EmpleadoEntity WHERE usuario = ? AND password = ?")
				.setParameter(0, userName)
				.setParameter(1, password)
				.uniqueResult();
		session.getTransaction().commit();
		session.close();
		
		if(empleadoEntity == null)
			throw new UsuarioException("El usuario no existe");
		Empleado empleado = new Empleado(empleadoEntity);
		
		return new UsuarioDto(empleado.getLegajo(),empleado.getPassword(), empleado.getUsuario(), empleado.getRolUsuario());
	}
	
	
	public UsuarioDto getUsuarioCliente(int codigo) throws UsuarioException{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		ClienteEntity clienteEntity = session.get(ClienteEntity.class, codigo);
		session.getTransaction().commit();
		session.close();
		
		if(clienteEntity == null)
			throw new UsuarioException("El usuario no existe");
		Cliente cliente = new Cliente(clienteEntity);
		
		return new UsuarioDto(cliente.getLegajo(), cliente.getPassword(), cliente.getUsuario(), RolUsuarioEnum.Cliente);
	}
	
	public UsuarioDto getUsuarioEmpleado(int codigo) throws UsuarioException{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		EmpleadoEntity empleadoEntity = session.get(EmpleadoEntity.class, codigo);
		session.getTransaction().commit();
		session.close();
		
		if(empleadoEntity == null)
			throw new UsuarioException("El usuario no existe");
		Empleado empleado = new Empleado(empleadoEntity);
		
		return new UsuarioDto(empleado.getLegajo(),empleado.getPassword(), empleado.getUsuario(), empleado.getRolUsuario());
	}
}
