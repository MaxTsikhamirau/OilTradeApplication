package org.TikhomirovHyber.dao.impl;

import java.util.HashSet;
import java.util.Set;

import org.TikhomirovHyber.dao.interf.AbstractDAOH;
import org.TikhomirovHyber.dao.interf.GenericDAOH;
import org.TikhomirovHyber.dao.interf.OfferDAOH;
import org.TikhomirovHyber.pojos.Offer;
import org.TikhomirovHyber.pojos.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import exceptions.DAOException;

public class OfferDAOHImpl extends AbstractDAOH<Offer>implements OfferDAOH<Offer> {
	public Logger logger = Logger.getLogger(OfferDAOHImpl.class.getName());

	private static OfferDAOHImpl instance;

	private OfferDAOHImpl() {
	}

	public static synchronized OfferDAOHImpl getInstance() {
		if (instance == null) {
			instance = new OfferDAOHImpl();
		}
		return instance;
	}

	@Override
	public Set<Offer> getOffersByUser(User user) throws DAOException {
		GenericDAOH<User> userDao = UserDAOImpl.getInstance();
		Set<Offer> offers = new HashSet<Offer>();
		try {
			User requiredUser = (User) userDao.getById(user);
			offers = requiredUser.getOffers();
		} catch (HibernateException e) {
			logger.error("Failed to get offers by user " + user);
			throw new DAOException("Failed to get offers by user " + user, e);
		}
		return offers;
	}

	@Override
	public String getQuery() {
		return "FROM Offer";
	}

	@Override
	public Class<Offer> getObjectClass() {
		return Offer.class;
	}

	@Override
	public Integer getId(Offer offer) {
		return offer.getOffer_id();
	}

}
