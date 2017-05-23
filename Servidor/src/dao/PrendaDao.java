package dao;

import java.util.ArrayList;

import org.hibernate.Session;

import dto.PrendaDto;
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
	
	public void EliminarPrenda(Prenda prenda){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		PrendaEntity prendaEntity= new PrendaEntity(prenda);
		session.beginTransaction();
		session.beginTransaction();
		session.delete(prendaEntity);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public void ModificarPrenda(Prenda prenda){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		PrendaEntity prendaEntity= new PrendaEntity(prenda);
		session.beginTransaction();
		session.beginTransaction();
		session.update(prendaEntity);
		session.getTransaction().commit();
		session.close();
	}
	
	public Prenda BuscarPrendaPorCodigo(PrendaDto prendaDto){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		PrendaEntity prendaEntity = session.get(PrendaEntity.class, prendaDto.getCodigo());
		session.getTransaction().commit();
		session.close();
		
		return new Prenda(prendaEntity);
	}
	
	public ArrayList<Prenda> BuscarPrendas(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		ArrayList<PrendaEntity> prendasEntity = (ArrayList<PrendaEntity>) session.createQuery("from PrendaEntity").list();
		session.getTransaction().commit();
		session.close();
		
		ArrayList<Prenda> prendas = new ArrayList<Prenda>();
		
		for (PrendaEntity prendaEntity : prendasEntity) {
			prendas.add(new Prenda(prendaEntity));
		}
		
		return prendas;
	}
}
