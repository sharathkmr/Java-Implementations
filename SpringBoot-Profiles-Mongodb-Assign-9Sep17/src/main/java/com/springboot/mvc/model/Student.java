package com.springboot.mvc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Student {
	
	@Id
	private int number;
	
	@Field(value ="name")
	private String name;
	
	@Field(value ="course")
	private String course;
	
	public Student(int number, String name, String course) {
		this.number = number;
		this.name = name;
		this.course = course;
	}
	
	public Student() {}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [number=" + number + ", name=" + name + ", course=" + course + "]";
	}
	
}
