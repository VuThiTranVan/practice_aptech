package app.dao;

import java.util.List;

import app.model.Student;

public interface StudentDAO extends IGenericDAO<Integer, Student> {
	Student findByEmail(String email);

	List<Student> searchStudentUsingCretial(String name, String email);

	List<Student> getListStudent();

}
