package org.TikhomirovServiseHyber.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.TikhomirovHyber.dao.impl.OrderDAOHImpl;
import org.TikhomirovHyber.dao.impl.UserDAOImpl;
import org.TikhomirovHyber.dao.interf.UserDAOH;
import org.TikhomirovHyber.pojos.Order;
import org.TikhomirovHyber.pojos.Sort;
import org.TikhomirovHyber.pojos.User;
import org.TikhomirovHyber.pojos.UserDetail;
import org.TikhomirovServiseHyber.exception.ServiseException;
import org.TikhomirovServiseHyber.interf.OrderServise;
import org.TikhomirovServiseHyber.utils.POJOtoVOTransformation;
import org.TikhomirovServiseHyber.utils.VOtoPOJOTransformation;
import org.TikhomirovVO.OrderVO;
import org.TikhomirovVO.SortVO;
import org.TikhomirovVO.UserVO;
import org.apache.log4j.Logger;

import exceptions.DAOException;

public class OrderServiseImpl implements OrderServise {
	private static final Logger logger = Logger.getLogger(OrderServiseImpl.class.getName());
	OrderDAOHImpl orderdao = OrderDAOHImpl.getInstance();

	@Override
	public void add(OrderVO orderVO) throws ServiseException {
		logger.info("Start adding orderVO: " + orderVO + " to DataBase: ");
		logger.debug("Start transformation orderVO: " + orderVO + " to order");
		Order order = VOtoPOJOTransformation.orderTransform(orderVO);
		logger.debug("Successful transformation from orderVO to order. Transformed order: " + order);
		logger.info("Trying to add order: " + order + " to DataBase");
		try {
			orderdao.add(order);
			logger.info("New order: " + order + " was successfully created");
		} catch (DAOException e) {
			logger.error("Add order: " + order + " to DataBase: failed");
			throw new ServiseException("Add order: " + order + " to DataBase: failed", e);
		}
	}

	@Override
	public List<OrderVO> getAll() throws ServiseException {
		logger.info("Start getting List of orders");
		List<OrderVO> ordersVO = null;
		try {
			List<Order> orders = orderdao.getAll();
			logger.debug("Start transformation List<Order> to List<OrderVO>");
			ordersVO = POJOtoVOTransformation.ordersExtract(orders);
			logger.debug("Successfull transformation List<Order> to List<OrderVO>");
		} catch (DAOException e) {
			logger.error("Getting List of orders: failed");
			throw new ServiseException("Getting List of orders: failed", e);
		}
		logger.info("Successfull getting List of orders");
		return ordersVO;
	}

	@Override
	public void delete(OrderVO orderVO) throws ServiseException {
		logger.info("Start deleting order: " + orderVO);
		Order order=new Order();
		order.setOrder_id(orderVO.getOrder_id());
		System.out.println("order: "+order);
		try {

			if (orderdao.getById(order) != null) {
				orderdao.delete(order);
				logger.info("order: " + order + " was successfully deleted");
			} else {
				logger.info("Warning! Can't delete order. Order wasn't found in DataBase!");
			}
		} catch (DAOException e) {
			logger.error("Delete order: " + order + " from DataBase: failed");
			throw new ServiseException("Delete order: " + order + " from DataBase: failed", e);

		}


	}

	@Override
	public OrderVO getById(OrderVO orderVO) throws ServiseException {
		logger.info("Start getting order by ID: " + orderVO.getOrder_id());
		Order order=new Order();
		order.setOrder_id(orderVO.getOrder_id());
		try {
			order = (Order) orderdao.getById(order);
			logger.info("Get order by ID: " + orderVO.getOrder_id() + " :" + order);
		} catch (DAOException e) {
			logger.error("Get order by ID: " +orderVO.getOrder_id() + " from DataBase: failed");
			throw new ServiseException("Get order by ID: " +orderVO.getOrder_id() + " from DataBase: failed", e);
		}
		orderVO = POJOtoVOTransformation.extract(order);
		User user=order.getUser();
		UserVO userVO=POJOtoVOTransformation.extract(user);
		orderVO.setUserVO(userVO);
		return orderVO;
	}

	@Override
	public Set<OrderVO> getOrdersByUser(UserVO userVO) throws ServiseException {
		logger.info("Start getting order by user: " + userVO);
		User user=new User();
		Set<Order>orders=new HashSet<>();
		Set<OrderVO>ordersVO=new HashSet<>();
		user=VOtoPOJOTransformation.userTransform(userVO);
		try {
			orders=orderdao.getOrdersByUser(user);
			ordersVO=POJOtoVOTransformation.ordersExtract(orders);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ordersVO;
	}

}
