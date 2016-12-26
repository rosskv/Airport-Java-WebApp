package by.kvach.command;

import by.kvach.ConfigurationManager;
import by.kvach.dao.implementation.FlightsDAO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by manager on 15.12.2016.
 */
public class AddFlightCommand implements ActionCommand {

    private static final String ID = "flightId";
    private static final String BRIGADE = "brigadeId";
    private static final String NAME = "name";
    private static final String FROM = "fromPort";
    private static final String TO = "toPort";
    private static final String DATE = "dateFlight";
    private static final String TIME = "timeFlight";
    private static final String ERROR_IN_LOGIN = "errorInLogin";
    private static final String IS_ADMIN = "roleId";
    private static final String ERROR_IN_SIGNIN = "errorSIGNIN";

    @Override
    public String execute(HttpServletRequest req) {
        String page = ConfigurationManager.getProperty("path.page.admin");

        String brigade = req.getParameter(BRIGADE);
        String name = req.getParameter(NAME);
        String fromPort = req.getParameter(FROM);
        String toPort = req.getParameter(TO);
        String date = req.getParameter(DATE);
        String time = req.getParameter(TIME);


            FlightsDAO flight = new FlightsDAO();
            if (flight.addFlight(brigade,name, fromPort, toPort, date, time)) {
                page = ConfigurationManager.getProperty("path.page.viewFlights");
            } else {
                req.setAttribute(ERROR_IN_SIGNIN, "Error in signin");
            }
        return page;
    }

}
