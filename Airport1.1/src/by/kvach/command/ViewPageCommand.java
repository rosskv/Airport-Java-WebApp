package by.kvach.command;

import by.kvach.ConfigurationManager;
import by.kvach.dao.implementation.ClientDAO;
import by.kvach.entity.Users;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by manager on 16.12.2016.
 */
public class ViewPageCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request)
    {
        String page = ConfigurationManager.getProperty("path.page.page");
        return page;
    }
}
