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
	
	public void CrearStockPrenda(StockPrenda stock){
		
		StockPrendaEntity stockEntity = new StockPrendaEntity(stock);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(stockEntity);
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
}
