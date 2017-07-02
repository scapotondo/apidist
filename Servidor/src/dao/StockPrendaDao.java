package dao;

import java.util.ArrayList;

import org.hibernate.Session;

import entity.StockPrendaEntity;
import hibernate.HibernateUtil;
import negocio.StockPrenda;

public class StockPrendaDao {

	private static StockPrendaDao instance;
	
	public static StockPrendaDao getInstance(){
		if(instance== null)
			instance = new StockPrendaDao();
		
		return instance;
	}
	
	private StockPrendaDao(){}
	
	public StockPrenda CrearStockPrenda(StockPrenda stock){
		
		StockPrendaEntity stockEntity = new StockPrendaEntity(stock);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(stockEntity);
		session.flush();
		session.getTransaction().commit();
		session.close();
		
		return new StockPrenda(stockEntity);
	}
	
	public void ModificarStockPrenda(StockPrenda stock){
		
		StockPrendaEntity stockEntity = new StockPrendaEntity(stock);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(stockEntity);
		session.getTransaction().commit();
		session.close();
	}
	
	public void EliminarStockPrenda(StockPrenda stock){
		
		StockPrendaEntity stockEntity = new StockPrendaEntity(stock);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(stockEntity);
		session.getTransaction().commit();
		session.close();
	}
	
	
	@SuppressWarnings("unchecked")
	public ArrayList<StockPrenda> getStockPrendas(){
		
		ArrayList<StockPrenda> stockPrendas= new ArrayList<StockPrenda>();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		ArrayList<StockPrendaEntity> stockPrendasEntity = (ArrayList<StockPrendaEntity>) session.createQuery("from StockPrendaEntity").list();
		session.getTransaction().commit();
		session.close();
		
		if(stockPrendasEntity == null)
			return null;
		
		for (StockPrendaEntity stockPrendaEntity : stockPrendasEntity) {
			stockPrendas.add(new StockPrenda(stockPrendaEntity));
		}
		
		return stockPrendas;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<StockPrenda> getStockPrendasDisponibles(){
		
		ArrayList<StockPrenda> stockPrendas= new ArrayList<StockPrenda>();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		ArrayList<StockPrendaEntity> stockPrendasEntity = (ArrayList<StockPrendaEntity>) session.createQuery("from StockPrendaEntity WHERE cantidad > 0").list();
		session.getTransaction().commit();
		session.close();
		
		if(stockPrendasEntity == null)
			return null;
		
		for (StockPrendaEntity stockPrendaEntity : stockPrendasEntity) {
			stockPrendas.add(new StockPrenda(stockPrendaEntity));
		}
		
		return stockPrendas;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<StockPrenda> getStockPrendasReservadas(int codigoPrenda){
		String query = "from StockPrendaEntity WHERE prenda_codigo = ? AND cantidadPrendasReservadas > 0 ORDER BY cantidad ASC";
		
		ArrayList<StockPrenda> stockPrendas= new ArrayList<StockPrenda>();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		ArrayList<StockPrendaEntity> stockPrendasEntity = (ArrayList<StockPrendaEntity>) session.createQuery(query).setParameter(0,codigoPrenda).list();
		session.getTransaction().commit();
		session.close();
		
		if(stockPrendasEntity == null)
			return null;
		
		for (StockPrendaEntity stockPrendaEntity : stockPrendasEntity) {
			stockPrendas.add(new StockPrenda(stockPrendaEntity));
		}
		
		return stockPrendas;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<StockPrenda> getStockPrendas(int codigoPrenda){
		String query = "from StockPrendaEntity WHERE prenda_codigo = ? ORDER BY cantidad ASC";
		
		ArrayList<StockPrenda> stockPrendas= new ArrayList<StockPrenda>();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		ArrayList<StockPrendaEntity> stockPrendasEntity = (ArrayList<StockPrendaEntity>) session.createQuery(query).setParameter(0,codigoPrenda).list();
		session.getTransaction().commit();
		session.close();
		
		if(stockPrendasEntity == null)
			return null;
		
		for (StockPrendaEntity stockPrendaEntity : stockPrendasEntity) {
			stockPrendas.add(new StockPrenda(stockPrendaEntity));
		}
		
		return stockPrendas;
	}
	
	public StockPrenda BuscarStockPrenda(int codigo){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		StockPrendaEntity stockEntity = session.get(StockPrendaEntity.class, codigo);
		session.getTransaction().commit();
		session.close();
		
		if(stockEntity == null)
			return null;
		
		return new StockPrenda(stockEntity);
	}
}
