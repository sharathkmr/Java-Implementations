package com.springboot.mvc.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.springboot.mvc.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	private static Map<Integer, Student> students;
	
	static {
		
		students = new HashMap<>();
		students.put(1, new Student(1, "name 1", "course 1"));
		students.put(2, new Student(2, "name 2", "course 2"));
		students.put(3, new Student(3, "name 3", "course 3"));
		
	}

	@Override
	public Collection<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return this.students.values();
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return this.students.get(id);
	}

	@Override
	public void removeStudentById(int id) {
		// TODO Auto-generated method stub
		this.students.remove(id);
	}

	@Override
	public void updateStudentById(Student student) {
		// TODO Auto-generated method stub
		Student s = this.students.get(student.getNumber());
		s.setName(student.getName());
		s.setCourse(student.getCourse());
		this.students.put(student.getNumber(), s);
	}

	@Override
	public void insertStudent(Student student) {
		// TODO Auto-generated method stub
		this.students.put(student.getNumber(), student);
	}

}
