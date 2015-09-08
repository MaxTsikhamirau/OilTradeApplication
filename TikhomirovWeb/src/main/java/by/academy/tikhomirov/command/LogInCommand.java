package by.academy.tikhomirov.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.academy.tikhomirov.entity.User;
import by.academy.tikhomirov.service.UserService;

public class LogInCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        
        
        String login = request.getParameter("login");
        String password = request.getParameter("password");
             try {
        	UserService userService=new UserService();             
            User user = userService.getAuthorizedUser(login, password);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
               // System.out.println("userrole "+user.getRole().getName());
                 if(user.getRole().getName().equals("buyer")){
                	page = "/WEB-INF/pages/greetingBuyerPage.jsp";
                }
                else{
                	page = "/WEB-INF/pages/greetingSellerPage.jsp";
                }
               
            } else {
                page = "/WEB-INF/pages/error.jsp";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return page;
    }

	
}
