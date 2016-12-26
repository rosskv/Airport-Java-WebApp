package by.kvach.command;
/**
 * Created by manager on 15.12.2016.
 */

import by.kvach.dao.implementation.ClientDAO;

import javax.servlet.http.HttpServletRequest;

public class RemoveUserCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request)
    {
        Integer id = Integer.parseInt(request.getParameter("id"));
        ClientDAO dao =new ClientDAO();
        dao.removeUser(id);
        return "/controller?command=viewUsers";
    }

}