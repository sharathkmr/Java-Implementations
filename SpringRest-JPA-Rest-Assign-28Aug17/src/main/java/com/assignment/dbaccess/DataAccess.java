package com.assignment.dbaccess;

import java.util.List;

import com.assignment.model.Employee;

public interface DataAccess {
	
	public List<Employee> getData();
	public Employee getEmployee(Employee emp);
	public boolean insertEmployee(Employee emp);
	public boolean insertEmployees(List<Employee> emps);
	public Employee updateEmployee(Employee emp);
	public boolean deleteEmployee(Employee emp);

}
