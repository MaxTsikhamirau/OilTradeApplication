package by.academy.tikhomirov.interf;

import java.util.List;

import by.academy.tikhomirov.exception.DAOException;


public interface GenericDAO<T> {

	public void create(T object) throws DAOException;

	public List<T> getAll() throws DAOException;

	public void delete(T object) throws DAOException;

	public void update(T object) throws DAOException;

}
