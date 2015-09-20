package by.academy.tikhomirov.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.TikhomirovHyber.dao.interf.UserDAOH;
import org.TikhomirovServiseHyber.impl.UserServiseImpl;
import org.TikhomirovServiseHyber.interf.UserServise;
import org.TikhomirovVO.RoleVO;
import org.TikhomirovVO.UserVO;

public class DeleteUserCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		UserServise userServise = new UserServiseImpl();

		UserVO userVO = null;

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		try {

			userVO = userServise.getAuthorizedUser(login, password);

			if (userVO == null) {
				Set <RoleVO>rolesVO=new HashSet<>();
				RoleVO roleVO=new RoleVO();
				roleVO.setRole_name("traider");
				rolesVO.add(roleVO);
				userVO = new UserVO();
				userVO.setUser_name(request.getParameter("name"));
				userVO.setLogin(login);
				userVO.setPassword(password);
				userVO.setCountry(request.getParameter("country"));
				userVO.setCity(request.getParameter("city"));
				userVO.setTelephone(request.getParameter("telephone"));
				userVO.setRolesVO(rolesVO);

				userServise.add(userVO);

			}
		}

		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return "/WEB-INF/pages/loginPage.jsp";
	}

}
