package spring_dataaccess.app.dao;

import spring_dataaccess.app.model.Student;

public interface StudentDAO {
	int create(Student st);

	Student update(Student st);

	Student findById(int id);

	boolean delete(int id);
}
