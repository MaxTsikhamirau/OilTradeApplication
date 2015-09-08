package by.academy.tikhomirov.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.academy.tikhomirov.entity.Offer;
import by.academy.tikhomirov.service.*;
import by.academy.tikhomirov.service.exception.ServiceException;

public class GetOffersCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		OfferService offerService=new OfferService();
		List<Offer>offers=new ArrayList<>();
		
			try {
				offers=offerService.getAll();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		request.setAttribute("offersList", offers);
		
		
		return "/WEB-INF/pages/offersListPage.jsp";
	}
	

}
