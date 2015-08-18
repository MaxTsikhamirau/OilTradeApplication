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
        
        
        String password = request.getParameter("password");
             try {
        	UserService userService=UserService.getInstance();             
            User user = userService.getAuthorizedUser(password);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                System.out.println("userrole "+user.getRole().getName());
                 if(user.getRole().getName().equals("buyer")){
                	page = "greetingBuyerPage.jsp";
                }
                else{
                	page = "greetingSellerPage.jsp";
                }
               
            } else {
                page = "error.jsp";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return page;
    }

	
}
