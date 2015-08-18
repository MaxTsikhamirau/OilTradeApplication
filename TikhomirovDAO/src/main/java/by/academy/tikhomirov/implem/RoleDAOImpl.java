package by.academy.tikhomirov.implem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import by.academy.tikhomirov.entity.*;
import by.academy.tikhomirov.interf.AbstractDAO;

public class RoleDAOImpl extends AbstractDAO<Role> {
	private static final RoleDAOImpl instance = new RoleDAOImpl();

	private RoleDAOImpl() {
	}

	public static RoleDAOImpl getInstance() {
		return instance;
	}

	@Override
	protected void setParameters(String methodName, PreparedStatement preaparedStatement, Role role)
			throws SQLException {
		if (methodName == "create") {
			preaparedStatement.setString(1, role.getName());
		}
		if (methodName == "delete") {
			preaparedStatement.setInt(1, role.getID());
		}
		if (methodName == "update") {
			preaparedStatement.setString(1, role.getName());
			preaparedStatement.setInt(2, role.getID());
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roles;
	}

}
