package by.kvach.command;

import by.kvach.ConfigurationManager;
import by.kvach.dao.implementation.EmployeesDAO;
import by.kvach.entity.Employees;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by manager on 16.12.2016.
 */
public class ViewEmployeesCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request)
    {
        String page = ConfigurationManager.getProperty("path.page.viewEmployees");
        EmployeesDAO dao =new EmployeesDAO();
        List<Employees> employees = dao.getEmployees();
        request.setAttribute("employees", employees);
        return page;
    }
}
