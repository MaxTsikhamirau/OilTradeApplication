//package daotest;
//import java.sql.SQLException;
//
//import javax.jws.soap.SOAPBinding.Use;
//
//import by.academy.tikhomirov.entity.Offer;
//import by.academy.tikhomirov.entity.Order;
//import by.academy.tikhomirov.entity.Role;
//import by.academy.tikhomirov.entity.Sort;
//import by.academy.tikhomirov.entity.User;
//import by.academy.tikhomirov.implem.OfferDAOImpl;
//import by.academy.tikhomirov.implem.OrderDAOImpl;
//import by.academy.tikhomirov.implem.SortDAOImpl;
//import by.academy.tikhomirov.implem.UserDAOImpl;
//import by.academy.tikhomirov.interf.CustomOfferDAO;
//import by.academy.tikhomirov.interf.CustomUserDAO;
//import by.academy.tikhomirov.interf.GenericDAO;
//
//public class Testingclass {
//
//	public static void main(String[] args) throws SQLException {
//		// TODO Auto-generated method stub
//
////		CustomUserDAO userdao=UserDAOImpl.getInstance();
////		System.out.println(userdao.getAll());
////		User user=new User();
////		user.setId(7);
////		userdao.delete(user);
////		System.out.println("After delete");
////		System.out.println(userdao.getAll());
////		System.out.println("Adding a user");
////		User addUser=new User();
////		Role addRole=new Role();
////		addRole.setID(1);
////		addRole.setName("buyer");
////		addUser.setCountry("Gonduras");
////		addUser.setLogin("mixaly4");
////		addUser.setName("Mikel");
////		addUser.setPassword("12224");
////		addUser.setRole(addRole);
////		userdao.create(addUser);
////		User updUser=new User();
////		addRole.setID(11);
////		addRole.setName("buyer");
////		updUser.setCountry("Gonduras");
////		updUser.setLogin("andreich");
////		updUser.setName("Andrey");
////		updUser.setPassword("000000");
////		updUser.setRole(addRole);
////		updUser.setId(10);
////		//userdao.update(updUser);
////		
////		
////		//System.out.println("Get user be password");
////		//user=userdao.getAuthorizedUser("12346");
////	//	System.out.println("authorixed user "+user);
////		
//		
////		System.out.println("Get offers");
////		OfferDAOImpl offerDAOImpl=OfferDAOImpl.getInstance();
////		System.out.println(offerDAOImpl.getAll());
////		
////		SortDAOImpl sortDAOImpl=SortDAOImpl.getInstance();
////		Sort sort=sortDAOImpl.getSortByName("Maxmark3");
////		System.out.println(sort);
//		
////		GenericDAO orderDao=OrderDAOImpl.getInstance();
////		Order order=new Order();
////		Sort sort=new Sort();
////		User user=new User();
////		user.setId(10);
////		sort.setID(4);
////		int quantity=23456789;
////		order.setUser(user);
////		order.setSort(sort);
////		order.setQuantity(quantity);
////		orderDao.create(order);
////		System.out.println(order);
////		System.out.println("All orders");
////		System.out.println(orderDao.getAll());
//	}
//
//}
