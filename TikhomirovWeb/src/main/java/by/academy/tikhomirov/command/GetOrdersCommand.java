package by.academy.tikhomirov.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.academy.tikhomirov.entity.Offer;
import by.academy.tikhomirov.entity.Order;
import by.academy.tikhomirov.service.*;

public class GetOrdersCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		OrderService orderService=OrderService.getInstance();
	
		List<Order>orders=new ArrayList<>();
		try {
			orders=orderService.getAll();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("ordersList", orders);
		
		
		return "ordersListPage.jsp";
	}
	

}
