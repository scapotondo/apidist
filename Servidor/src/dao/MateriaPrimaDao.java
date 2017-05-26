package dao;

import org.hibernate.Session;

import dto.MateriaPrimaDto;
import entity.MateriaPrimaEntity;
import hibernate.HibernateUtil;
import negocio.MateriaPrima;

public class MateriaPrimaDao {
	private static MateriaPrimaDao instance;
	
	private MateriaPrimaDao() {}
	
	public static MateriaPrimaDao getInstance() {
		if (instance == null)
			instance = new MateriaPrimaDao();
		
		return instance;
	}
	
	public MateriaPrima getById (MateriaPrimaDto materiaPrimaDto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		MateriaPrimaEntity materiaPrimaEntity = (MateriaPrimaEntity)session.get(MateriaPrimaEntity.class, materiaPrimaDto.getCodigo());
		session.getTransaction().commit();
		session.close();
		
		if (materiaPrimaEntity == null)
			return null;
		
		return new MateriaPrima(materiaPrimaEntity);
	}
}
