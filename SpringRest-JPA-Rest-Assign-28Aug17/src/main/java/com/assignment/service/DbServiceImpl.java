package com.assignment.service;

import java.util.List;

import com.assignment.dbaccess.DataAccessImpl;
import com.assignment.model.Employee;

public class DbServiceImpl {

	private static DataAccessImpl daImpl;

	private DbServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public static List<Employee> getEmp() {
		if(daImpl == null) {
			daImpl = new DataAccessImpl();
		}
		return daImpl.getData();
	}

	public static Employee getEmp(int id) {
		Employee emp = new Employee();
		emp.setId(id);
		if(daImpl == null) {
			daImpl = new DataAccessImpl();
		}
		return daImpl.getEmployee(emp);
	}

	public static boolean insertEmp(Employee emp) {
		if(daImpl == null) {
			daImpl = new DataAccessImpl();
		}
		return daImpl.insertEmployee(emp);
	}

	public static Employee updateEmp(Employee emp) {
		if(daImpl == null) {
			daImpl = new DataAccessImpl();
		}
		return daImpl.updateEmployee(emp);
	}

	public static boolean deleteEmp(int id) {
		if(daImpl == null) {
			daImpl = new DataAccessImpl();
		}
		Employee emp = new Employee();
		emp.setId(id);
		return daImpl.deleteEmployee(emp);
	}

}
