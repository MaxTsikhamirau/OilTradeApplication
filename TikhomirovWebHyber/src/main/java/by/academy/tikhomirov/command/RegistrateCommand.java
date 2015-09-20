package by.academy.tikhomirov.command;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class RegistrateCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
            
        
        
        return "/WEB-INF/pages/createUserPage.jsp";
    }

	
}
