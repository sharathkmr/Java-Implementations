package com.hib.assign.connection;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hib.assign.model.FlowerShop;
import com.hib.assign.model.Manager;

public class Test {
	
	public static void main(String[] args) {
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Manager m = new Manager("Sharath", "Kumar");
		Manager m2 = new Manager("Shiva", "Kumar");
		
		
		/*session.save(m);
		session.save(m2);*/
		
		
		FlowerShop fs = new FlowerShop("New Flower Shop");
		
		List<Manager> managers = new LinkedList<Manager>();
		
		managers.add(m);
		managers.add(m2);
		fs.setManagers(managers);
		
		
		/*session.save(m);
		session.save(m2);*/
		
		session.save(fs);
		
		tr.commit();
		System.out.println("Successfully inserted");
		sessFact.close();
	}

}
