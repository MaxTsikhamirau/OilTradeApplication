package by.academy.tikhomirov.interf;

import java.sql.SQLException;
import java.util.List;

import by.academy.tikhomirov.entity.Offer;
import by.academy.tikhomirov.entity.User;

public interface CustomUserDAO extends GenericDAO<User> {
	public User getAuthorizedUser(String password) throws SQLException;

	

}
