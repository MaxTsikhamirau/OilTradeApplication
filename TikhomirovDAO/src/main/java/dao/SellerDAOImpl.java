package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import entity.Seller;



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
				seller.setID(resultSet.getInt("ID"));
				seller.setSellerName(resultSet.getString("SellerName"));
				seller.setSellerCountry(resultSet.getString("SellerCountry"));
				seller.setSellerAccount(resultSet.getInt("SellerAccount"));
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
			preparedStatement.setInt(1, seller.getID());
			preparedStatement.setString(2, seller.getSellerName());
			preparedStatement.setString(3, seller.getSellerCountry());
			preparedStatement.setInt(4, seller.getSellerAccount());
		}
		if (methodName == "delete") {
			preparedStatement.setInt(1, seller.getID());

		}

	}

	@Override
	protected String getQuery(String query) {
		String SQLQuery = query;
		ResourceBundle rb = ResourceBundle.getBundle("sqlsellers",Locale.getDefault());
		if (query == "getAll") {
			SQLQuery = rb.getString("sqlsellers.getall");
		}
		if (query == "create") {
			SQLQuery = rb.getString("sqlsellers.create");
		}
		if (query == "delete") {
			SQLQuery = rb.getString("sqlsellers.delete");
		}

		return SQLQuery;
	}

	@Override
	protected void setDeleteParameters(String methodName, PreparedStatement preaparedStatement, int PK)
			throws SQLException {
		preaparedStatement.setInt(1, PK);

	}

}
