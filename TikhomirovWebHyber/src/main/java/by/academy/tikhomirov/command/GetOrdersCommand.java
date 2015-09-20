package by.academy.tikhomirov.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.TikhomirovServiseHyber.exception.ServiseException;
import org.TikhomirovServiseHyber.impl.OfferServiseImpl;
import org.TikhomirovServiseHyber.impl.OrderServiseImpl;
import org.TikhomirovServiseHyber.interf.OfferServise;
import org.TikhomirovServiseHyber.interf.OrderServise;
import org.TikhomirovVO.OfferVO;
import org.TikhomirovVO.OrderVO;



public class GetOrdersCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		OrderServise orderService=new OrderServiseImpl();
		List<OrderVO>ordersList=new ArrayList<>();
		
		try {
			ordersList=orderService.getAll();
		} catch (ServiseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
request.setAttribute("ordersList", ordersList);



		
		
		return "/WEB-INF/pages/ordersListPage.jsp";
	}
	

}
