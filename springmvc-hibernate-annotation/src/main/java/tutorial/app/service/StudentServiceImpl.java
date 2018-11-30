package tutorial.app.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tutorial.app.dao.StudentDAO;
import tutorial.app.model.Student;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {
	private static final Logger logger = Logger.getLogger(StudentServiceImpl.class);

	@Autowired
	StudentDAO studentDAO;

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Transactional
	public Student findById(Integer id) {
		return studentDAO.getFindById(id);
	}

	@Transactional
	public boolean createStudent(Student st) {
		try {
			studentDAO.saveOrUpdate(st);
			logger.info("data insert: " + st.getId() + ", " + st.getName());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Transactional
	public boolean updateStudent(Student st) {
		try {
			studentDAO.saveOrUpdate(st);
			logger.info("data update: " + st.getId() + ", " + st.getName());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean deleteStudent(Student st) {
		try {
			logger.info("data insert: " + st.getId() + ", " + st.getName());
			studentDAO.delete(st);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public Student findByEmail(String email) {
		return studentDAO.findByEmail(email);
	}

	@Override
	@Transactional
	public List<Student> searchSt(String name, int gender) {
		return studentDAO.searchStudentUsingCretial(name, gender);
	}

	@Override
	@Transactional
	public List<Student> getListStudent() {
		return studentDAO.getListStudent();
	}
}
