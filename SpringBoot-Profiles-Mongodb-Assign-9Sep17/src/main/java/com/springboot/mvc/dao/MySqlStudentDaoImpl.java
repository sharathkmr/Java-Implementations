package com.springboot.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springboot.mvc.model.Student;

@Repository("mysql")
public class MySqlStudentDaoImpl implements StudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static class StudentRowMapper implements RowMapper<Student> {

		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Student s = new Student();
			s.setNumber(rs.getInt("number"));
			s.setName(rs.getString("name"));
			s.setCourse(rs.getString("course"));
			return s;
		}
		
	}

	@Override
	public Collection<Student> getAllStudents() {
		// TODO Auto-generated method stub
		
		final String select_query = "SELECT number, name, course FROM Students";
		// rowmapper to map the columns to the POJO class
		List<Student> students = jdbcTemplate.query(select_query, new StudentRowMapper());
		
		return students;
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT number, name, course FROM Students where number = ?";
		Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
		return student;
	}

	@Override
	public void removeStudentById(int id) {
		// TODO Auto-generated method stub
		final String sql = "DELETE FROM Students WHERE number = ?";
		jdbcTemplate.update(sql, id);
		
	}

	@Override
	public void updateStudentById(Student student) {
		// TODO Auto-generated method stub
		final String sql = "UPDATE Students SET name= ?, course = ? WHERE id = ?";
		jdbcTemplate.update(sql, new Object[] {student.getName(), student.getCourse(), student.getNumber()});
	}

	@Override
	public void insertStudent(Student student) {
		// TODO Auto-generated method stub
		final String sql = "INSERT INTO Students (?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] {student.getNumber(), student.getName(), student.getCourse()});
	}
	
}
