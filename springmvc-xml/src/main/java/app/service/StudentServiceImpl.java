package app.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.AddressDAO;
import app.dao.StudentDAO;
import app.model.Student;

@Service("studentService")
@Transactional(readOnly=true)
public class StudentServiceImpl implements StudentService {
	private static final Logger logger = Logger.getLogger(StudentServiceImpl.class);

	@Autowired
	StudentDAO studentDAO;
	@Autowired
	AddressDAO addressDAO;

	public Student findById(Integer id) {
		return studentDAO.getFindById(id);
	}

	@Transactional(readOnly=true)
	public boolean deleteStudent(Integer id) {
		try {
			Student st = studentDAO.getFindById(id);
			if (st == null) {
				return false;
			}

			studentDAO.delete(st);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Student findByEmail(String email) {
		return studentDAO.findByEmail(email);
	}

	@Override
	public List<Student> searchSt(String name, int gender) {
		return studentDAO.searchStudentUsingCretial(name, gender);
	}

	@Override
	public List<Student> getListStudent() {
		return studentDAO.getListStudent();
	}

	@Override
	@Transactional(readOnly=false)
	public boolean saveOrUpdate(Student st) {
		logger.info("data insert: " + st.getId() + ", " + st.getName());
		try {
			addressDAO.saveOrUpdate(st.getAddress());
			studentDAO.saveOrUpdate(st);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
