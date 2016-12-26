package by.kvach.command;

import by.kvach.ConfigurationManager;
import by.kvach.dao.implementation.EmployeesDAO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by manager on 17.12.2016.
 */
public class AddEmployeesFormCommand implements ActionCommand {

    private static final String ID = "Id";
    private static final String PROFESSION = "professionId";
    private static final String FIRSTNAME = "firstName";
    private static final String LASTNAME = "lastName";
    private static final String ERROR_IN_LOGIN = "errorInLogin";
     private static final String ERROR_IN_SIGNIN = "errorSIGNIN";

    @Override
    public String execute(HttpServletRequest req) {
        String page = ConfigurationManager.getProperty("path.page.addEmployees");
        String profession = req.getParameter(PROFESSION);
        String firstaNname = req.getParameter(FIRSTNAME);
        String lastName = req.getParameter(LASTNAME);

        EmployeesDAO employees = new EmployeesDAO();
        if (employees.addEmployees(profession, firstaNname, lastName)) {
            page = ConfigurationManager.getProperty("path.page.viewEmployees");
        } else {
            req.setAttribute(ERROR_IN_SIGNIN, "Error in signin");
        }
        return page;
    }

}