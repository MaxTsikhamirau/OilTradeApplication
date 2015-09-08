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
import by.academy.tikhomirov.interf.CustomSortDAO;

import utils.ConnectionPool;

public class SortDAOImpl extends AbstractDAO<Sort>implements CustomSortDAO {

	private static final SortDAOImpl instance = new SortDAOImpl();

	private SortDAOImpl() {
	}

	public static SortDAOImpl getInstance() {
		return instance;
	}

	@Override
	protected void setParameters(String methodName, PreparedStatement preaparedStatement, Sort sort)
			throws DAOException {
		try {
			if (methodName == "create") {
				preaparedStatement.setString(1, sort.getName());
				logger.info("Successful set parameters for " + methodName);
			}
			if (methodName == "delete") {
				preaparedStatement.setInt(1, sort.getID());
				logger.info("Successful set parameters for " + methodName);
			}
			if (methodName == "update") {
				preaparedStatement.setString(1, sort.getName());
				preaparedStatement.setInt(2, sort.getID());
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
			SQLQuery = rb.getString("sqlsorts.getall");
		}
		if (query == "create") {
			SQLQuery = rb.getString("sqlsorts.create");
		}
		if (query == "delete") {
			SQLQuery = rb.getString("sqlsorts.delete");
		}
		if (query == "update") {
			SQLQuery = rb.getString("sqlsorts.update");
		}
		if (query == "getSortByName") {
			SQLQuery = rb.getString("sqlsorts.getSortByName");
		}
		return SQLQuery;
	}

	@Override
	protected List<Sort> init(ResultSet resultSet) {
		List<Sort> sorts = new ArrayList<Sort>();
		try {
			while (resultSet.next()) {
				Sort sort = new Sort();
				sort.setID(resultSet.getInt("sort_id"));
				sort.setName(resultSet.getString("sort"));
				sorts.add(sort);
				logger.info("Successful list of sort init");
			}
		} catch (SQLException e) {
			logger.error("Failed to get list of sort");
		}
		return sorts;
	}

	@Override
	public Sort getSortByName(String name) throws DAOException {
		Connection connection = null;
		PreparedStatement preStatement = null;
		ResultSet resultSet = null;
		Sort sort = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			preStatement = connection.prepareStatement(getQuery("getSortByName"));
			preStatement.setString(1, name);
			resultSet = preStatement.executeQuery();
			sort = initSort(resultSet, name);
			logger.info("Successful get sort by name");
		} catch (SQLException e) {
			logger.error("Failed to get sort by name");
			throw new DAOException("Failed to get sort by name");
		}
		return sort;
	}

	private Sort initSort(ResultSet resultSet, String name) {
		Sort sort = null;
		try {
			while (resultSet.next()) {
				sort = new Sort();
				sort.setID(resultSet.getInt("sort_id"));
				sort.setName(name);
				logger.info("Successful sort init");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Failed to get sort");
		}
		return sort;
	}
}
