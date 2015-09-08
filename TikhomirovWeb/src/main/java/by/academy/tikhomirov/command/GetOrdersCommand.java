package by.academy.tikhomirov.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.academy.tikhomirov.entity.Offer;
import by.academy.tikhomirov.entity.Order;
import by.academy.tikhomirov.service.*;
import by.academy.tikhomirov.service.exception.ServiceException;

public class GetOrdersCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		OrderService orderService=new OrderService();
	
		List<Order>orders=new ArrayList<>();
		
			try {
				orders=orderService.getAll();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		request.setAttribute("ordersList", orders);
		
		
		return "/WEB-INF/pages/ordersListPage.jsp";
	}
	

}
