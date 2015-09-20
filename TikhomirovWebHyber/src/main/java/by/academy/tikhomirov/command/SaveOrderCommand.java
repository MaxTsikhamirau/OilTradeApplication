package by.academy.tikhomirov.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.TikhomirovServiseHyber.impl.OfferServiseImpl;
import org.TikhomirovServiseHyber.impl.OrderServiseImpl;
import org.TikhomirovServiseHyber.interf.OfferServise;
import org.TikhomirovServiseHyber.interf.OrderServise;
import org.TikhomirovVO.OfferVO;
import org.TikhomirovVO.OrderVO;
import org.TikhomirovVO.SortVO;
import org.TikhomirovVO.UserVO;

public class SaveOrderCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		OrderServise orderService = new OrderServiseImpl();

		SortVO sortVO = new SortVO();
		OrderVO orderVO = new OrderVO();
		UserVO userVO = new UserVO();
		HttpSession session = request.getSession();
		userVO = (UserVO) session.getAttribute("user");
		String sort_name = request.getParameter("sort");
		sortVO.setSort_name(sort_name);
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		Integer price = Integer.parseInt(request.getParameter("price"));

		orderVO.setSortVO(sortVO);
		orderVO.setUserVO(userVO);
		orderVO.setPrice(price);
		orderVO.setQuantity(quantity);
		session.setAttribute("newOffer", orderVO);

		try {
			orderService.add(orderVO);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		GetOrdersCommand command = new GetOrdersCommand();
		

		return command.execute(request, response);
	}
}
