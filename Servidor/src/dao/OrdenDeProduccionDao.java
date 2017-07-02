package dao;

import java.util.ArrayList;

import org.hibernate.Session;

import dto.OrdenDeProduccionDto;
import entity.OrdenDeProduccionCompletaEntity;
import entity.OrdenDeProduccionEntity;
import entity.OrdenDeProduccionParcialEntity;
import exceptions.RemoteObjectNotFoundException;
import hibernate.HibernateUtil;
import negocio.OrdenDeProduccion;
import negocio.OrdenProduccionCompleta;
import negocio.OrdenProduccionParcial;

public class OrdenDeProduccionDao {
	private static OrdenDeProduccionDao instance;

	public static OrdenDeProduccionDao getInstance() {
		if (instance == null)
			instance = new OrdenDeProduccionDao();
		return instance;
	}

	public ArrayList<OrdenDeProduccion> getOrdenesIncompletas() {
		ArrayList<OrdenDeProduccion> ordenesIncompletas = new ArrayList<OrdenDeProduccion>();
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			@SuppressWarnings("unchecked")
			ArrayList<OrdenDeProduccionEntity> resultados = (ArrayList<OrdenDeProduccionEntity>) session.createQuery("from OrdenDeProduccionEntity where estado = 1").list();

			session.getTransaction().commit();
			session.close();

			for (OrdenDeProduccionEntity resultado : resultados) {
				if (resultado.equals("entity.OrdenDeProduccionCompletaEntity"))
					ordenesIncompletas.add(new OrdenProduccionCompleta (resultado));
				else
					ordenesIncompletas.add(new OrdenProduccionParcial((OrdenDeProduccionParcialEntity)resultado));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ordenesIncompletas;
	}

	public OrdenDeProduccion getBuscarOrden(OrdenDeProduccionDto ordenDto) throws RemoteObjectNotFoundException {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		OrdenDeProduccionEntity ordenEntity = session.get(OrdenDeProduccionEntity.class, ordenDto.getNroOrden());
		session.getTransaction().commit();
		session.close();

		if (ordenEntity == null)
			throw new RemoteObjectNotFoundException("No se encontro la orden de produccion");

		if (ordenEntity.equals("entity.OrdenDeProduccionCompletaEntity"))
			return new OrdenProduccionCompleta((OrdenDeProduccionCompletaEntity) ordenEntity);

		return new OrdenProduccionParcial((OrdenDeProduccionParcialEntity) ordenEntity);

	}
	
	public OrdenDeProduccion crearOrden(OrdenDeProduccion orden){
		OrdenDeProduccionEntity ordenEntity;
		
		if (orden.getClass().equals("entity.OrdenProduccionCompleta"))
			ordenEntity = new OrdenDeProduccionCompletaEntity(orden);
		else
			ordenEntity = new OrdenDeProduccionParcialEntity(orden);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(ordenEntity);
		session.flush();
		session.getTransaction().commit();
		session.close();
		
		if (orden.getClass().equals("entity.OrdenProduccionCompleta"))
			return  new OrdenProduccionCompleta(ordenEntity);
		else
			return new OrdenProduccionParcial(ordenEntity, (ArrayList<String>)orden.getTalles(), (ArrayList<String>)orden.getColores());
	}
	
	public void modificame(OrdenDeProduccion orden){
		try {
			OrdenDeProduccion ordenProd = getBuscarOrden(orden.toDto());
			
			OrdenDeProduccionEntity ordenEntity;
			
			if (ordenProd.getClass().equals("entity.OrdenProduccionCompleta"))
				ordenEntity = new OrdenDeProduccionCompletaEntity(ordenProd);
			else
				ordenEntity = new OrdenDeProduccionParcialEntity(ordenProd);
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(ordenEntity);
			session.close();
			
		} catch (RemoteObjectNotFoundException e) {
			e.printStackTrace();
		}
	}
}
