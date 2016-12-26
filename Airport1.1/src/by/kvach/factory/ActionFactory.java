package by.kvach.factory;

import by.kvach.MessageManager;
import by.kvach.command.ActionCommand;
import by.kvach.command.CommandEnum;
import by.kvach.command.EmptyCommand;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    public ActionCommand defineCommand(HttpServletRequest req){
        ActionCommand current = new EmptyCommand();
        String action = req.getParameter("command");
        if (action == null || action.isEmpty()){
            return current;
        }

        try{
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        }catch (IllegalArgumentException ex) {
            req.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
        }
        return current;
    }
}
