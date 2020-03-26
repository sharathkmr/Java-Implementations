package com.assignment.dbaccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.assignment.db.connection.DbConnection;

public class Test {
	
	private static final String PERSISTENCE_UNIT_NAME = "Employee";
    private static EntityManagerFactory factory;

	public static void main(String[] args) {
	//	factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		factory = DbConnection.getEmFactory();
        EntityManager em = factory.createEntityManager();
        // Read the existing entries and write to console
        Query q = em.createQuery("select e FROM Employee e");
        /*List<Employee> userList = q.getResultList();
        for (Employee emp : userList) {
             System.out.println(emp.getName());
        }
        System.out.println("Size: " + userList.size());
*/
        // Create new user
        /*em.getTransaction().begin();
        User user = new User();
        user.setName("Tom Johnson");
        user.setLogin("tomj");
        user.setPassword("pass");
        em.persist(user);
        em.getTransaction().commit();
*/
        em.close();
	}

}
