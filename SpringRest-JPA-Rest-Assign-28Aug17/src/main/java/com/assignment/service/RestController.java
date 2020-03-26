package com.assignment.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.assignment.model.Employee;

@Controller
@RequestMapping("/emp")
public class RestController {
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getEmps() {
		return new ResponseEntity<List<Employee>>(DbServiceImpl.getEmp(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmp(@PathVariable int id) {
		return new ResponseEntity<Employee>(DbServiceImpl.getEmp(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/new/", method = RequestMethod.POST)
	public boolean insertEmp(@RequestBody Employee emp) {
		return DbServiceImpl.insertEmp(emp);
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.POST)
	public ResponseEntity<Employee> updateEmp(@PathVariable int id, @RequestBody Employee emp) {
		Employee currentEmp = DbServiceImpl.getEmp(id);
		currentEmp.setName(emp.getName());
		currentEmp.setSalary(emp.getSalary());
		return new ResponseEntity<Employee>(DbServiceImpl.updateEmp(currentEmp), HttpStatus.OK);
	}
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public boolean deleteEmp(@PathVariable int id) {
		return DbServiceImpl.deleteEmp(id);
	}
	
}
