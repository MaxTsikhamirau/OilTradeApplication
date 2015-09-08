package by.academy.tikhomirov.service;

import java.util.List;
import by.academy.tikhomirov.entity.*;
import by.academy.tikhomirov.exception.DAOException;
import by.academy.tikhomirov.implem.UserDAOImpl;
import by.academy.tikhomirov.interf.CustomUserDAO;
import by.academy.tikhomirov.service.exception.ServiceException;

public class UserService {

	CustomUserDAO dao = UserDAOImpl.getInstance();

	public User getAuthorizedUser(String login, String password) throws ServiceException {
		try {
			return dao.getAuthorizedUser(login, password);
		} catch (DAOException e) {
			throw new ServiceException("Servise GETAUTHORIZEDUSER method exception");
		}
	}

	public List<User> getAll() throws ServiceException {
		try {
			return dao.getAll();
		} catch (DAOException e) {
			throw new ServiceException("Servise GETALL method exception");
		}
	}

	public void create(User user) throws ServiceException {

		try {
			dao.create(user);
		} catch (DAOException e) {
			throw new ServiceException("Servise CREATE method exception");
		}
	}

//	public void update(User user) throws ServiceException {
//		dao.update(user);
//	}
//
//	public void delete(User user) throws ServiceException {
//		dao.delete(user);
//	}

}
