package dao;

import java.util.ArrayList;
import org.hibernate.Session;
import entity.StockMateriaPrimaEntity;
import hibernate.HibernateUtil;
import negocio.StockMateriaPrima;

public class StockMateriaPrimaDao {

	private static StockMateriaPrimaDao instance;
	
	public static StockMateriaPrimaDao getInstance(){
		if(instance== null)
			instance = new StockMateriaPrimaDao();
		
		return instance;
	}
	
	private StockMateriaPrimaDao(){}
	
	public void CrearStockMateriaPrima(StockMateriaPrima stock){
		
		StockMateriaPrimaEntity stockEntity = new StockMateriaPrimaEntity(stock);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(stockEntity);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public void modificarStockMateriaPrima(StockMateriaPrima stock){
		
		StockMateriaPrimaEntity stockEntity = new StockMateriaPrimaEntity(stock);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(stockEntity);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public void eliminarStockMateriaPrima(StockMateriaPrima stock){
		
		StockMateriaPrimaEntity stockEntity = new StockMateriaPrimaEntity(stock);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(stockEntity);
		session.getTransaction().commit();
		session.close();
		
	}
	
	
	@SuppressWarnings("unchecked")
	public ArrayList<StockMateriaPrima> getStockMateriasPrimas(){
		
		ArrayList<StockMateriaPrima> stockMateriasPrimas= new ArrayList<StockMateriaPrima>();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		ArrayList<StockMateriaPrimaEntity> stockMateriasPrimasEntity = (ArrayList<StockMateriaPrimaEntity>) session.createQuery("from StockMateriaPrimaEntity").list();
		session.getTransaction().commit();
		session.close();
		
		if(stockMateriasPrimasEntity == null)
			return null;
		
		for (StockMateriaPrimaEntity stockMateriaPrimasEntity : stockMateriasPrimasEntity) {
			stockMateriasPrimas.add(new StockMateriaPrima(stockMateriaPrimasEntity));
		}
		
		return stockMateriasPrimas;
	}
}
