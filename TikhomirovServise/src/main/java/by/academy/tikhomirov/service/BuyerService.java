package by.academy.tikhomirov.service;

import java.sql.SQLException;
import java.util.List;

import by.academy.tikhomirov.entity.Buyer;
import by.academy.tikhomirov.implem.BuyerDAOImpl;
import by.academy.tikhomirov.interf.GenericDAO;


public class BuyerService {

	GenericDAO<Buyer> dao = BuyerDAOImpl.getInstance();

	public List<Buyer> getAll() throws ClassNotFoundException, SQLException {
		return dao.getAll();
	}

	public void create(Buyer buyer) throws SQLException {
		dao.create(buyer);
	}

	public void update(Buyer buyer) throws SQLException {
		dao.update(buyer);
	}

	public void delete(Buyer buyer) throws SQLException {
		dao.delete(buyer);
	}
	
}
