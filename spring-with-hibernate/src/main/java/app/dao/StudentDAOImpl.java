package app.dao;

import org.apache.log4j.Logger;
import org.hibernate.query.Query;

import app.model.Student;

@SuppressWarnings("serial")
public class StudentDAOImpl extends GenericDAO<Integer, Student> implements StudentDAO {
	private static final Logger logger = Logger.getLogger(StudentDAOImpl.class);

	@Override
	public Student findByEmail(String email) {
		logger.info("email: " + email);
		return (Student) getSession().createQuery("FROM Student where email = ?").setParameter(0, email).uniqueResult();
		
//		 String hql = "from Student where email = :email";
//		
//		 Query query = getSession().createQuery(hql);
//		 query.setParameter("email", email);
//		 return (Student) query.getSingleResult();

		// return (Student) getSession().createQuery(hql)
		// .setString("email", email)
		// .uniqueResult();
	}
}
