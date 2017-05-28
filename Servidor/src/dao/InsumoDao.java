package dao;

import org.hibernate.Session;

import entity.InsumoEntity;
import hibernate.HibernateUtil;
import negocio.Insumo;

public class InsumoDao {
	private static InsumoDao instance;
	
	private InsumoDao() { }
	
	public static InsumoDao getInstance() {
		if (instance == null)
			instance = new InsumoDao();
		
		return instance;
	}

	public void crearInsumo(Insumo insumo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		InsumoEntity entity = new InsumoEntity(insumo);

		session.save(entity);
		session.getTransaction().commit();
		session.close();
	}
}
