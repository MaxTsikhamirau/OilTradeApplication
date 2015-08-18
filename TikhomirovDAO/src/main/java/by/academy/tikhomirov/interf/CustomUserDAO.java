package by.academy.tikhomirov.interf;

import java.sql.SQLException;



import by.academy.tikhomirov.entity.*;

public interface CustomUserDAO extends GenericDAO<User> {
	public User getAuthorizedUser(String password) throws SQLException;

	

}
