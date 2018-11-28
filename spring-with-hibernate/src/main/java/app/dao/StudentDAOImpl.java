package app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import app.model.Student;

@Repository
public class StudentDAOImpl extends HibernateDaoSupport implements StudentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public StudentDAOImpl(SessionFactory sessionfactory) {
		setSessionFactory(sessionfactory);
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public int create(Student st) {
		getSession().saveOrUpdate(st);
		return st.getId();
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
