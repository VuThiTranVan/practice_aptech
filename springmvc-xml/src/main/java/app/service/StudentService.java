package app.service;

import java.util.List;

import app.model.Student;

public interface StudentService {
	Student findById(Integer id);

	boolean saveOrUpdate(Student st);

	boolean createStudent(Student st);

	boolean updateStudent(Student st);

	boolean deleteStudent(Integer id);

	// Using HQL
	Student findByEmail(String email);

	List<Student> searchSt(String name, String email);

	List<Student> getListStudent();
}
