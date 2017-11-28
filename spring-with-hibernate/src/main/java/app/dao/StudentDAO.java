package app.dao;

import app.model.Student;

public interface StudentDAO {
	int create(Student st);

	Student update(Student st);

	Student findById(int id);

	boolean delete(int id);
}
