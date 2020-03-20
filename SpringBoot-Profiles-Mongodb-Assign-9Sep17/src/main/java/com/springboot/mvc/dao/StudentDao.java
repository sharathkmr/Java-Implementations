package com.springboot.mvc.dao;

import java.util.Collection;

import com.springboot.mvc.model.Student;

public interface StudentDao {
	
	public Collection<Student> getAllStudents();
	
	public Student getStudentById(int id);
	
	public void removeStudentById(int id);
	
	public void updateStudentById(Student student);
	
	public void insertStudent(Student student);
	
}
