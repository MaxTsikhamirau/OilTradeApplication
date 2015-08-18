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

public class SortDAOImpl extends AbstractDAO<Sort> {

	private static final SortDAOImpl instance = new SortDAOImpl();

	private SortDAOImpl() {
	}

	public static SortDAOImpl getInstance() {
		return instance;
	}

	@Override
	protected void setParameters(String methodName, PreparedStatement preaparedStatement, Sort sort)
			throws SQLException {
		if (methodName == "create") {
			preaparedStatement.setString(1, sort.getName());
		}
		if (methodName == "delete") {
			preaparedStatement.setInt(1, sort.getID());
		}
		if (methodName == "update") {
			preaparedStatement.setString(1, sort.getName());
			preaparedStatement.setInt(2, sort.getID());
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sorts;
	}

}
