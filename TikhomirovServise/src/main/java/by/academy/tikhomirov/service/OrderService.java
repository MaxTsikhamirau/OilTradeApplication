package by.academy.tikhomirov.service;

import java.sql.SQLException;
import java.util.List;
import by.academy.tikhomirov.entity.Order;
import by.academy.tikhomirov.implem.OrderDAOImpl;
import by.academy.tikhomirov.interf.GenericDAO;


public class OrderService {

	GenericDAO<Order> dao = OrderDAOImpl.getInstance();

	public List<Order> getAll() throws ClassNotFoundException, SQLException {
		return dao.getAll();
	}

	public void create(Order order) throws SQLException {
		dao.create(order);
	}

	public void update(Order order) throws SQLException {
		dao.update(order);
	}

	public void delete(Order order) throws SQLException {
		dao.delete(order);
	}
	
}
