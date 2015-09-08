package org.TikhomirovHyber.dao.interf;


import exceptions.DAOException;

public interface UserDAOH<T> extends GenericDAOH<T>  {

	public T getAuthorizedUser(String login, String password) throws DAOException;

}
