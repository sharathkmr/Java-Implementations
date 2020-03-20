package com.springboot.mvc.dao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.mvc.model.Student;

@Repository("mongodb")
public class MongoStudentDaoImpl implements StudentDao {
	
	@Autowired
	private MongoStudentRepository mongoStudentRepository;

	@Override
	public Collection<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return mongoStudentRepository.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return mongoStudentRepository.findOne(id);
	}

	@Override
	public void removeStudentById(int id) {
		// TODO Auto-generated method stub
		mongoStudentRepository.delete(id);
	}

	@Override
	public void updateStudentById(Student student) {
		// TODO Auto-generated method stub
		mongoStudentRepository.save(student);
	}

	@Override
	public void insertStudent(Student student) {
		// TODO Auto-generated method stub
		mongoStudentRepository.save(student);
	}

}
