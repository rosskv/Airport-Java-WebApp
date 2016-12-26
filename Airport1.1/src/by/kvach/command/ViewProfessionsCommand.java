package by.kvach.command;

import by.kvach.ConfigurationManager;
import by.kvach.dao.implementation.ProfessionsDAO;
import by.kvach.entity.Professions;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by manager on 17.12.2016.
 */
public class ViewProfessionsCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request)
    {
        String page = ConfigurationManager.getProperty("path.page.addEmployees");
        ProfessionsDAO dao = new ProfessionsDAO();
        List<Professions> professions = dao.getProfessions();
        request.setAttribute("professions", professions);
        return page;
    }
}
