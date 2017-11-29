package app.service;

import app.model.Student;

public interface StudentService {
	Student findById(Integer id);
	boolean createStudent(Student st);
	boolean updateStudent(Student st);
	boolean deleteStudent(Student st);
}
