package dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.RETURN;

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
	public void delete(int PK) throws SQLException {
		int ID=PK;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(getQuery("delete"));
			setDeleteParameters("delete", statement,PK);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(connection, statement);
		}
	}

		protected abstract void setParameters(String methodName, PreparedStatement preaparedStatement, T object)
			throws SQLException;
		protected abstract void setDeleteParameters(String methodName, PreparedStatement preaparedStatement,int PK)
				throws SQLException;
	protected abstract String getQuery(String query);
	
	protected abstract List<T> init(ResultSet resultSet);

	
}
