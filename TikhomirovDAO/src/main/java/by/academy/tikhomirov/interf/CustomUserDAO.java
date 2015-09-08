package by.academy.tikhomirov.interf;

import by.academy.tikhomirov.entity.*;
import by.academy.tikhomirov.exception.DAOException;


public interface CustomUserDAO extends GenericDAO<User> {
	public User getAuthorizedUser(String login, String password) throws DAOException;

}
