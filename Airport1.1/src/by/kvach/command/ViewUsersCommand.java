package by.kvach.command;

import by.kvach.ConfigurationManager;
import by.kvach.dao.implementation.ClientDAO;
import by.kvach.entity.Users;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ViewUsersCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request)
    {
        String page = ConfigurationManager.getProperty("path.page.viewUsers");
        ClientDAO dao =new ClientDAO();
        List<Users> users = dao.getUsers();
        request.setAttribute("users", users);
        return page;
    }
}
