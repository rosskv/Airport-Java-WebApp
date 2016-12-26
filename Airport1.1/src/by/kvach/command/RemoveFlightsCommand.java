package by.kvach.command;

/**
 * Created by manager on 15.12.2016.
 */
import by.kvach.dao.implementation.FlightsDAO;

import javax.servlet.http.HttpServletRequest;

public class RemoveFlightsCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request)
    {
        Integer id = Integer.parseInt(request.getParameter("id"));
        FlightsDAO dao =new FlightsDAO();
        dao.removeFlights(id);
        return "/controller?command=viewFlights";
    }

}