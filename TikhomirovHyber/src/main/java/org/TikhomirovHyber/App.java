package org.TikhomirovHyber;



import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import org.TikhomirovHyber.dao.impl.OrderDAOHImpl;

import org.TikhomirovHyber.dao.impl.SortDAOHImpl;
import org.TikhomirovHyber.dao.impl.UserDAOImpl;
import org.TikhomirovHyber.dao.interf.UserDAOH;
import org.TikhomirovHyber.dao.interf.AbstractDAOH;
import org.TikhomirovHyber.dao.interf.GenericDAOH;
import org.TikhomirovHyber.dao.interf.OrderDAOH;
import org.TikhomirovHyber.dao.interf.SortDAOH;
import org.TikhomirovHyber.pojos.Order;
import org.TikhomirovHyber.pojos.Role;
import org.TikhomirovHyber.pojos.Sort;
import org.TikhomirovHyber.pojos.User;
import org.TikhomirovHyber.pojos.UserDetail;
import org.TikhomirovHyber.utils.HibernateUtil;
import org.TikhomirovVO.OrderVO;
import org.TikhomirovVO.RoleVO;
import org.TikhomirovVO.SortVO;
import org.TikhomirovVO.UserVO;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import exceptions.DAOException;

public class App {
	public static void main(String[] args) throws DAOException {
		final Logger logger = Logger.getLogger(App.class.getName());
		
	
		UserDAOH<User> dao=UserDAOImpl.getInstance();
	GenericDAOH orderdao=OrderDAOHImpl.getInstance();
		User user=new User("newlogin", "password");
		UserDetail userDetail=new UserDetail("1235689", "UK","LOndon");
		user.setUserDetail(userDetail);
		userDetail.setUser(user);
		Role role=new Role("Antick");
		Set<Role>roles=new HashSet<>();
		roles.add(role);
		user.setRoles(roles);
		System.out.println(user);
		//dao.add(user);
		User newUser=new User();
		newUser.setUser_id(80);
		//dao.delete(newUser);
		User authUser=dao.getAuthorizedUser("dan","dan");
	//	System.out.println(authUser.getOffers());
		System.out.println(dao.getAll());
		/*
		 * 
		 * Block of adding order*/
		
		User user1=new User("Ben!","Aflek");
		UserDetail userDetail1=new UserDetail("Dallas","USA","000125");
		
		
	Sort sort=new Sort("Light");
	
		user1.setUserDetail(userDetail1);
		userDetail1.setUser(user1);
		
		
		Order order=new Order(555,556);
		order.setUser(user1);
		order.setSort(sort);
	//	orderdao.add(order);
		
	
	}

	
	
}
