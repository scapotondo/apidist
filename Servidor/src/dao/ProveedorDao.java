package dao;

import java.util.ArrayList;

import org.hibernate.Session;

import entity.ProveedorEntity;
import hibernate.HibernateUtil;
import negocio.Proveedor;

public class ProveedorDao {
	private static ProveedorDao instance;
	
	public static ProveedorDao getInstance(){
		if(instance == null)
			instance = new ProveedorDao();
		
		return instance;
	}
	
	public ArrayList<Proveedor> getProveedores (){
		ArrayList<Proveedor> proveedores = new ArrayList<>();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		ArrayList<ProveedorEntity> proveedoresEntity = (ArrayList<ProveedorEntity>) session.createQuery("from ProveedorEntity").list();
		session.getTransaction().commit();
		session.close();
		
		if(proveedoresEntity == null)
			return null;
		
		for (ProveedorEntity proveedorEntity : proveedoresEntity) {
			proveedores.add(new Proveedor(proveedorEntity));
		}
		
		return proveedores;
	}
}
