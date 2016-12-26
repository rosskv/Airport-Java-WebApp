package by.kvach.command;

import by.kvach.ConfigurationManager;
import by.kvach.dao.implementation.EmployeesDAO;

import javax.servlet.http.HttpServletRequest;


public class AddEmployeesIntoBrigadeCommand implements ActionCommand {

    private static final String ID_USER = "brigadeId";

    @Override
    public String execute(HttpServletRequest request) {
        EmployeesDAO dao = new EmployeesDAO();
        Integer brigadeId = Integer.parseInt(request.getParameter(ID_USER));
        Integer empId = Integer.parseInt(request.getParameter("idEmp"));
        dao.addEmployeesIntoBrigade(brigadeId, empId);
        String page = ConfigurationManager.getProperty("path.page.page");
               //"/controller?command=viewEmployeesBrigade";
        return page;
    }
}
