package by.kvach.command;

import by.kvach.ConfigurationManager;
import by.kvach.dao.implementation.FlightsDAO;
import by.kvach.entity.Flights;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by manager on 15.12.2016.
 */
public class ViewFlightsCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request)
    {
        String page = ConfigurationManager.getProperty("path.page.viewFlights");
        FlightsDAO dao =new FlightsDAO();
        List<Flights> flights = dao.getFlights();
        request.setAttribute("flights", flights);
        return page;
    }
}
