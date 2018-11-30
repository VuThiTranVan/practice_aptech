package app.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import app.model.Student;

/**
 * Note: ibernate 5.2 documentation This appendix covers the legacy Hibernate
 * org.hibernate.Criteria API, which should be considered deprecated.
 */
@SuppressWarnings("serial")
@Repository("studentDAO")
public class StudentDAOImpl extends GenericDAO<Integer, Student> implements StudentDAO {
	private static final Logger logger = Logger.getLogger(StudentDAOImpl.class);

	public StudentDAOImpl(SessionFactory sessionfactory) {
		setSessionFactory(sessionfactory);
	}

	@Override
	public Student findByEmail(String email) {
		logger.info("email: " + email);
		return (Student) getSession().createQuery("FROM Student where email = ?").setParameter(0, email).uniqueResult();
	}

	@Override
	public List<Student> searchStudentUsingCretial(String name, String email) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Student> cr = builder.createQuery(Student.class);
		Root<Student> root = cr.from(Student.class);
		cr.select(root);

		// Tự động bỏ qua dk nếu giá trị param là null
		Predicate nameRestriction = builder.and(builder.like(root.get("name"), "%" + name + "%"));
		Predicate genderRestriction = builder.and(builder.equal(root.get("email"), email));
		
		cr.where(
				nameRestriction, genderRestriction);
		return getSession().createQuery(cr).getResultList();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getListStudent() {
		return getSession().createQuery("from Student").getResultList();
	}
}
