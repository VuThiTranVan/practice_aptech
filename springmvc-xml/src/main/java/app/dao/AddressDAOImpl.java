package app.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import app.model.Address;

@SuppressWarnings("serial")
@Repository("addressDAO")
public class AddressDAOImpl extends GenericDAO<Integer, Address> implements AddressDAO {
	public AddressDAOImpl(SessionFactory sessionfactory) {
		setSessionFactory(sessionfactory);
	}
}
