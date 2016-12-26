package by.kvach.command;

import by.kvach.ConfigurationManager;
import by.kvach.dao.implementation.BrigadesDAO;
import by.kvach.dao.implementation.EmployeesDAO;
import by.kvach.entity.Employees;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by manager on 16.12.2016.
 */
public class ViewEmployeesBrigadeCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        EmployeesDAO employeesDAO = new EmployeesDAO();
        BrigadesDAO brigadesDAO = new BrigadesDAO();
        String page = ConfigurationManager.getProperty("path.page.viewEmployeesBrigade");
        Integer id = Integer.parseInt(request.getParameter("id"));
        EmployeesDAO dao = new EmployeesDAO();
        List<Employees> employees = dao.viewEmployeesBrigade(id);
        request.setAttribute("employees", employees);
        request.setAttribute("brigades", brigadesDAO.getBrigadesById(id));
        request.setAttribute("empl", employeesDAO.getEmployees());
        return page;

    }
}