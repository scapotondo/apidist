package hibernate;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dao.SucursalDao;
import dto.SucursalDto;
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
        	 config.addAnnotatedClass(AreaComprasEntity.class);
        	 config.addAnnotatedClass(ProveedorEntity.class);
        	 config.addAnnotatedClass(LineaProduccionEntity.class);
        	 config.addAnnotatedClass(AlmacenEntity.class);
        	 config.addAnnotatedClass(MovimientoPrendaEntity.class);
        	 config.addAnnotatedClass(MovimientoMateriaPrimaEntity.class);
        	 config.addAnnotatedClass(DespachoEntity.class);
        	 
             sessionFactory = config.buildSessionFactory();
             
        }catch (Throwable ex){
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    
//    public static void main(String[] args) {
//    	SessionFactory sf = HibernateUtil.getSessionFactory();
//		Session session = sf.openSession();
//	}
    public static void datos(){
    	
    	SucursalDto sucursal1 = new SucursalDto(1, "sucursal1", "direccion", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    	
    	SucursalDao.getInstance().altaSucursal(sucursal1);
    	
    }

}