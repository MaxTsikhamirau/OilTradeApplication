package by.academy.tikhomirov.interf;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import utils.ConnectionPool;
import utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class AbstractDAO<T> implements GenericDAO<T> {

	public List<T> getAll() throws SQLException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<T> result = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(getQuery("getAll"));
			result = init(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement);
		}

		return result;
	}

	public void create(T Object) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(getQuery("create"));
			setParameters("create", statement, Object);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement);
		}
	}

	public void delete(T object) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(getQuery("delete"));
			setParameters("delete", statement, object);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement);
		}
	}

	public void update(T object) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(getQuery("update"));
			setParameters("update", statement, object);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement);
		}
	};

	public Object getById(T object) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		Object result = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(getQuery("getById"));
			setParameters("getById", statement, object);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement);
		}
		return result;
	}

	protected abstract void setParameters(String methodName, PreparedStatement preaparedStatement, T object)
			throws SQLException;

	

	protected abstract String getQuery(String query);

	protected abstract List<T> init(ResultSet resultSet);

}
