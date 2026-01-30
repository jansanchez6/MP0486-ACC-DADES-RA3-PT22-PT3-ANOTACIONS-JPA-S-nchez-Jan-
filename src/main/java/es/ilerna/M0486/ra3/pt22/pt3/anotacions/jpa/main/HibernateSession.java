package es.ilerna.M0486.ra3.pt22.pt3.anotacions.jpa.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;


public class HibernateSession {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			
			configuration.configure(); 
			configuration.addAnnotatedClass(es.ilerna.M0486.ra3.pt22.pt3.anotacions.jpa.main.Clases.Person.class);
			configuration.addAnnotatedClass(es.ilerna.M0486.ra3.pt22.pt3.anotacions.jpa.main.Clases.Student.class);
			configuration.addAnnotatedClass(es.ilerna.M0486.ra3.pt22.pt3.anotacions.jpa.main.Clases.Teacher.class);

			configuration.addAnnotatedClass(es.ilerna.M0486.ra3.pt22.pt3.anotacions.jpa.main.Clases.Vehicle.class);
			configuration.addAnnotatedClass(es.ilerna.M0486.ra3.pt22.pt3.anotacions.jpa.main.Clases.Car.class);
			configuration.addAnnotatedClass(es.ilerna.M0486.ra3.pt22.pt3.anotacions.jpa.main.Clases.Plane.class);
			configuration.addAnnotatedClass(es.ilerna.M0486.ra3.pt22.pt3.anotacions.jpa.main.Clases.Motorcycle.class);
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.build();
			
			return configuration.buildSessionFactory(serviceRegistry);		
		} catch (Throwable ex) {
			System.err.println("Error creando SessionFactory: " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
