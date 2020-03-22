package com.boot.app.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.boot.app.mongo.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Long> {
	
	public Employee getEmpById(Long id);
	public Employee getEmpByName(String name);
	
}
