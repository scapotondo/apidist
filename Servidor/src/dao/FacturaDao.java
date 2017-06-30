package dao;

import org.hibernate.Session;

import entity.FacturaEntity;
import hibernate.HibernateUtil;
import negocio.Factura;

public class FacturaDao {
	private static FacturaDao instance;
	
	public static FacturaDao getInstance(){
		if(instance == null)
			instance = new FacturaDao();
		
		return instance;
	}
	
	public void altaFactura(Factura factura){
		FacturaEntity facturaEntity = new FacturaEntity(factura);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(facturaEntity);
		session.getTransaction().commit();
		session.close();
	}
}
