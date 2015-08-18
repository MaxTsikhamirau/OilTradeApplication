package by.academy.tikhomirov.service;

import java.sql.SQLException;
import java.util.List;

import by.academy.tikhomirov.entity.*;

import by.academy.tikhomirov.implem.UserDAOImpl;
import by.academy.tikhomirov.interf.CustomUserDAO;
import by.academy.tikhomirov.interf.GenericDAO;


public class UserService {
	
	private static final UserService instance = new UserService();

	private UserService() {
	}

	public static UserService getInstance() {
		return instance;
	}

	CustomUserDAO  dao = UserDAOImpl.getInstance();
	
public User getAuthorizedUser(String password) throws ClassCastException,SQLException{
	return dao.getAuthorizedUser(password);
}
	public List<User> getAll() throws ClassNotFoundException, SQLException {
		return dao.getAll();
	}

	public void create(User user) throws SQLException {
				
		dao.create(user);
	}

	public void update(User user) throws SQLException {
		dao.update(user);
	}

	public void delete(User user) throws SQLException {
		dao.delete(user);
	}
	
}
