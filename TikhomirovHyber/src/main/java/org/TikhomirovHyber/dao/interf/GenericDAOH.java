package org.TikhomirovHyber.dao.interf;

import java.util.List;
import exceptions.DAOException;

public interface GenericDAOH<T> {

	public void add(T object) throws DAOException;

	public List<T> getAll() throws DAOException;

	public void delete(T object) throws DAOException;

	public void update(T object) throws DAOException;

	public Object getById(T object) throws DAOException;

	

}
