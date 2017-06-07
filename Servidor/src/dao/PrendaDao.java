package dao;

import java.util.ArrayList;
import java.util.List;

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
		
		session.beginTransaction();
		PrendaEntity prendaEntity= new PrendaEntity(prenda);
		session.delete(prendaEntity);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public void ModificarPrenda(Prenda prenda){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		PrendaEntity prendaEntity= new PrendaEntity(prenda);
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
		
		if (prendaEntity == null)
			return null;
		
		return new Prenda(prendaEntity);
	}
	
	public ArrayList<Prenda> BuscarPrendas(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<PrendaEntity> prendasEntity =  session.createQuery("from PrendaEntity").list();
		session.getTransaction().commit();
		session.close();
		
		ArrayList<Prenda> prendas = new ArrayList<Prenda>();
		
		for (PrendaEntity prendaEntity : prendasEntity) {
			prendas.add(new Prenda(prendaEntity));
		}
		
		return prendas;
	}
	
	//TODO: revisar cuando definamos en base a que valor una prenda es discontinua o no.
	public ArrayList<Prenda> GetPrendasDisponibles(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		//SELECT prenda, SUM(cantidad) AS stock FROM StockPrendaEntity GROUP BY prenda HAVING stock > 0
		List<PrendaEntity> prendasEntity =  session.createQuery("SELECT prenda, SUM(cantidad) AS stock FROM StockPrendaEntity GROUP BY prenda HAVING stock > 0").list();
//		List<PrendaEntity> prendasEntity =  session.createQuery("FROM PrendaEntity P "
//				+ " "
//				+ "WHERE esDiscontinuo = false OR (esDiscontinuo = true AND (SELECT SP.prenda, SUM(SP.cantidad) AS stock FROM P.stock SP WHERE SP.prenda.codigo = P.codigo GROUP BY SP.prenda).stock > 0)").list();
		session.getTransaction().commit();
		session.close();
		
		ArrayList<Prenda> prendas = new ArrayList<Prenda>();
		
		for (PrendaEntity prendaEntity : prendasEntity) {
			prendas.add(new Prenda(prendaEntity));
		}
		
		return prendas;
	}
}
