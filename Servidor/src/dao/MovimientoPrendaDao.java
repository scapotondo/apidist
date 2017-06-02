package dao;

import org.hibernate.Session;

import dto.MovimientoPrendaDto;
import entity.MovimientoPrendaEntity;
import hibernate.HibernateUtil;
import negocio.MovimientoPrenda;

public class MovimientoPrendaDao {

	private static MovimientoPrendaDao instance;
	
	public static MovimientoPrendaDao getInstance(){
		if(instance==null)
			instance = new MovimientoPrendaDao();
		
		return instance;
	}
	
	private MovimientoPrendaDao(){}
	
	public void CrearMovimientoPrenda(MovimientoPrenda movimiento){
		
		MovimientoPrendaEntity movimientoEntity = new MovimientoPrendaEntity(movimiento);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		session.save(movimientoEntity);
		session.getTransaction().commit();
		session.close();
	}
	
	public void EliminarMovimientoPrenda(MovimientoPrenda movimiento){
		
		MovimientoPrendaEntity movimientoEntity = new MovimientoPrendaEntity(movimiento);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		session.delete(movimientoEntity);
		session.getTransaction().commit();
		session.close();
	}
	
	public MovimientoPrenda BuscarMovimientoPrenda(MovimientoPrendaDto movimiento){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		MovimientoPrendaEntity movimientoEntity = session.get(MovimientoPrendaEntity.class, movimiento.getId());
		session.getTransaction().commit();
		session.close();
		
		if(movimientoEntity == null)
			return null;
		
		return new MovimientoPrenda(movimientoEntity);
	}
}
