package by.academy.tikhomirov.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.academy.tikhomirov.entity.Offer;
import by.academy.tikhomirov.entity.Order;
import by.academy.tikhomirov.entity.Sort;
import by.academy.tikhomirov.entity.User;
import by.academy.tikhomirov.service.*;
import by.academy.tikhomirov.service.exception.ServiceException;

public class AddOrderCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		OrderService orderService=new OrderService();
		SortService sortService=new SortService();
		
		Sort sort=new Sort();
		Order order=new Order();
		User user=new User();
		
		HttpSession session=request.getSession();
		user=(User) session.getAttribute("user");
	
		String sortName=request.getParameter("sort");
		
		int sortId=0;
		try {
			sort=sortService.getSortByName(sortName);
			System.out.println(sort);
			sortId=sort.getID();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		sort.setID(sortId);
		sort.setName(sortName);
		
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
		
		order.setSort(sort);
		order.setUser(user);
		order.setQuantity(quantity);
		session.setAttribute("order", order);
		
		try {
			orderService.create(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		OfferService offerService=new OfferService();
		List<Offer>acceptableOffers=null;
		
			try {
				acceptableOffers=offerService.getAcceptableOffers(sortName, quantity);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("acceptableOffers", acceptableOffers);
					
		
		
		
		return "/WEB-INF/pages/acceptableOffersPage.jsp";
	
	

}}
