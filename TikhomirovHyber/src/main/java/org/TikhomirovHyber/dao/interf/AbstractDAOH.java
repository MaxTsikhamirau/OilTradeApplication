package org.TikhomirovHyber.dao.interf;

import java.util.List;
import javax.persistence.PersistenceException;
import org.TikhomirovHyber.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import exceptions.DAOException;

public abstract class AbstractDAOH<T> implements GenericDAOH<T> {

	private static final Logger logger = Logger.getLogger(AbstractDAOH.class.getName());
	private Session session = null;
	private Transaction tx = null;
	private SessionFactory sessionFactory = null;

	@Override
	public void add(T object) throws DAOException {
		logger.info("Start creating object");
		try {
			logger.debug("Creating session");
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			logger.debug("Starting transaction");
			tx = session.beginTransaction();
			session.save(object);
			tx.commit();
			logger.debug("Transaction is complete");
		} catch (PersistenceException e) {
			tx.rollback();
			logger.error("Failed to add object " + object);
			throw new DAOException("Add object: failed" + object, e);
		} finally {
			session.close();
		}

	}

	// public abstract Object transformVOtoPOJO(T object);

	@Override
	public List<T> getAll() throws DAOException {
		logger.info("Start getting List of objects");
		Session session = null;
		Transaction tx = null;
		List<T> objects = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			objects = session.createQuery(getQuery()).list();
			logger.debug("Get list of objects: success");
			tx.commit();
			logger.info("Get list of objects: " + objects);
		} catch (PersistenceException e) {
			tx.rollback();
			logger.error("Failed to get List of objects!");
			throw new DAOException("Get List of objects: failed", e);
		} finally {
			session.close();
		}
		return objects;
	}

	public abstract String getQuery();

	@Override
	public void delete(T object) throws DAOException {
		logger.info("Start deleting object: " + object);
		Session session = null;
		Transaction tx = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			object = (T) session.get(getObjectClass(), getId(object));
			logger.debug("Object to delete: " + object);
			if (object != null) {
				session.delete(object);
				logger.info("Object " + object + " is deleted");
			}
			else{
				logger.info("Object " + object + " can't be deleted. Doesn't exist");
			}
			tx.commit();
			
		} catch (PersistenceException e) {
			tx.rollback();
			logger.error("Failed to delete object!");
			throw new DAOException("Delete object: failed", e);
		} finally {
			session.close();
		}
	}

	@Override
	public void update(T object) throws DAOException {
		// TODO Auto-generated method stub
	}

	@Override
	public Object getById(T object) throws DAOException {
		logger.info("Start getting by ID");
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Integer Id = (Integer) getId(object);
			object = (T) session.get(getObjectClass(), Id);
			logger.debug("Get object by ID:success: " + object);
			tx.commit();
		} catch (PersistenceException e) {
			tx.rollback();
			logger.error("Failed to get object " + object + " by ID!");
			throw new DAOException("Get object " + object + "  by ID: failed", e);
		} finally {
			session.close();
		}
		return object;
	}

	public abstract Class<?> getObjectClass();

	public abstract Integer getId(T object);

}
