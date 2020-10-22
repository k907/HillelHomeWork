package Util;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Slf4j
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    /***
     * Create the SessionFactory from hibernate.cfg.xml
     */
    private static SessionFactory buildSessionFactory() throws HibernateException{
            return new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Close caches and connection pools
     */
    public static void shutdown() {
        getSessionFactory().close();
    }
}
