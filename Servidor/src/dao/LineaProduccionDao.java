package dao;

import org.hibernate.Session;

import entity.LineaProduccionEntity;
import hibernate.HibernateUtil;
import negocio.LineaProduccion;

public class LineaProduccionDao {

	private static LineaProduccionDao instance;
	
	public static LineaProduccionDao getInstance(){
		if(instance==null)
			instance = new LineaProduccionDao();
		
		return instance;
	}
	
	private LineaProduccionDao(){}
	
	public void Modificar(LineaProduccion linea){
		LineaProduccionEntity lineaEntity = new LineaProduccionEntity(linea);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		session.update(lineaEntity);
		session.getTransaction().commit();
		session.close();
	}
}
