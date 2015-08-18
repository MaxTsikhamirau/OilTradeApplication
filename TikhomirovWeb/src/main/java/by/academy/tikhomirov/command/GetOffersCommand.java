package by.academy.tikhomirov.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.academy.tikhomirov.entity.Offer;
import by.academy.tikhomirov.service.*;

public class GetOffersCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		OfferService offerService=OfferService.getInstance();
		List<Offer>offers=new ArrayList<>();
		try {
			offers=offerService.getAll();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("offersList", offers);
		
		
		return "offersListPage.jsp";
	}
	

}
