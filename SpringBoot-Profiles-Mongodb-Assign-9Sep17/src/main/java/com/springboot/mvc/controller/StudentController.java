package com.springboot.mvc.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mvc.model.Student;
import com.springboot.mvc.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentServiceImpl;
	
	@RequestMapping(method=RequestMethod.GET)
	public Collection<Student> getAllStudents() {
		return studentServiceImpl.getAllStudents();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Student getStudentById(@PathVariable("id") int id) {
		return studentServiceImpl.getStudentById(id);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void removeStudentById(@PathVariable("id") int id) {
		studentServiceImpl.removeStudentById(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateStudentById(@RequestBody Student student) {
		studentServiceImpl.updateStudentById(student);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertStudent(@RequestBody Student student) {
		studentServiceImpl.updateStudentById(student);
	}

}
