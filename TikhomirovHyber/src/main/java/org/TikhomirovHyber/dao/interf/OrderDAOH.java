package org.TikhomirovHyber.dao.interf;


import java.util.Set;

import org.TikhomirovHyber.pojos.User;

import exceptions.DAOException;

public interface OrderDAOH<T> extends GenericDAOH<T> {
	public Set<T> getOrdersByUser(User user) throws DAOException;
	
}
