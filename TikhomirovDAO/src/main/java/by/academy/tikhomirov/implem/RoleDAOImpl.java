package by.academy.tikhomirov.implem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;



import by.academy.tikhomirov.entity.*;
import by.academy.tikhomirov.exception.DAOException;
import by.academy.tikhomirov.interf.AbstractDAO;
import by.academy.tikhomirov.interf.CustomRoleDAO;

import utils.ConnectionPool;


public class RoleDAOImpl extends AbstractDAO<Role>implements CustomRoleDAO {
	
	private static final RoleDAOImpl instance = new RoleDAOImpl();

	private RoleDAOImpl() {
	}

	public static RoleDAOImpl getInstance() {
		return instance;
	}

	@Override
	protected void setParameters(String methodName, PreparedStatement preaparedStatement, Role role) throws DAOException
			 {
		try {
			if (methodName == "create") {
				preaparedStatement.setString(1, role.getName());
				logger.info("Successful set parameters for " + methodName);
			}
			if (methodName == "delete") {
				preaparedStatement.setInt(1, role.getID());
				logger.info("Successful set parameters for " + methodName);
			}
			if (methodName == "update") {
				preaparedStatement.setString(1, role.getName());
				preaparedStatement.setInt(2, role.getID());
				logger.info("Successful set parameters for " + methodName);
			}
		} catch (SQLException e) {
			logger.error("Failed to set parameters");
			throw new DAOException("Failed to set parameters");
		}
	}

	@Override
	protected String getQuery(String query) {
		String SQLQuery = query;
		ResourceBundle rb = ResourceBundle.getBundle("sqlquery", Locale.getDefault());
		if (query == "getAll") {
			SQLQuery = rb.getString("sqlroles.getall");
		}
		if (query == "create") {
			SQLQuery = rb.getString("sqlroles.create");
		}
		if (query == "delete") {
			SQLQuery = rb.getString("sqlroles.delete");
		}
		if (query == "update") {
			SQLQuery = rb.getString("sqlroles.update");
		}
		if (query == "getRoleIDByName") {
			SQLQuery = rb.getString("sqlroles.getRoleIDByName");
		}
		return SQLQuery;
	}

	@Override
	protected List<Role> init(ResultSet resultSet) {
		List<Role> roles = new ArrayList<Role>();
		try {
			while (resultSet.next()) {
				Role role = new Role();
				role.setID(resultSet.getInt("role_id"));
				role.setName(resultSet.getString("role"));
				roles.add(role);
				logger.info("Init list of roles");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Failed to init list of roles");
		}
		return roles;
	}

	public Role getRoleByName(String name) throws DAOException {
		Connection connection = null;
		PreparedStatement preStatement = null;
		ResultSet resultSet = null;
		Role role = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			preStatement = connection.prepareStatement(getQuery("getRoleIDByName"));
			preStatement.setString(1, name);
			resultSet = preStatement.executeQuery();
			role = initRole(resultSet, name);
			logger.info("Successful getRoleByName");

		} catch (SQLException e) {
			logger.error("Failed to get role by name");
			throw new DAOException("Failed to get role by name");
		}
		return role;
	}

	private Role initRole(ResultSet resultSet, String name) {
		Role role = null;
		try {
			while (resultSet.next()) {
				role = new Role();
				role.setID(resultSet.getInt("role_id"));
				role.setName(name);
				logger.info("Successful initRole");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Failed to init role");
		}
		return role;
	}
}
