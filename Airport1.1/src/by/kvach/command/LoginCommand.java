package by.kvach.command;

import by.kvach.ConfigurationManager;
import by.kvach.MessageManager;
import by.kvach.dao.implementation.BrigadesDAO;
import by.kvach.dao.implementation.ClientDAO;
import by.kvach.dao.implementation.EmployeesDAO;
import by.kvach.dao.implementation.ProfessionsDAO;
import by.kvach.entity.Users;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {
    private static final String ID = "userId";
    private static final String FIRSTNAME = "firstName";
    private static final String LASTNAME = "lastName";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String IS_ADMIN = "roleId";
    private static final String IS_SIGNED = "isSignedIn";

    @Override
    public String execute(HttpServletRequest req) {
        String page = null;
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);

        //Client client = LoginLogic.checkLogin(login, password, req);
        ProfessionsDAO professionsDAO = new ProfessionsDAO();
        EmployeesDAO employeesDAO = new EmployeesDAO();
       BrigadesDAO brigadesDAO = new BrigadesDAO();
        ClientDAO clientDAO = new ClientDAO();
        Users client = clientDAO.checkLogin(login, password, req);

        if (client != null){
            req.getSession().setAttribute(ID, client.getUserId());
            req.getSession().setAttribute(FIRSTNAME, client.getFirstName());
            req.getSession().setAttribute(LASTNAME, client.getLastName());
            req.getSession().setAttribute(LOGIN, client.getLogin());
            req.getSession().setAttribute(PASSWORD, client.getPassword());
            req.getSession().setAttribute(IS_ADMIN, client.getRoleId());
            req.getSession().setAttribute(IS_SIGNED, true);
            if ((boolean)req.getSession().getAttribute("roleId")){
                page = ConfigurationManager.getProperty("path.page.admin");
        }
        else
               
                page = ConfigurationManager.getProperty("path.page.page");
                req.getSession().setAttribute("brigades", brigadesDAO.getBrigades());
            req.getSession().setAttribute("employees", employeesDAO .getEmployees());
            req.getSession().setAttribute("professions", professionsDAO. getProfessions());
        } else {
            req.setAttribute("errorLoginOrPassMessage", MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }
}
