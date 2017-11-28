package spring_dataaccess.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import spring_dataaccess.app.model.Student;

public class StudentDAOImpl implements StudentDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int create(Student st) {
		String sql = "INSERT INTO student_tbl (id, name, email, gender) VALUES (?, ?, ?, ?)";
		return jdbcTemplate.update(sql, st.getId(), st.getName(), st.getEmail(), st.getGender());
	}

	public Student update(Student st) {
		// TODO Auto-generated method stub
		return null;
	}

	public Student findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
