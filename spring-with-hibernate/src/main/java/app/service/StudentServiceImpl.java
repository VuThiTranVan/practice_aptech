package app.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import app.dao.StudentDAO;
import app.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	private static final Logger logger = Logger.getLogger(StudentServiceImpl.class);

	StudentDAO studentDAO;

	public Student findById(Integer id) {
		return studentDAO.getFindById(id);
	}

	public boolean createStudent(Student st) {
		try {
			studentDAO.saveOrUpdate(st);
			logger.info("data insert: " + st.getId() + ", " + st.getName());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean updateStudent(Student st) {
		try {
			studentDAO.saveOrUpdate(st);
			logger.info("data update: " + st.getId() + ", " + st.getName());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteStudent(Student st) {
		try {
			logger.info("data insert: " + st.getId() + ", " + st.getName());
			studentDAO.delete(st);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
}
