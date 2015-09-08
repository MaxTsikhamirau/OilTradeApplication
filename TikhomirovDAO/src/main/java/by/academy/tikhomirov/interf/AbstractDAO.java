package by.academy.tikhomirov.interf;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.apache.logging.log4j.*;

import by.academy.tikhomirov.exception.DAOException;

import utils.ConnectionPool;
import utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class AbstractDAO<T> implements GenericDAO<T> {
		public Logger logger = LogManager.getLogger(AbstractDAO.class.getName());

	public List<T> getAll() throws DAOException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<T> result = null;

		try {
			logger.info("Trying to get connection");
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(getQuery("getAll"));
			result = init(resultSet);
		} catch (SQLException e) {
			logger.error("Connection failed (method getAll). Check resourse");
			throw new DAOException("Connection failed (method GetAll). Check resourses");
		} finally {
			DBUtils.close(connection, statement);
		}
		return result;
	}

	public void create(T object) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(getQuery("create"));
			setParameters("create", statement, object);
			logger.info("Create object successully " + object);
			statement.executeUpdate();
		} catch (SQLException e) {
			logger.error("Can't create object" + object + " Method create");
			throw new DAOException("Can't create object" + object);
		} finally {
			DBUtils.close(connection, statement);
		}
	}

	public void delete(T object) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(getQuery("delete"));
			setParameters("delete", statement, object);
			statement.executeUpdate();
			logger.info("Delete object successully" + object);
		} catch (SQLException e) {
			logger.error("Can't delete object" + object);
			throw new DAOException("Can't delete object" + object);
		} finally {
			DBUtils.close(connection, statement);
		}
	}

	public void update(T object) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(getQuery("update"));
			setParameters("update", statement, object);
			statement.executeUpdate();
			logger.info("Update object successully " + object);
		} catch (SQLException e) {
			logger.error("Can't update object" + object);
			throw new DAOException("Can't update object" + object);
		} finally {
			DBUtils.close(connection, statement);
		}
	};

	protected abstract void setParameters(String methodName, PreparedStatement preaparedStatement, T object)
			throws DAOException;

	protected abstract String getQuery(String query) throws DAOException;

	protected abstract List<T> init(ResultSet resultSet) throws DAOException;

}
