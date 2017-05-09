package dao;

import org.hibernate.*;

import entity.ClienteEntity;
import hibernate.HibernateUtil;
import negocio.Cliente;

public class ClienteDao {
	private static ClienteDao instance;
	
	private ClienteDao() { }
	
	public static ClienteDao getInstance() {
		if (instance ==  null)
			instance = new ClienteDao();
		
		return instance;
	}
	
	public void crearCliente(Cliente cliente) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		session.save(new ClienteEntity());
		//TODO: hacer el save completo
	}
}
