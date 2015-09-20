package by.academy.tikhomirov.command;


import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.TikhomirovServiseHyber.exception.ServiseException;
import org.TikhomirovServiseHyber.impl.UserServiseImpl;
import org.TikhomirovServiseHyber.interf.UserServise;
import org.TikhomirovVO.RoleVO;
import org.TikhomirovVO.UserVO;

public class LogInCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = null;
		UserVO userVO = null;
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		UserServise userServise = new UserServiseImpl();
		try {

			userVO = userServise.getAuthorizedUser(login, password);
			if (userVO != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", userVO);
				Set<RoleVO> rolesVO = userVO.getRolesVO();
				session.setAttribute("roles", rolesVO);
				for (RoleVO role : rolesVO) {
					if (role.getRole_name().equals("traider")) {
						page = "/WEB-INF/pages/traiderGreetingPage.jsp";
					}
					if (role.getRole_name().equals("admin")) {
						page = "/WEB-INF/pages/adminPage.jsp";
						break;
					}
				}
			}

			else {
				page = "/WEB-INF/pages/error.jsp";
			}

		}

		catch (ServiseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return page;
	}

}
