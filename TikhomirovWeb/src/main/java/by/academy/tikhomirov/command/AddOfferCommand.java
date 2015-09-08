package by.academy.tikhomirov.command;

import java.sql.SQLException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import by.academy.tikhomirov.entity.Offer;
import by.academy.tikhomirov.entity.Sort;
import by.academy.tikhomirov.entity.User;
import by.academy.tikhomirov.service.*;

public class AddOfferCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		OfferService offerService = new OfferService();
				SortService sortService = new SortService();
		Sort sort = new Sort();
		Offer offer = new Offer();
		User user = new User();
		HttpSession session = request.getSession();
		user = (User) session.getAttribute("user");
		String sortName = request.getParameter("sort");
		int sortId = 0;
		try {
			sort = sortService.getSortByName(sortName);
			sortId = sort.getID();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		sort.setID(sortId);
		sort.setName(sortName);

		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int price = Integer.parseInt(request.getParameter("price"));

		offer.setSort(sort);
		offer.setUser(user);
		offer.setQuantity(quantity);
		offer.setPrice(price);
		// session.setAttribute("order", order);

		try {
			offerService.create(offer);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		
		return "/WEB-INF/pages/offersListPage.jsp";
	}
}
