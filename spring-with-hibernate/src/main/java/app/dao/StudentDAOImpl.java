package app.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
//import org.hibernate.criterion.CriteriaQuery;
//import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import app.model.Student;

/**
 * Note: ibernate 5.2 documentation This appendix covers the legacy Hibernate
 * org.hibernate.Criteria API, which should be considered deprecated.
 */
@SuppressWarnings("serial")
public class StudentDAOImpl extends GenericDAO<Integer, Student> implements StudentDAO {
	private static final Logger logger = Logger.getLogger(StudentDAOImpl.class);

	@Override
	public Student findByEmail(String email) {
		logger.info("email: " + email);
		return (Student) getSession().createQuery("FROM Student where email = ?").setParameter(0, email).uniqueResult();

		// String hql = "from Student where email = :email";
		//
		// Query query = getSession().createQuery(hql);
		// query.setParameter("email", email);
		// return (Student) query.getSingleResult();

		// return (Student) getSession().createQuery(hql)
		// .setString("email", email)
		// .uniqueResult();
	}

	@Override
	public List<Student> searchStudentUsingCretial(String name, int gender) {
		// Version old
		// Criteria cr = getSession().createCriteria(Student.class);
		// if (StringUtils.isNotBlank(name)) {
		// cr.add(Restrictions.eq("name", name));}
		// if (StringUtils.isNotBlank(gender.toString())) {
		// cr.add(Restrictions.eq("gender", gender));}
		// return cr.list();
		// End
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Student> cr = builder.createQuery(Student.class);
		Root<Student> root = cr.from(Student.class);
		// Dùng where như bên dưới khi mà chắc chắn rằng 2 pramram luôn khác null nhé
		// cr.select(root).where(
		// builder.like(root.get("name"), "%" + name + "%"),
		// builder.equal(root.get("gender"), gender));
		cr.select(root);
		
		// Tự động bỏ qua dk nếu giá trị param là null
		Predicate nameRestriction = builder.and(builder.like(root.get("name"), "%" + name + "%"));
		Predicate genderRestriction = builder.and(builder.equal(root.get("gender"), gender));

		cr.where(nameRestriction, genderRestriction);
		return getSession().createQuery(cr).getResultList();
	}
}
