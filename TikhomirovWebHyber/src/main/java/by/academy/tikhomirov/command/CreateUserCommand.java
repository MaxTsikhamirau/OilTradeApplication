package by.academy.tikhomirov.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.TikhomirovHyber.dao.interf.UserDAOH;
import org.TikhomirovServiseHyber.impl.OfferServiseImpl;
import org.TikhomirovServiseHyber.impl.UserServiseImpl;
import org.TikhomirovServiseHyber.interf.UserServise;
import org.TikhomirovVO.RoleVO;
import org.TikhomirovVO.UserVO;
import org.apache.log4j.Logger;

import by.academy.tikhomirov.validation.DataValidation;

public class CreateUserCommand implements ActionCommand {
	private static final Logger logger = Logger.getLogger(CreateUserCommand.class.getName());
	String page = null;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		UserServise userServise = new UserServiseImpl();

		UserVO userVO = null;

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String user_name = request.getParameter("name");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String telephone = request.getParameter("telephone");
		Set<RoleVO> rolesVO = new HashSet<>();
		RoleVO roleVO = new RoleVO();
		roleVO.setRole_name("traider");
		rolesVO.add(roleVO);
//		if(		DataValidation.isLogin(login)&&
//				DataValidation.isCity(city)&&
//				DataValidation.isCountry(country)&&
//				DataValidation.isName(user_name)&&
//				DataValidation.isPassword(password)&&
//				DataValidation.isTelephone(telephone)
//				)
//		{
			logger.info("Correct data. User can be created");
			
			try {
				logger.info("Try to add user. Check if user already exists.");
				userVO = userServise.getAuthorizedUser(login, password);
				if (userVO == null) {
					userVO=new UserVO();
					userVO.setCity(city);
					userVO.setCountry(country);
					userVO.setLogin(login);
					userVO.setPassword(password);
					userVO.setTelephone(telephone);
					userVO.setUser_name(user_name);
					userVO.setRolesVO(rolesVO);
					
					
					userServise.add(userVO);
				}
				
				else{
					logger.info("user with such login and(or) password already exists. Try again");
					page="/WEB-INF/pages/loginPage.jsp";}
			}

			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			
			
//		}
//		else{
//			logger.info("Incorrect data. Check the fields");
//			page="/WEB-INF/pages/error.jsp";}
		
		
		return "/WEB-INF/pages/loginPage.jsp";
	}

}
