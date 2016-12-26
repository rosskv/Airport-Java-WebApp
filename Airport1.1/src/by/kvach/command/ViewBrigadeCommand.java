package by.kvach.command;

import by.kvach.ConfigurationManager;
import by.kvach.dao.implementation.BrigadesDAO;
import by.kvach.entity.Brigades;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by manager on 15.12.2016.
 */
public class ViewBrigadeCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request)
    {
        String page = ConfigurationManager.getProperty("path.page.page");
        BrigadesDAO dao =new BrigadesDAO();
        List<Brigades> brigades = dao.getBrigades();
        request.setAttribute("brigades", brigades);
        return page;
    }
}