package it.formarete.service;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

	private static SessionFactory singleton;

	public static SessionFactory getSessionFactory() {
		if (singleton == null) {
			Configuration config = new Configuration();
			config.configure();
			ServiceRegistry registry = new StandardServiceRegistryBuilder()
							.applySettings(config.getProperties()).build();
			singleton = config.buildSessionFactory(registry);
		}
		return singleton;
	}
}
