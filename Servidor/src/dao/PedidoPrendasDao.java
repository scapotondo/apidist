package dao;

import java.util.ArrayList;

import org.hibernate.Session;

import dto.ClienteDto;
import dto.PedidoPrendasDto;
import entity.PedidoPrendasEntity;
import exceptions.PedidoException;
import hibernate.HibernateUtil;
import negocio.Cliente;
import negocio.PedidoPrendas;

public class PedidoPrendasDao {

	private static PedidoPrendasDao instance;
	public static PedidoPrendasDao getInstance(){
		if(instance== null)
			instance = new PedidoPrendasDao();
		
		return instance;
	}
	private PedidoPrendasDao(){}

	public PedidoPrendas CrearPedidoPrendas(PedidoPrendas pedido){
		PedidoPrendasEntity pedidoEntity = new PedidoPrendasEntity(pedido);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		session.save(pedidoEntity);
		session.getTransaction().commit();
		session.close();
		
		return new PedidoPrendas(pedidoEntity);
	}
	
	public void EliminarPedidoPrendas(PedidoPrendas pedido){
		PedidoPrendasEntity pedidoEntity = new PedidoPrendasEntity(pedido);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		session.delete(pedidoEntity);
		session.getTransaction().commit();
		session.close();
	}
	
	public void ModificarPedidoPrendas(PedidoPrendas pedido){
		PedidoPrendasEntity pedidoEntity = new PedidoPrendasEntity(pedido);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		session.update(pedidoEntity);
		session.getTransaction().commit();
		session.close();
	}
	
	public PedidoPrendas BuscarPedidoPrendas(int nroPedido){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		PedidoPrendasEntity pedidoEntity = session.get(PedidoPrendasEntity.class, nroPedido);
		session.getTransaction().commit();
		session.close();
		
		if(pedidoEntity == null)
			return null;
		
		return new PedidoPrendas(pedidoEntity);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<PedidoPrendas> BuscarPedidosPrendas(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		ArrayList<PedidoPrendasEntity> pedidosEntity = (ArrayList<PedidoPrendasEntity>) session.createQuery("from PedidoPrendasEntity").list();
		session.getTransaction().commit();
		session.close();
		
		if(pedidosEntity == null)
			return null;
		
		ArrayList<PedidoPrendas> pedidos = new ArrayList<PedidoPrendas>();
		
		for (PedidoPrendasEntity pedidoPrendasEntity : pedidosEntity) {
			pedidos.add(new PedidoPrendas(pedidoPrendasEntity));
		}
		
		return pedidos;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<PedidoPrendas> BuscarPedidosPrendasDespacho(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		ArrayList<PedidoPrendasEntity> pedidosEntity = (ArrayList<PedidoPrendasEntity>) session.createQuery("from PedidoPrendasEntity WHERE estado = 7").list();
		session.getTransaction().commit();
		session.close();
		
		if(pedidosEntity == null)
			return null;
		
		ArrayList<PedidoPrendas> pedidos = new ArrayList<PedidoPrendas>();
		
		for (PedidoPrendasEntity pedidoPrendasEntity : pedidosEntity) {
			pedidos.add(new PedidoPrendas(pedidoPrendasEntity));
		}
		
		return pedidos;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<PedidoPrendas> BuscarPedidosPrendasProduccion(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		ArrayList<PedidoPrendasEntity> pedidosEntity = (ArrayList<PedidoPrendasEntity>) session.createQuery("from PedidoPrendasEntity WHERE estado = 3").list();
		session.getTransaction().commit();
		session.close();
		
		if(pedidosEntity == null)
			return null;
		
		ArrayList<PedidoPrendas> pedidos = new ArrayList<PedidoPrendas>();
		
		for (PedidoPrendasEntity pedidoPrendasEntity : pedidosEntity) {
			pedidos.add(new PedidoPrendas(pedidoPrendasEntity));
		}
		
		return pedidos;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<PedidoPrendas> BuscarPedidosPrendasAprobadasAdmin(Cliente cliente){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		ArrayList<PedidoPrendasEntity> pedidosEntity = (ArrayList<PedidoPrendasEntity>) session.createQuery("from PedidoPrendasEntity WHERE estado = 2 AND cliente_legajo = ?").setParameter(0, cliente.getLegajo()).list();
		session.getTransaction().commit();
		session.close();
		
		if(pedidosEntity == null)
			return null;
		
		ArrayList<PedidoPrendas> pedidos = new ArrayList<PedidoPrendas>();
		
		for (PedidoPrendasEntity pedidoPrendasEntity : pedidosEntity) {
			pedidos.add(new PedidoPrendas(pedidoPrendasEntity));
		}
		
		return pedidos;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<PedidoPrendas> BuscarPedidosPrendasRechazadosAdmin(Cliente cliente){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		ArrayList<PedidoPrendasEntity> pedidosEntity = (ArrayList<PedidoPrendasEntity>) session.createQuery("from PedidoPrendasEntity WHERE estado = 5 AND cliente_legajo = ?").setParameter(0, cliente.getLegajo()).list();
		session.getTransaction().commit();
		session.close();
		
		if(pedidosEntity == null)
			return null;
		
		ArrayList<PedidoPrendas> pedidos = new ArrayList<PedidoPrendas>();
		
		for (PedidoPrendasEntity pedidoPrendasEntity : pedidosEntity) {
			pedidos.add(new PedidoPrendas(pedidoPrendasEntity));
		}
		
		return pedidos;
	}
	public ArrayList<PedidoPrendas> getPedidosAceptados(ClienteDto cliente) {
		ArrayList<PedidoPrendas> pedidosAceptados = new ArrayList<PedidoPrendas>();
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			session.beginTransaction();
			@SuppressWarnings({ "unchecked" })
			ArrayList<PedidoPrendasEntity> pedidosEntity = (ArrayList<PedidoPrendasEntity>) session.createQuery("from PedidoPrendasEntity where cliente_legajo = ? and estado = 3").setParameter(0,  cliente.getLegajo()).list();
			session.getTransaction().commit();
			session.close();
			
			for (PedidoPrendasEntity pedido : pedidosEntity) {
				pedidosAceptados.add(new PedidoPrendas(pedido));
			}
			
			return pedidosAceptados;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
