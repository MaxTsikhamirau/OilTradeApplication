package by.academy.tikhomirov.implem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import by.academy.tikhomirov.entity.Role;
import by.academy.tikhomirov.entity.Seller;
import by.academy.tikhomirov.interf.AbstractDAO;

public class SellerDAOImpl extends AbstractDAO<Seller> {
	private static final SellerDAOImpl instance = new SellerDAOImpl();

	private SellerDAOImpl() {
	}

	public static SellerDAOImpl getInstance() {
		return instance;
	}

	@Override
	public List<Seller> init(ResultSet resultSet) {
		List<Seller> sellers = new ArrayList<Seller>();
		try {
			while (resultSet.next()) {
				Seller seller = new Seller();
				seller.setId(resultSet.getInt("ID"));
				seller.setName(resultSet.getString("name"));
				seller.setLogin(resultSet.getString("login"));
				seller.setPassword(resultSet.getString("password"));
				seller.setCountry(resultSet.getString("country"));
				Role role = new Role();
				role.setID(resultSet.getInt("role_id"));
				role.setName(resultSet.getString("role"));
				seller.setRole(role);
				sellers.add(seller);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sellers;
	}

	@Override
	public void setParameters(String methodName, PreparedStatement preparedStatement, Seller seller)
			throws SQLException {
		if (methodName == "create") {
			Role role = seller.getRole();
			preparedStatement.setString(1, seller.getName());
			preparedStatement.setString(2, seller.getLogin());
			preparedStatement.setString(3, seller.getPassword());
			preparedStatement.setString(4, seller.getCountry());
			preparedStatement.setInt(5, role.getID());
		}
		if (methodName == "delete") {
			preparedStatement.setInt(1, seller.getId());
		}
		if (methodName == "update") {
			//Role role=seller.getRole();
			
			preparedStatement.setString(1, seller.getName());
			preparedStatement.setString(2, seller.getLogin());
			preparedStatement.setString(3, seller.getPassword());
			preparedStatement.setString(4, seller.getCountry());
			//preparedStatement.setInt(5, role.getID());
			preparedStatement.setInt(5, seller.getId());
			
		}	
	}

	@Override
	protected String getQuery(String query) {
		String SQLQuery = query;
		ResourceBundle rb = ResourceBundle.getBundle("sqlquery", Locale.getDefault());
		if (query == "getAll") {
			SQLQuery = rb.getString("sqlsellers.getall");
		}
		if (query == "create") {
			SQLQuery = rb.getString("sqlsellers.create");
		}
		if (query == "delete") {
			SQLQuery = rb.getString("sqlsellers.delete");
		}
		if (query == "update") {
			SQLQuery = rb.getString("sqlsellers.update");
		}
		return SQLQuery;
	}
}
