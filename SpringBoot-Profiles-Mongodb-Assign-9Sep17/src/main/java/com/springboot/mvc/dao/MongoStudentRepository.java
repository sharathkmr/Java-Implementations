package com.springboot.mvc.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.mvc.model.Student;

public interface MongoStudentRepository extends MongoRepository<Student, Integer> {

}
