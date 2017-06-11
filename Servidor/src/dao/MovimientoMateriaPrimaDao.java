package dao;

import java.util.ArrayList;

import org.hibernate.Session;

import dto.MovimientoMateriaPrimaDto;
import entity.MovimientoMateriaPrimaEntity;
import hibernate.HibernateUtil;
import negocio.MovimientoMateriaPrima;

public class MovimientoMateriaPrimaDao {
private static MovimientoMateriaPrimaDao instance;
	
	public static MovimientoMateriaPrimaDao getInstance(){
		if(instance==null)
			instance = new MovimientoMateriaPrimaDao();
		
		return instance;
	}
	
	private MovimientoMateriaPrimaDao(){}
	
	public void CrearMovimientoMateriaPrima(MovimientoMateriaPrima movimiento){
		
		MovimientoMateriaPrimaEntity movimientoEntity = new MovimientoMateriaPrimaEntity(movimiento);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		session.save(movimientoEntity);
		session.getTransaction().commit();
		session.close();
	}
	
	public void EliminarMovimientoMateriaPrima(MovimientoMateriaPrima movimiento){
		
		MovimientoMateriaPrimaEntity movimientoEntity = new MovimientoMateriaPrimaEntity(movimiento);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		session.delete(movimientoEntity);
		session.getTransaction().commit();
		session.close();
	}
	
	public MovimientoMateriaPrima BuscarMovimientoMateriaPrima(MovimientoMateriaPrimaDto movimiento){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		MovimientoMateriaPrimaEntity movimientoEntity = session.get(MovimientoMateriaPrimaEntity.class, movimiento.getId());
		session.getTransaction().commit();
		session.close();
		
		if(movimientoEntity == null)
			return null;
		
		return new MovimientoMateriaPrima(movimientoEntity);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<MovimientoMateriaPrima> BuscarMovimientoMateriaPrimaReservara(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		ArrayList<MovimientoMateriaPrimaEntity> movimientosReservadosEntity = (ArrayList<MovimientoMateriaPrimaEntity>) session.createQuery("from MovimientoMateriaPrimaEntity WHERE estado = Reservar").list();
		session.getTransaction().commit();
		session.close();
		
		if(movimientosReservadosEntity == null)
			return null;
		
		ArrayList<MovimientoMateriaPrima> movimientosReservados= new ArrayList<MovimientoMateriaPrima>();
		
		for (MovimientoMateriaPrimaEntity movimientoMateriaPrimaEntity : movimientosReservadosEntity) {
			
			movimientosReservados.add(new MovimientoMateriaPrima(movimientoMateriaPrimaEntity));
		}
		
		return movimientosReservados;
	}
}
