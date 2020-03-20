package com.springboot.mvc.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springboot.mvc.dao.StudentDao;
import com.springboot.mvc.model.Student;

@Service
@Qualifier("mysql")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	@Qualifier("mysql")
	private StudentDao studentDaoImpl;

	@Override
	public Collection<Student> getAllStudents() {
		return studentDaoImpl.getAllStudents();
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return studentDaoImpl.getStudentById(id);
	}

	@Override
	public void removeStudentById(int id) {
		// TODO Auto-generated method stub
		studentDaoImpl.removeStudentById(id);
	}

	@Override
	public void updateStudentById(Student student) {
		// TODO Auto-generated method stub
		studentDaoImpl.updateStudentById(student);
	}

	@Override
	public void insertStudent(Student student) {
		// TODO Auto-generated method stub
		studentDaoImpl.insertStudent(student);
	}

}
