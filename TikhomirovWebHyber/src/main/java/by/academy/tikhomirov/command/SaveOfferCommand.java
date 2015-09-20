package by.academy.tikhomirov.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.TikhomirovServiseHyber.impl.OfferServiseImpl;
import org.TikhomirovServiseHyber.interf.OfferServise;
import org.TikhomirovVO.OfferVO;
import org.TikhomirovVO.SortVO;
import org.TikhomirovVO.UserVO;

public class SaveOfferCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		OfferServise offerService = new OfferServiseImpl();

		SortVO sortVO = new SortVO();
		OfferVO offerVO = new OfferVO();
		UserVO userVO = new UserVO();
		HttpSession session = request.getSession();
		userVO = (UserVO) session.getAttribute("user");
		String sort_name = request.getParameter("sort");
		sortVO.setSort_name(sort_name);
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		Integer price = Integer.parseInt(request.getParameter("price"));

		offerVO.setSortVO(sortVO);
		offerVO.setUserVO(userVO);
		offerVO.setPrice(price);
		offerVO.setQuantity(quantity);
		session.setAttribute("newOffer", offerVO);

		try {
			offerService.add(offerVO);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		GetOffersCommand command = new GetOffersCommand();
		

		return command.execute(request, response);
	}
}
