package dao;

import java.util.ArrayList;

import org.hibernate.Session;

import entity.ClienteEntity;
import entity.EmpleadoEntity;
import entity.PedidoPrendasEntity;
import entity.SucursalEntity;
import hibernate.HibernateUtil;
import negocio.Cliente;
import negocio.Empleado;
import negocio.PedidoPrendas;

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
		
		SucursalEntity sucursal=session.get(SucursalEntity.class, cliente.getSucursal().getNumero());
		ClienteEntity clienteEntity = new ClienteEntity(cliente.getLimiteCredito(),cliente.getFormaPago(),cliente.getCuentaCorriente(),
				cliente.getCuit(),cliente.getNombre(),cliente.getRazonSocial(),cliente.getTelefono(),cliente.getDireccionEnvio(),
				cliente.getDireccionFacturacion(),new ArrayList<PedidoPrendasEntity>(),sucursal);
		
		session.save(clienteEntity);
		session.getTransaction().commit();
		session.close();
	}
	
}
