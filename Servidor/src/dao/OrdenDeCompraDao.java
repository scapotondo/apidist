package dao;

import java.util.ArrayList;

import org.hibernate.Session;

import entity.OrdenDeCompraEntity;
import hibernate.HibernateUtil;
import negocio.OrdenDeCompra;

public class OrdenDeCompraDao {
	private static OrdenDeCompraDao instance;
	
	public OrdenDeCompraDao(){}
	
	public static OrdenDeCompraDao getInstance(){
		if(instance == null)
			return new OrdenDeCompraDao();
		return instance;
	}
	
	public OrdenDeCompra getById(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		OrdenDeCompraEntity ordenEntity = session.get(OrdenDeCompraEntity.class, id);
		session.getTransaction().commit();
		session.close();
		
		OrdenDeCompra orden = new OrdenDeCompra(ordenEntity);
		
		return orden;
	}
	
	public ArrayList<OrdenDeCompra> getOrdenesDeCompra(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		ArrayList<OrdenDeCompraEntity> ordenesDeCompraEntity = (ArrayList<OrdenDeCompraEntity>) session.createQuery("from OrdenDeCompraEntity").list();
		session.getTransaction().commit();
		session.close();
		
		if(ordenesDeCompraEntity == null)
			return null;
		
		ArrayList<OrdenDeCompra> ordenesDeCompra = new ArrayList<OrdenDeCompra>();
		
		for (OrdenDeCompraEntity orden : ordenesDeCompraEntity) {
			ordenesDeCompra.add(new OrdenDeCompra(orden));
		}
		
		return ordenesDeCompra;
	}
	
	public void crearOrdenDeCompra(OrdenDeCompra ordenDeCompra){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		session.save(new OrdenDeCompraEntity(ordenDeCompra));
		session.getTransaction().commit();
		session.close();
	}
	
	public void modificarOrdenDeCompra(OrdenDeCompra ordenDeCompra){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		session.update(new OrdenDeCompraEntity(ordenDeCompra));
		session.getTransaction().commit();
		session.close();
	}
	
	public void eliminarOrdenDeCompra(OrdenDeCompra ordenDeCompra){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		session.delete(new OrdenDeCompraEntity(ordenDeCompra));
		session.getTransaction().commit();
		session.close();
	}
}
