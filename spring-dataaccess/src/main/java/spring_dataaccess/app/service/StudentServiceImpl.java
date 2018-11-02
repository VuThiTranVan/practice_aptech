package spring_dataaccess.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring_dataaccess.app.dao.StudentDAO;
import spring_dataaccess.app.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDAO studentDAO;
	
	@Transactional
	public boolean createStudent(Student st) {
		if (studentDAO.create(st) == 1)
			return true;
		return false;
	}

}
