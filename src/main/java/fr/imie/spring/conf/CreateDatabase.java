package fr.imie.spring.conf;

import java.util.ArrayList;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hib.init.HibernateUtil;

import fr.imie.spring.model.PanierModel;
import fr.imie.spring.model.PlatModel;

public class CreateDatabase {

	public static void main(String[] args) throws HibernateException {
		
		Session session = HibernateUtil.getSession();

	    Transaction tx = session.beginTransaction();
	    
	    PlatModel p1 = new PlatModel();
	    p1.setNom("plat1");
	    p1.setDescription("une description");
	    p1.setPrix(11.99d);
	    session.save(p1);
	    PlatModel p2 = new PlatModel();
	    p2.setNom("plat2");
	    p2.setDescription("une autre description");
	    p2.setPrix(16.99);
	    session.save(p2);
	
	    tx.commit();
	    session.close();
	    System.out.println("database crée");
	}
    
}
