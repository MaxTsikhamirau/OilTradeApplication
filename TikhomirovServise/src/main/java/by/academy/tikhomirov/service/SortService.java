package by.academy.tikhomirov.service;

import java.sql.SQLException;
import java.util.List;

import by.academy.tikhomirov.entity.Buyer;
import by.academy.tikhomirov.entity.Sort;
import by.academy.tikhomirov.implem.BuyerDAOImpl;
import by.academy.tikhomirov.implem.SortDAOImpl;
import by.academy.tikhomirov.interf.GenericDAO;


public class SortService {

	GenericDAO<Sort> dao = SortDAOImpl.getInstance();

	public List<Sort> getAll() throws ClassNotFoundException, SQLException {
		return dao.getAll();
	}

	public void create(Sort sort) throws SQLException {
		dao.create(sort);
	}

	public void update(Sort sort) throws SQLException {
		dao.update(sort);
	}

	public void delete(Sort sort) throws SQLException {
		dao.delete(sort);
	}
	
}
