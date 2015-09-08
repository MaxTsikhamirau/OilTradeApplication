package by.academy.tikhomirov.service;


import java.util.List;
import by.academy.tikhomirov.entity.*;
import by.academy.tikhomirov.exception.DAOException;
import by.academy.tikhomirov.implem.OrderDAOImpl;
import by.academy.tikhomirov.interf.GenericDAO;
import by.academy.tikhomirov.service.exception.ServiceException;

public class OrderService {

	GenericDAO<Order> dao = OrderDAOImpl.getInstance();

	public List<Order> getAll() throws ServiceException {
		try {
			return dao.getAll();
		} catch (DAOException e) {
			throw new ServiceException("Servise GETALL method exception");
		}
	}

	public void create(Order order) throws ServiceException {
		try {
			dao.create(order);
		} catch (DAOException e) {
			throw new ServiceException("Servise CREATE method exception");
		}
	}

	public void update(Order order) throws ServiceException {
		try {
			dao.update(order);
		} catch (DAOException e) {
			throw new ServiceException("Servise UPDATE method exception");
		}
	}

	public void delete(Order order) throws ServiceException {
		try {
			dao.delete(order);
		} catch (DAOException e) {
			throw new ServiceException("Servise DELETE method exception");
		}
	}

}
