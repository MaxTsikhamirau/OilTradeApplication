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
import by.academy.tikhomirov.entity.*;


import by.academy.tikhomirov.interf.AbstractDAO;
import by.academy.tikhomirov.interf.CustomOfferDAO;
import utils.ConnectionPool;
import utils.DBUtils;

public class OfferDAOImpl extends AbstractDAO<Offer>implements CustomOfferDAO {
	private static final OfferDAOImpl instance = new OfferDAOImpl();

	private OfferDAOImpl() {
	}

	public static OfferDAOImpl getInstance() {
		return instance;
	}
	public List<Offer> sortByPrice() throws SQLException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Offer> result = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(getQuery("getSortedByPrice"));
			result = init(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement);
		}

		return result;
	}

	public List<Offer> sortByQuantity() throws SQLException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Offer> result = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(getQuery("getSortedByQuantity"));
			result = init(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement);
		}

		return result;
	}

	@Override
	protected String getQuery(String query) {
		String SQLQuery = query;
		ResourceBundle rb = ResourceBundle.getBundle("sqlquery", Locale.getDefault());
		if (query == "getAll") {
			SQLQuery = rb.getString("sqloffers.getall");
		}
		if (query == "create") {
			SQLQuery = rb.getString("sqloffers.create");
		}
		if (query == "delete") {
			SQLQuery = rb.getString("sqloffers.delete");
		}
		if (query == "update") {
			SQLQuery = rb.getString("sqloffers.update");
		}
		if (query == "getSortedByPrice") {
			SQLQuery = rb.getString("sqloffers.getsortedbyprice");
		}
		if (query == "getSortedByQuantity") {
			SQLQuery = rb.getString("sqloffers.getsortedbyquantity");
		}
		return SQLQuery;
	}

	@Override
	protected List<Offer> init(ResultSet resultSet) {
		List<Offer> offers = new ArrayList<Offer>();
		try {
			while (resultSet.next()) {
				Offer offer = new Offer();
				offer.setID(resultSet.getInt("ID"));
				User user = new User();
				user.setName(resultSet.getString("name"));
				offer.setUser(user);
				Sort sort = new Sort();
				sort.setName(resultSet.getString("sort"));
				offer.setSort(sort);
				offer.setQuantity(resultSet.getInt("quantity"));
				offer.setPrice(resultSet.getInt("price"));
				offers.add(offer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return offers;
	}

	@Override
	protected void setParameters(String methodName, PreparedStatement preaparedStatement, Offer offer)
			throws SQLException {
		if (methodName == "create") {
			User user= offer.getUser();
			Sort sort =offer.getSort();

			preaparedStatement.setInt(1, user.getId());
			preaparedStatement.setInt(2, sort.getID());
			preaparedStatement.setInt(3, offer.getQuantity());
			preaparedStatement.setInt(4, offer.getPrice());
		}
		if (methodName == "delete") {
			preaparedStatement.setInt(1, offer.getID());
		}
		if (methodName == "update") {
			User user=new User();
			Sort sort = new Sort();
			preaparedStatement.setInt(1, user.getId());
			preaparedStatement.setInt(2, sort.getID());
			preaparedStatement.setInt(3, offer.getQuantity());
			preaparedStatement.setInt(4, offer.getPrice());
			preaparedStatement.setInt(5, offer.getID());
		}

	}

}
