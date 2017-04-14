package fr.imie.spring.conf;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.hib.init.HibernateUtil;

public class VideDatabase {
	
	public static void main(String[] args) throws HibernateException {
		
		Session session = HibernateUtil.getSession();
		
		//vide la BDD
	    session.beginTransaction();
	    session.createNativeQuery("truncate table panier").executeUpdate();	
	    session.createNativeQuery("truncate table panier_plat").executeUpdate();
	    session.createNativeQuery("truncate table plat").executeUpdate();	
	    session.getTransaction().commit();    
	   
	    HibernateUtil.getSessionFactory().close();
	    System.out.println("database vider");
	}
}
