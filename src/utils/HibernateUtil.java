package utils;

import model.Artigo;
import org.hibernate.cfg.*;
import org.hibernate.SessionFactory;
 
public class HibernateUtil {

	private static SessionFactory sessionFactory;

	private HibernateUtil() {
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				// Create the SessionFactory from standard (hibernate.cfg.xml)
				AnnotationConfiguration ac = new AnnotationConfiguration();
				ac.addAnnotatedClass(Artigo.class);
				sessionFactory = ac.configure().buildSessionFactory();
			} catch (Throwable ex) {
				System.err.println("Initial SessionFactory creation failed." + ex);
				throw new ExceptionInInitializerError(ex);
			}
			return sessionFactory;
		} else {
			return sessionFactory;
		}
	}
}