package by.academy.tikhomirov.implem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import by.academy.tikhomirov.entity.Order;
import by.academy.tikhomirov.entity.Sort;
import by.academy.tikhomirov.entity.User;
import by.academy.tikhomirov.exception.DAOException;
import by.academy.tikhomirov.interf.AbstractDAO;


public class OrderDAOImpl extends AbstractDAO<Order> {
	
	private static final OrderDAOImpl instance = new OrderDAOImpl();

	private OrderDAOImpl() {
	}

	public static OrderDAOImpl getInstance() {
		return instance;
	}

	@Override
	protected String getQuery(String query) {
		String SQLQuery = query;
		ResourceBundle rb = ResourceBundle.getBundle("sqlquery", Locale.getDefault());
		if (query == "getAll") {
			SQLQuery = rb.getString("sqlorders.getall");
		}
		if (query == "create") {
			SQLQuery = rb.getString("sqlorders.create");
		}
		if (query == "delete") {
			SQLQuery = rb.getString("sqlorders.delete");
		}
		if (query == "update") {
			SQLQuery = rb.getString("sqlorders.update");
		}
		return SQLQuery;
	}

	@Override
	protected List<Order> init(ResultSet resultSet) {
		List<Order> orders = new ArrayList<Order>();
		try {
			while (resultSet.next()) {
				Order order = new Order();
				order.setID(resultSet.getInt("ID"));
				User user = new User();
				user.setName(resultSet.getString("name"));
				order.setUser(user);
				Sort sort = new Sort();
				sort.setName(resultSet.getString("sort"));
				order.setSort(sort);
				order.setQuantity(resultSet.getInt("quantity"));
				orders.add(order);
				logger.info("Init List of orders");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Failed to init List of orders");
		}
		return orders;
	}

	@Override
	protected void setParameters(String methodName, PreparedStatement preaparedStatement, Order order)
			throws DAOException {
		try {

			if (methodName == "create") {
				User user = order.getUser();
				Sort sort = order.getSort();
				preaparedStatement.setInt(1, user.getId());
				preaparedStatement.setInt(2, sort.getID());
				preaparedStatement.setInt(3, order.getQuantity());
				logger.info("Successful set parameters for " + methodName);
			}
			if (methodName == "delete") {
				preaparedStatement.setInt(1, order.getID());
				logger.info("Successful set parameters for " + methodName);
			}
			if (methodName == "update") {
				User user = new User();
				Sort sort = new Sort();
				preaparedStatement.setInt(1, user.getId());
				preaparedStatement.setInt(2, sort.getID());
				preaparedStatement.setInt(3, order.getQuantity());
				preaparedStatement.setInt(4, order.getID());
				logger.info("Successful set parameters for " + methodName);
			}
		} catch (SQLException e) {
			logger.error("Failed to set parameters");
			throw new DAOException("Failed to set parameters");

		}
	}
}
