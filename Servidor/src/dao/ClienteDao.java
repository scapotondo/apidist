package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import dto.ClienteDto;
import entity.ClienteEntity;
import entity.PedidoPrendasEntity;
import entity.SucursalEntity;
import hibernate.HibernateUtil;
import negocio.Cliente;
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

		SucursalEntity sucursal = session.get(SucursalEntity.class, cliente.getSucursal().getNumero());
		ClienteEntity clienteEntity = new ClienteEntity(cliente.getLimiteCredito(),cliente.getFormaPago(),cliente.getCuentaCorriente(),
				cliente.getCuit(),cliente.getNombre(),cliente.getRazonSocial(),cliente.getTelefono(),cliente.getDireccionEnvio(),
				cliente.getDireccionFacturacion(),new ArrayList<PedidoPrendasEntity>(),sucursal);

		session.save(clienteEntity);
		session.getTransaction().commit();
		session.close();
	}
	
	public void ModificarCliente(Cliente cliente){
		//TODO: TERMINAR
	}

	public void EliminarCliente(Cliente cliente){

	}

	public Cliente BuscarClientePorId(ClienteDto cliente){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		ClienteEntity clienteEntity = session.get(ClienteEntity.class, cliente.getLegajo());
		session.getTransaction().commit();
		session.close();
		
		return new Cliente(clienteEntity);
	}

	public ArrayList<Cliente> BuscarClientes(){
		ArrayList<Cliente> clientes = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		List<ClienteEntity> clientesEntity =  session.createQuery("from ClienteEntity").list();
		session.getTransaction().commit();
		session.close();
		
		for (ClienteEntity clienteEntity : clientesEntity) {
			clientes.add(new Cliente(clienteEntity));
		}
		
		return clientes;
	}
}
