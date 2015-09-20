package by.academy.tikhomirov.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.TikhomirovServiseHyber.exception.ServiseException;
import org.TikhomirovServiseHyber.impl.OfferServiseImpl;
import org.TikhomirovServiseHyber.interf.OfferServise;
import org.TikhomirovVO.OfferVO;



public class GetOffersCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		OfferServise offerService=new OfferServiseImpl();
		List<OfferVO>offersList=new ArrayList<>();
					
				try {
					offersList=offerService.getAll();
				} catch (ServiseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		request.setAttribute("offersList", offersList);
		
		
		return "/WEB-INF/pages/offersListPage.jsp";
	}
	

}
