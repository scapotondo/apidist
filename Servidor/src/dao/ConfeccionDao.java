package dao;

import org.hibernate.Session;

import dto.ConfeccionDto;
import entity.ConfeccionEntity;
import exceptions.ApplicationException;
import hibernate.HibernateUtil;
import negocio.Confeccion;

public class ConfeccionDao {
	private static ConfeccionDao instance;
	
	private ConfeccionDao() { }
	
	public static ConfeccionDao getInstance() {
		if (instance == null)
			instance = new ConfeccionDao();
		
		return instance;
	}
	
	public void crearConfeccion(Confeccion confeccion) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		ConfeccionEntity entity = new ConfeccionEntity(confeccion);

		session.save(entity);
		session.getTransaction().commit();
		session.close();
	}
	
	public Confeccion buscarConfeccion(ConfeccionDto confeccionDto) throws ApplicationException{
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		ConfeccionEntity entity = (ConfeccionEntity) session.get(ConfeccionEntity.class, confeccionDto.getId());
		session.getTransaction().commit();
		session.close();
		
		if(entity == null)
			throw new ApplicationException("la confeccion " +confeccionDto.getId() + " no existe");
		
		return new Confeccion(entity);
	}
}
