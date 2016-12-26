package by.kvach.command;

import by.kvach.ConfigurationManager;
import by.kvach.dao.implementation.BrigadesDAO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by manager on 16.12.2016.
 */
public class AddBrigadeCommand implements ActionCommand{
    private static final String ID = "brigadeId";
    private static final String NAME = "name";
    private static final String ERROR_IN_LOGIN = "errorInLogin";
    private static final String IS_ADMIN = "roleId";
    private static final String ERROR_IN_SIGNIN = "errorSIGNIN";

    @Override
    public String execute(HttpServletRequest req) {
        String page = ConfigurationManager.getProperty("path.page.page");

        String name = req.getParameter(NAME);


        BrigadesDAO flight = new BrigadesDAO();
        if (flight.addBrigade(name)) {
            page = ConfigurationManager.getProperty("path.page.page");
        } else {
            req.setAttribute(ERROR_IN_SIGNIN, "Error in signin");
        }
        return "/controller?command=viewBrigade";
    }
}
