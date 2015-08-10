package by.academy.tikhomirov.implem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import by.academy.tikhomirov.entity.Role;
import by.academy.tikhomirov.entity.Seller;
import by.academy.tikhomirov.entity.User;
import by.academy.tikhomirov.interf.AbstractDAO;
import by.academy.tikhomirov.interf.CustomUserDAO;
import utils.ConnectionPool;
import utils.DBUtils;

public class UserDAOImpl extends AbstractDAO<User>implements CustomUserDAO {
	private static final UserDAOImpl instance = new UserDAOImpl();

	private UserDAOImpl() {
	}

	public static UserDAOImpl getInstance() {
		return instance;
	}

	@Override
	public List<User> init(ResultSet resultSet) {
		List<User> users = new ArrayList<User>();
		try {
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("ID"));
				user.setName(resultSet.getString("name"));
				user.setLogin(resultSet.getString("login"));
				user.setPassword(resultSet.getString("password"));
				user.setCountry(resultSet.getString("country"));
				Role role = new Role();
				role.setID(resultSet.getInt("role_id"));
				role.setName(resultSet.getString("role"));
				user.setRole(role);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public void setParameters(String methodName, PreparedStatement preparedStatement, User user) throws SQLException {
		if (methodName == "create") {
			Role role = user.getRole();
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getLogin());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getCountry());
			preparedStatement.setInt(5, role.getID());
		}
		if (methodName == "delete") {
			preparedStatement.setInt(1, user.getId());
		}
		if (methodName == "update") {
			// Role role=seller.getRole();

			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getLogin());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getCountry());
			// preparedStatement.setInt(5, role.getID());
			preparedStatement.setInt(5, user.getId());

		}
		if (methodName == "delete") {
			preparedStatement.setInt(1, user.getId());
		}
	}

	@Override
	protected String getQuery(String query) {
		String SQLQuery = query;
		ResourceBundle rb = ResourceBundle.getBundle("sqlquery", Locale.getDefault());
		if (query == "getAll") {
			SQLQuery = rb.getString("sqlusers.getall");
		}
		if (query == "create") {
			SQLQuery = rb.getString("sqlusers.create");
		}
		if (query == "delete") {
			SQLQuery = rb.getString("sqlusers.delete");
		}
		if (query == "update") {
			SQLQuery = rb.getString("sqlusers.update");
		}
		if (query == "getAuthorizedUser") {
			SQLQuery = rb.getString("sqlusers.getAuthorizedUser");
		}
		return SQLQuery;
	}

	public User getAuthorizedUser(String password) throws SQLException {
		Connection connection = null;
		PreparedStatement preStatement = null;
		ResultSet resultSet = null;
		List<User> users = null;
		User user = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			preStatement = connection.prepareStatement(getQuery("getAuthorizedUser"));
			setParameters("getAuthorizedUser", preStatement, user);
			resultSet = preStatement.executeQuery();
			user = initUser(resultSet, user);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, preStatement);
		}
		return user;
	}

	public User initUser(ResultSet resultSet, User user) {
		try {
			while (resultSet.next()) {
				user.setId(resultSet.getInt("ID"));
				user.setName(resultSet.getString("name"));
				user.setLogin(resultSet.getString("login"));
				user.setPassword(resultSet.getString("password"));
				user.setCountry(resultSet.getString("country"));
				Role role = new Role();
				role.setID(resultSet.getInt("role_id"));
				role.setName(resultSet.getString("role"));
				user.setRole(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
