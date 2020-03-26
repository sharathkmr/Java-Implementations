package com.assignment.db.connection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Singleton class
public class DbConnection {
	
	private static EntityManagerFactory emfactory;
	private static DbConnection dbCon;
	
	private DbConnection() {
		emfactory = Persistence.createEntityManagerFactory("Employee");
	}
	
	public static EntityManagerFactory getEmFactory() {
		if(dbCon == null) {
			dbCon = new DbConnection();
		}
		return emfactory;
	}

}
