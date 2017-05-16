package dao;

import org.hibernate.Session;

import entity.PrendaEntity;
import hibernate.HibernateUtil;
import negocio.Prenda;

public class PrendaDao {
	public static PrendaDao instance;
	
	private PrendaDao() {}
	
	public static PrendaDao getInstance() {
		if (instance == null)
			instance = new PrendaDao();
		
		return instance;
	}
	
	public void AltaPrenda(Prenda prenda) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		session.save(new PrendaEntity(prenda));
		session.getTransaction().commit();
		session.close();
	}
}
