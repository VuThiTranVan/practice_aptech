package app.service;

import org.springframework.stereotype.Service;

import app.dao.StudentDAO;
import app.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	StudentDAO studentDAO;

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public StudentServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentServiceImpl(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public boolean createStudent(Student st) {
		if (studentDAO.create(st) > 0)
			return true;
		return false;
	}

}
