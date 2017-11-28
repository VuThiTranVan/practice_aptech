package app.service;

import java.util.List;

import app.model.Student;

public interface StudentService {
	Student findById(Integer id);
	boolean createStudent(Student st);
	boolean updateStudent(Student st);
	boolean deleteStudent(Student st);
	
	// Using HQL
	Student findByEmail(String email);
	
	List<Student> searchSt(String name, int gender);
}
