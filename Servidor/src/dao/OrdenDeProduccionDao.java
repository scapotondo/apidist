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
				if (resultado.getClass().getName().equals("entity.OrdenDeProduccionCompletaEntity"))
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
		OrdenDeProduccionEntity ordenEntity = session.get(OrdenDeProduccionParcialEntity.class, ordenDto.getNroOrden());
		session.getTransaction().commit();
		session.close();
		
		if (ordenEntity == null){
			Session session2 = HibernateUtil.getSessionFactory().openSession();
			session2.beginTransaction();
			OrdenDeProduccionEntity ordenEntityCompleta = session2.get(OrdenDeProduccionCompletaEntity.class, ordenDto.getNroOrden());
			session2.getTransaction().commit();
			session2.close();

			if (ordenEntityCompleta == null)
				throw new RemoteObjectNotFoundException("No se encontro la orden de produccion");
			
			return new OrdenProduccionCompleta((OrdenDeProduccionCompletaEntity) ordenEntityCompleta);
		}

		return new OrdenProduccionParcial((OrdenDeProduccionParcialEntity) ordenEntity);
	}

	public OrdenDeProduccion crearOrden(OrdenDeProduccion orden){
		OrdenDeProduccionEntity ordenEntity;

		if (orden.getClass().getName().equals("negocio.OrdenProduccionCompleta"))
			ordenEntity = new OrdenDeProduccionCompletaEntity(orden);
		else
			ordenEntity = new OrdenDeProduccionParcialEntity(orden);

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(ordenEntity);
		session.getTransaction().commit();
		session.close();

		if (orden.getClass().getName().equals("negocio.OrdenProduccionCompleta"))
			return  new OrdenProduccionCompleta(ordenEntity);
		else
			return new OrdenProduccionParcial(ordenEntity, (ArrayList<String>)orden.getTalles(), (ArrayList<String>)orden.getColores());
	}

	public void modificame(OrdenDeProduccion orden){
		OrdenDeProduccionEntity ordenEntity;

		if (orden.getClass().getName().equals("negocio.OrdenProduccionCompleta"))
			ordenEntity = new OrdenDeProduccionCompletaEntity(orden);
		else
			ordenEntity = new OrdenDeProduccionParcialEntity(orden);

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(ordenEntity);
		session.getTransaction().commit();
		session.close();
	}
}
