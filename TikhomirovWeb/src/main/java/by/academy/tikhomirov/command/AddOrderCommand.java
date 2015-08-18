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

public class AddOrderCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		OrderService orderService=OrderService.getInstance();
		Sort sort=new Sort();
		Order order=new Order();
		HttpSession session=request.getSession();
		User user=new User();
		user=(User) session.getAttribute("user");
		int quantity=10256;
		sort.setName(request.getParameter("sort"));
		//int quantity=Integer.parseInt(request.getParameter("quantity"));
		order.setSort(sort);
		order.setUser(user);
		order.setQuantity(quantity);
		try {
			orderService.create(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return "offersListPage.jsp";
	}
	

}
