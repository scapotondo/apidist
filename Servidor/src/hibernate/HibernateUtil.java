package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.*;
 
public class HibernateUtil{
	
    private static final SessionFactory sessionFactory;

    static{
        try{
        	 Configuration config = new Configuration();
        	 config.addAnnotatedClass(ClienteEntity.class);
        	 config.addAnnotatedClass(PedidoPrendasEntity.class);
        	 config.addAnnotatedClass(SucursalEntity.class);
        	 config.addAnnotatedClass(OrdenDeProduccionEntity.class);
        	 config.addAnnotatedClass(OrdenDeProduccionParcialEntity.class);
        	 config.addAnnotatedClass(OrdenDeProduccionCompletaEntity.class);
        	 config.addAnnotatedClass(ItemPrendaEntity.class);
        	 config.addAnnotatedClass(PrendaEntity.class);
        	 config.addAnnotatedClass(MateriaPrimaEntity.class);
        	 config.addAnnotatedClass(EmpleadoEntity.class);
        	 config.addAnnotatedClass(ConfeccionEntity.class);
        	 config.addAnnotatedClass(StockPrendaEntity.class);
        	 config.addAnnotatedClass(StockMateriaPrimaEntity.class);
        	 config.addAnnotatedClass(OrdenDeCompraEntity.class);
        	 config.addAnnotatedClass(AreaProduccionEntity.class);
        	 config.addAnnotatedClass(InsumoEntity.class);
        	 config.addAnnotatedClass(ProveedorEntity.class);
        	 config.addAnnotatedClass(LineaProduccionEntity.class);
        	 config.addAnnotatedClass(MovimientoPrendaEntity.class);
        	 config.addAnnotatedClass(MovimientoMateriaPrimaEntity.class);
        	 config.addAnnotatedClass(FacturaEntity.class);
        	 config.addAnnotatedClass(ItemFacturaEntity.class);
        	 config.addAnnotatedClass(UsuarioEntity.class);
        	 
             sessionFactory = config.buildSessionFactory();
             
        }catch (Throwable ex){
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    
    public static void main(String[] args) {
    	SessionFactory sf = HibernateUtil.getSessionFactory();
		@SuppressWarnings("unused")
		Session session = sf.openSession();
	}
    
}