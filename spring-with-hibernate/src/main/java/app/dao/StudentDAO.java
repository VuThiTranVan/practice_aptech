package app.dao;

import java.util.List;

import app.model.Student;

public interface StudentDAO extends IGenericDAO<Integer, Student> {
	// code select .... using hql or criteria
	
	// using hql
	
	Student findByEmail(String eamil);
	
	List<Student> searchStudentUsingCretial(String name, int gender);
}
