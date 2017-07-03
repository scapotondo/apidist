
package dao;

import java.util.ArrayList;

import org.hibernate.Session;

import dto.AreaProduccionDto;
import entity.AreaProduccionEntity;
import entity.LineaProduccionEntity;
import hibernate.HibernateUtil;
import negocio.AreaProduccion;
import negocio.LineaProduccion;

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
	
	public ArrayList<AreaProduccion> getAreasProduccion () {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		ArrayList<AreaProduccionEntity> areasProduccionEntity = (ArrayList<AreaProduccionEntity>) session.createQuery("from AreaProduccionEntity").list();
		session.close();
		
		if (areasProduccionEntity == null)
			return null;
		
		ArrayList<AreaProduccion> areasProduccion = new ArrayList<AreaProduccion>();
		
		for (AreaProduccionEntity areaProduccionEntity : areasProduccionEntity) {
			areasProduccion.add(new AreaProduccion(areaProduccionEntity));
		}
		
		return areasProduccion;
	}
	
	public ArrayList<LineaProduccion> getLineasOcupadas(AreaProduccionDto area) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		ArrayList<LineaProduccionEntity> lineasEntity = (ArrayList<LineaProduccionEntity>) session
		.createQuery("from LineaProduccionEntity WHERE estado = Ocupado AND areaProduccion_id = ?").setParameter(0, area.getCodigo()).list();
		session.close();
		
		if (lineasEntity == null)
			return null;
		
		ArrayList<LineaProduccion> lineas = new ArrayList<LineaProduccion>();
		
		for (LineaProduccionEntity lineaEntity : lineasEntity) {
			lineas.add(new LineaProduccion(lineaEntity));
		}
		
		return lineas;
	}
	
	
}
