package dao;

import org.hibernate.Session;

import entity.ProcesoProduccionEntity;
import hibernate.HibernateUtil;
import negocio.ProcesoProduccion;

public class ProcesoProduccionDao {
	private static ProcesoProduccionDao instance;
	
	public static ProcesoProduccionDao getInstance(){
		if(instance == null)
			instance = new ProcesoProduccionDao();
		
		return instance;
	}
	
	public void modificarProceso(ProcesoProduccion proceso){
		ProcesoProduccionEntity entity = new ProcesoProduccionEntity(proceso);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();
		session.close();
	}
}
