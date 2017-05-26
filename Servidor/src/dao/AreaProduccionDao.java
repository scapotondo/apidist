package dao;

import org.hibernate.Session;

import dto.AreaProduccionDto;
import entity.AreaProduccionEntity;
import hibernate.HibernateUtil;
import negocio.AreaProduccion;

public class AreaProduccionDao {
	private static AreaProduccionDao instance;
	
	private AreaProduccionDao() {}
	
	public static AreaProduccionDao getInstance() {
		if (instance == null)
			instance = new AreaProduccionDao();
		
		return instance;
	}
	
	public AreaProduccion getById (AreaProduccionDto areaProdDto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		AreaProduccionEntity areaProduccionEntity = (AreaProduccionEntity)session.get(AreaProduccionEntity.class, areaProdDto.getCodigo());
		session.getTransaction().commit();
		session.close();
		
		if (areaProduccionEntity == null)
			return null;
		
		return new AreaProduccion(areaProduccionEntity);
	}
}
