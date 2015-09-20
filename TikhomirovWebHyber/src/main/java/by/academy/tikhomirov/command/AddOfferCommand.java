package by.academy.tikhomirov.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class AddOfferCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		
		return "/WEB-INF/pages/addOfferPage.jsp";
	
	

}}
