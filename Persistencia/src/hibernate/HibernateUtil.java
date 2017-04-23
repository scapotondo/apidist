package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jboss.jandex.Main;

import entity.ClienteEntity;

 
public class HibernateUtil
{
    private static final SessionFactory sessionFactory;

    static
    {
        try
        {
        	 Configuration config = new Configuration();
        	 config.addAnnotatedClass(ClienteEntity.class);
        	 
             sessionFactory = config.buildSessionFactory();
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
    
    public static void main(String[] args) {
    	SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
	}
}
