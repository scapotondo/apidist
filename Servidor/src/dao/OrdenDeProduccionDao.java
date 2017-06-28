package dao;

import java.util.ArrayList;

import org.hibernate.Session;

import entity.OrdenDeProduccionCompletaEntity;
import entity.OrdenDeProduccionEntity;
import entity.OrdenDeProduccionParcialEntity;
import hibernate.HibernateUtil;
import negocio.OrdenDeProduccion;
import negocio.OrdenProduccionCompleta;
import negocio.OrdenProduccionParcial;

public class OrdenDeProduccionDao {
	private static OrdenDeProduccionDao instance;
	
	public static OrdenDeProduccionDao getInstance(){
		if( instance == null )
			instance = new OrdenDeProduccionDao();
		return instance;
	}

	public ArrayList<OrdenDeProduccion> getOrdenesIncompletas() {
		ArrayList<OrdenDeProduccion> ordenesIncompletas = new ArrayList<OrdenDeProduccion>();
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			@SuppressWarnings("unchecked")
			ArrayList<OrdenDeProduccionEntity> resultados = (ArrayList<OrdenDeProduccionEntity>) session.createQuery("from OrdenDeProduccionEntity op where op.estado != 3").list();
			
			session.getTransaction().commit();
			session.close();
			
			for (OrdenDeProduccionEntity resultado : resultados) {
				if(resultado.equals("entity.OrdenDeProduccionCompletaEntity"))
					ordenesIncompletas.add(new OrdenProduccionCompleta((OrdenDeProduccionCompletaEntity) resultado));
				
				if(resultado.equals("entity.OrdenDeProduccionParcialEntity"))
					ordenesIncompletas.add(new OrdenProduccionParcial((OrdenDeProduccionParcialEntity) resultado));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ordenesIncompletas;
	}
	
	
}
