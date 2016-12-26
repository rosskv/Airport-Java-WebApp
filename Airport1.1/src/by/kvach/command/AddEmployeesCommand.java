package by.kvach.command;

import by.kvach.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by manager on 17.12.2016.
 */
public class AddEmployeesCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request)
    {
        String page = ConfigurationManager.getProperty("path.page.addEmployees");
        return page;
    }
}
