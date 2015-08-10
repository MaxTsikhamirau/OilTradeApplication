package by.academy.tikhomirov.service;

import java.sql.SQLException;
import java.util.List;

import by.academy.tikhomirov.entity.Seller;
import by.academy.tikhomirov.implem.SellerDAOImpl;
import by.academy.tikhomirov.interf.GenericDAO;


public class SellerService {

	GenericDAO<Seller> dao = SellerDAOImpl.getInstance();

	public List<Seller> getAll() throws ClassNotFoundException, SQLException {
		return dao.getAll();
	}

	public void create(Seller seller) throws SQLException {
		dao.create(seller);
	}

	public void update(Seller seller) throws SQLException {
		dao.update(seller);
	}

	public void delete(Seller seller) throws SQLException {
		dao.delete(seller);
	}
	
}
