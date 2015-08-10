package by.academy.tikhomirov.implem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import by.academy.tikhomirov.entity.Buyer;
import by.academy.tikhomirov.entity.Role;
import by.academy.tikhomirov.interf.AbstractDAO;

public class BuyerDAOImpl extends AbstractDAO<Buyer> {
	private static final BuyerDAOImpl instance = new BuyerDAOImpl();

	private BuyerDAOImpl() {
	}

	public static BuyerDAOImpl getInstance() {
		return instance;
	}

	@Override
	protected void setParameters(String methodName, PreparedStatement preaparedStatement, Buyer buyer)
			throws SQLException {
		if (methodName == "create") {
			Role role = buyer.getRole();
			preaparedStatement.setString(1, buyer.getName());
			preaparedStatement.setString(2, buyer.getLogin());
			preaparedStatement.setString(3, buyer.getPassword());
			preaparedStatement.setString(4, buyer.getCountry());
			preaparedStatement.setInt(5, role.getID());
		}
		if (methodName == "delete") {
			preaparedStatement.setInt(1, buyer.getId());
		}
		if (methodName == "update") {
			preaparedStatement.setString(1, buyer.getName());
			preaparedStatement.setString(2, buyer.getLogin());
			preaparedStatement.setString(3, buyer.getPassword());
			preaparedStatement.setString(4, buyer.getCountry());
			preaparedStatement.setInt(5, buyer.getId());
		}
	}

	@Override
	protected String getQuery(String query) {
		String SQLQuery = query;
		ResourceBundle rb = ResourceBundle.getBundle("sqlquery", Locale.getDefault());
		if (query == "getAll") {
			SQLQuery = rb.getString("sqlbuyers.getall");
		}
		if (query == "create") {
			SQLQuery = rb.getString("sqlbuyers.create");
		}
		if (query == "delete") {
			SQLQuery = rb.getString("sqlbuyers.delete");
		}
		if (query == "update") {
			SQLQuery = rb.getString("sqlbuyers.update");
		}
		return SQLQuery;
	}

	@Override
	protected List<Buyer> init(ResultSet resultSet) {
		List<Buyer> buyers = new ArrayList<Buyer>();
		try {
			while (resultSet.next()) {
				Buyer buyer = new Buyer();
				buyer.setId(resultSet.getInt("ID"));
				buyer.setName(resultSet.getString("name"));
				buyer.setLogin(resultSet.getString("login"));
				buyer.setPassword(resultSet.getString("password"));
				buyer.setCountry(resultSet.getString("country"));
				Role role = new Role();
				role.setID(resultSet.getInt("role_id"));
				role.setName(resultSet.getString("role"));
				buyer.setRole(role);
				buyers.add(buyer);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buyers;
	}

}
