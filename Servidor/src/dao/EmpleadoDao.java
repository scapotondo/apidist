package dao;

import org.hibernate.Session;

import dto.EmpleadoDto;
import dto.RolUsuarioEnum;
import dto.UsuarioDto;
import entity.ClienteEntity;
import entity.EmpleadoEntity;
import exceptions.UsuarioException;
import hibernate.HibernateUtil;
import negocio.Cliente;
import negocio.Empleado;

public class EmpleadoDao {

	private static EmpleadoDao instance;
	
	public static EmpleadoDao getInstance(){
		if(instance == null)
			instance = new EmpleadoDao();
		
		return instance;
	}
	
	public Empleado getEmpleado(int codigo) throws UsuarioException{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		EmpleadoEntity empleadoEntity = session.get(EmpleadoEntity.class, codigo);
		session.getTransaction().commit();
		session.close();
		
		if(empleadoEntity == null)
			throw new UsuarioException("El empleado no existe: "+ codigo);
		
		return new Empleado(empleadoEntity);
	}
}
