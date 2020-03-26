package com.assignment.dbaccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.assignment.db.connection.DbConnection;
import com.assignment.model.Employee;

public class DataAccessImpl implements DataAccess {
	
	private static EntityManagerFactory factory = DbConnection.getEmFactory();

	@Override
	public List<Employee> getData() {
		EntityManager em = factory.createEntityManager();
        // Read the existing entries and write to console
        Query q = em.createQuery("SELECT e FROM Employee e");
        List<Employee> empList = q.getResultList();
		return empList;
	}

	@Override
	public Employee getEmployee(Employee emp) {
		// TODO Auto-generated method stub
		EntityManager em = factory.createEntityManager();
		Employee employee = em.find(Employee.class, emp.getId());
		
		return employee;
	}

	@Override
	public boolean insertEmployee(Employee emp) {
		// TODO Auto-generated method stub
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(emp);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.close();
			return false;
		}
	}

	@Override
	public boolean insertEmployees(List<Employee> emps) {
		// TODO Auto-generated method stub
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(emps);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.close();
			return false;
		}
	}

	@Override
	public boolean deleteEmployee(Employee emp) {
		// TODO Auto-generated method stub
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(emp);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.close();
			return false;
		}
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			Employee emp_old = em.find(Employee.class, emp.getId());
			emp_old.setName(emp.getName());
			emp_old.setSalary(emp.getSalary());
			em.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		em.close();
		return emp;
	}
	
	

}
