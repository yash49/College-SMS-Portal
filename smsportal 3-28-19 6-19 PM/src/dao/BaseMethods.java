package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BaseMethods {
	
	public static SessionFactory getSessionFactory(){
		
		return new Configuration().configure().buildSessionFactory();
	}
	
}
