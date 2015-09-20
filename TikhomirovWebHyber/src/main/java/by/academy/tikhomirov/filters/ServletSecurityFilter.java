package by.academy.tikhomirov.filters;

import java.io.IOException;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.academy.tikhomirov.commandEnum.CommandEnum;

public class ServletSecurityFilter implements Filter {
	private FilterConfig fConfig;
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		String commandType = req.getParameter("command");
		if (commandType == null) {
			resp.sendRedirect("/WEB-INF/pages/error.jsp");
		} else {
			commandType = commandType.toUpperCase();
			Set<String> roles = ((Set<String>) req.getSession().getAttribute("roles"));

			switch (CommandEnum.valueOf(commandType)) {
			case LOGIN:
				chain.doFilter(req, resp);
				break;
			case GETOFFERS:
				if (roles.contains("traider")) {
					chain.doFilter(req, resp);
				} else {
					resp.sendRedirect("/WEB-INF/pages/loginPage.jsp");
				}
				break;
			case GETORDERS:
				if (roles.contains("traider")) {
					chain.doFilter(req, resp);
				} else {
					resp.sendRedirect("/WEB-INF/pages/loginPage.jsp");
				}
				break;
			case ADDORDER:
				if (roles.contains("traider")) {
					chain.doFilter(req, resp);
				} else {
					resp.sendRedirect("/WEB-INF/pages/loginPage.jsp");
				}
				break;
			case ADDOFFER:
				if (roles.contains("traider")) {
					chain.doFilter(req, resp);
				} else {
					resp.sendRedirect("/WEB-INF/pages/loginPage.jsp");
				}
				break;
			case CREATEUSER:
				chain.doFilter(req, resp);
				break;
			case REGISTRATE:
				chain.doFilter(req, resp);
				break;
			case DELETEUSER:
				if (roles.contains("admin")) {
					chain.doFilter(req, resp);
				} else {
					resp.sendRedirect("/WEB-INF/pages/loginPage.jsp");
				}

			default:
				resp.sendRedirect("/WEB-INF/pages/loginPage.jsp");
				break;
			}
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;

	}

}
