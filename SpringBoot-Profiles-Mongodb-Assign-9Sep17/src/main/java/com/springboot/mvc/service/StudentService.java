package com.springboot.mvc.service;

import java.util.Collection;

import com.springboot.mvc.model.Student;

public interface StudentService {
	
	public Collection<Student> getAllStudents();
	
	public Student getStudentById(int id);
	
	public void removeStudentById(int id);
	
	public void updateStudentById(Student student);
	
	public void insertStudent(Student student);

}
