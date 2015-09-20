package org.TikhomirovHyber.dao.impl;

import java.util.HashSet;
import java.util.Set;
import org.TikhomirovHyber.dao.interf.AbstractDAOH;
import org.TikhomirovHyber.dao.interf.GenericDAOH;
import org.TikhomirovHyber.dao.interf.OrderDAOH;
import org.TikhomirovHyber.pojos.Order;
import org.TikhomirovHyber.pojos.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import exceptions.DAOException;

public class OrderDAOHImpl extends AbstractDAOH<Order>implements OrderDAOH<Order> {
	public Logger logger = Logger.getLogger(OrderDAOHImpl.class.getName());

	private static OrderDAOHImpl instance;

	private OrderDAOHImpl() {
	}

	public static synchronized OrderDAOHImpl getInstance() {
		if (instance == null) {
			instance = new OrderDAOHImpl();
		}
		return instance;
	}

	@Override
	public String getQuery() {

		return "FROM Order";
	}

	@Override
	public Class<Order> getObjectClass() {
		return Order.class;
	}

	@Override
	public Integer getId(Order order) {
		return order.getOrder_id();
	}

	@Override
	public Set<Order> getOrdersByUser(User user) throws DAOException {
		GenericDAOH<User> userDao = UserDAOImpl.getInstance();
		Set<Order> orders = new HashSet<Order>();
		try {
			System.out.println("hghghg user: "+user);
			User requiredUser = (User) userDao.getById(user);
			System.out.println("required: "+requiredUser);
			orders = requiredUser.getOrders();
		} catch (HibernateException e) {
			logger.error("Failed to get orders by user " + user);
			throw new DAOException("Failed to get orders by user " + user, e);
		}
		return orders;
	}

}
