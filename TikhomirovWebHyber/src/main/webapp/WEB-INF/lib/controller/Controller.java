package by.academy.tikhomirov.controller;

import by.academy.tikhomirov.actionFactory.*;
import by.academy.tikhomirov.command.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.TikhomirovServiseHyber.impl.UserServiseImpl;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Controller extends javax.servlet.http.HttpServlet {
	private static final Logger logger = Logger.getLogger(Controller.class.getName());
   
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ActionFactory actionFactory = new ActionFactory();
        ActionCommand command = actionFactory.defineCommand(request);
        String page = command.execute(request, response);
        logger.debug("page: "+page);
        try {
            if (!response.isCommitted()) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
                requestDispatcher.forward(request, response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
