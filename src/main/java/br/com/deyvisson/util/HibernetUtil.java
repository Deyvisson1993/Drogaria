package br.com.deyvisson.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernetUtil {
	
	private static SessionFactory fabricaDeSessoes = criarFrabricaDeSessoes();
	
	public static SessionFactory getFabricaDeSessoes() {
		return fabricaDeSessoes;
	}
	
	private static SessionFactory criarFrabricaDeSessoes() {
		
		try {
			Configuration configuracao = new Configuration().configure(); // configura e confirma os asquivos hiberate.cfg.xml
			
			@SuppressWarnings("unused")
			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
			
			SessionFactory fabrica = configuracao.buildSessionFactory();
			return fabrica;
		} catch (Throwable ex) {
			System.err.println("A fabrica de sessões nao pode ser criada. " + ex);
			throw new ExceptionInInitializerError(ex);
		}
		
	}

}