package app.service;

import java.util.List;

import app.model.Student;

public interface StudentService {
	Student findById(Integer id);

	boolean saveOrUpdate(Student st);

	boolean deleteStudent(Integer id);

	// Using HQL
	Student findByEmail(String email);

	List<Student> searchSt(String name, int gender);

	List<Student> getListStudent();
}
