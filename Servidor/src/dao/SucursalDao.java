package dao;

import java.util.ArrayList;

import org.hibernate.Session;

import dto.SucursalDto;
import entity.EmpleadoEntity;
import entity.PedidoPrendasEntity;
import entity.SucursalEntity;
import hibernate.HibernateUtil;
import negocio.Sucursal;

public class SucursalDao {
	private static SucursalDao instance;
	
	private SucursalDao(){}
	
	public static SucursalDao getInstance() {
		if (instance == null)
			instance = new SucursalDao();
	
		return instance;
	}
	
	public Sucursal getSucursalById(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		SucursalEntity sucursal =session.get(SucursalEntity.class, id);
		session.getTransaction().commit();
		session.close();
		
		if (sucursal == null)
			return null;
		
		return new Sucursal(sucursal);
	}
	
	public ArrayList<Sucursal> getSucursales(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		ArrayList<SucursalEntity> sucursalesEntity =(ArrayList<SucursalEntity>) session.createQuery("from SucursalEntity").list();
		session.getTransaction().commit();
		session.close();
		
		if (sucursalesEntity == null)
			return null;
		
		ArrayList<Sucursal> sucursales = new ArrayList<Sucursal>();
		
		for (SucursalEntity sucursalEntity : sucursalesEntity) {
			sucursales.add(new Sucursal(sucursalEntity));
		}
		
		return sucursales;
	}
	
	public void altaSucursal(SucursalDto sucursal){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		SucursalEntity sucursalEntity = new SucursalEntity(sucursal.getNumero(), sucursal.getNombre(), sucursal.getDireccion(),
				sucursal.getHorarios(), new ArrayList<EmpleadoEntity>(), new ArrayList<PedidoPrendasEntity>());
		session.save(sucursalEntity);
		session.getTransaction().commit();
		session.close();
	}
	
	public void modificarSucursal(Sucursal sucursal){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		SucursalEntity sucursalEntity= new SucursalEntity(sucursal);
		session.beginTransaction();
		session.update(sucursalEntity);
		session.getTransaction().commit();
		session.close();
	}
}
