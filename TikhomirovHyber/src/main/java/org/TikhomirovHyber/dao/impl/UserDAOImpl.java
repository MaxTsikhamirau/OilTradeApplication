package org.TikhomirovHyber.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import org.TikhomirovHyber.dao.interf.AbstractDAOH;
import org.TikhomirovHyber.dao.interf.UserDAOH;
import org.TikhomirovHyber.pojos.User;
import org.TikhomirovHyber.utils.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.apache.log4j.Logger;
import exceptions.DAOException;

public class UserDAOImpl extends AbstractDAOH<User>implements UserDAOH<User> {

	private static final Logger logger = Logger.getLogger(UserDAOImpl.class.getName());

	private static UserDAOImpl instance;

	private UserDAOImpl() {
	}

	public static synchronized UserDAOImpl getInstance() {
		if (instance == null) {
			instance = new UserDAOImpl();
		}
		return instance;
	}

	@Override
	public String getQuery() {
		return "FROM User";
	}

	@Override
	public Integer getId(User user) {

		return user.getUser_id();
	}

	@Override
	public Class<User> getObjectClass() {
		return User.class;
	}

	@Override
	public User getAuthorizedUser(String login, String password) throws DAOException {
		logger.info("Start getting Authorized User");
		Session session = null;
		Transaction tx = null;
		User user = null;
		try {
			List<User> users = new ArrayList<>();
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			String hql = "SELECT U FROM User U WHERE U.login=:login AND U.password=:password";
			Query query = session.createQuery(hql);
			query.setParameter("password", password);
			query.setParameter("login", login);
			users = query.list();
			user = users.get(0);
			logger.debug("Get Authorized User: success");
			tx.commit();
			logger.info("Get Authorized User: " + user);
		} catch (PersistenceException e) {
			tx.rollback();
			logger.error("Failed to get Authorized User!");
			throw new DAOException("Get Authorized User: failed", e);
		} finally {
			session.close();
		}
		return user;
	}
}
