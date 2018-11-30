package tutorial.app.dao;

import java.util.List;

import tutorial.app.model.Student;

public interface StudentDAO extends IGenericDAO<Integer, Student> {
	// code select .... using hql or criteria

	// using hql

	Student findByEmail(String email);

	List<Student> searchStudentUsingCretial(String name, int gender);

	List<Student> getListStudent();

}
