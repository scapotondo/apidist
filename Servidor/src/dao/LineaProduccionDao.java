package dao;

import java.util.ArrayList;

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
	
	@SuppressWarnings("unchecked")
	public ArrayList<LineaProduccion> getLineasProduccionDisponibles(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		ArrayList<LineaProduccionEntity> lineasProduccionEntity = (ArrayList<LineaProduccionEntity>) session.createQuery("from LineaProduccionEntity where estado = Libre").list();
		session.getTransaction().commit();
		session.close();
		
		if(lineasProduccionEntity == null)
			return null;
		
		ArrayList<LineaProduccion> lineasProduccion = new ArrayList<LineaProduccion>();
		for (LineaProduccionEntity linea : lineasProduccionEntity) 
			lineasProduccion.add(new LineaProduccion(linea));
		
		return lineasProduccion;
	}
	
	public void Modificar(LineaProduccion linea){
		LineaProduccionEntity lineaEntity = new LineaProduccionEntity(linea);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		session.update(lineaEntity);
		session.getTransaction().commit();
		session.close();
	}
}
