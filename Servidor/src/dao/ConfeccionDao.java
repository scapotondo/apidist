package dao;

import org.hibernate.Session;

import entity.ConfeccionEntity;
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
}
