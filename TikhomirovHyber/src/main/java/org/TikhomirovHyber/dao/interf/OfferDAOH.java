package org.TikhomirovHyber.dao.interf;

import java.util.Set;


import org.TikhomirovHyber.pojos.User;

import exceptions.DAOException;

public interface OfferDAOH<T> extends GenericDAOH<T>{
	public Set<T> getOffersByUser(User user) throws DAOException;
}
