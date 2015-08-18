package by.academy.tikhomirov.actionFactory;

import by.academy.tikhomirov.command.*;
import by.academy.tikhomirov.commandEnum.*;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {

    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand actionCommand = null;

        String paramCommand = request.getParameter("command");
        if (paramCommand == null || paramCommand.isEmpty()) {
            return actionCommand;
        }
        CommandEnum commandEnum = CommandEnum.valueOf(paramCommand.toUpperCase());
        actionCommand = commandEnum.getCurrentCommand();
        return actionCommand;
    }
}
