package by.kvach.command;

import by.kvach.dao.implementation.BrigadesDAO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by manager on 16.12.2016.
 */
public class RemoveBrigadeCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request)
    {
        Integer id = Integer.parseInt(request.getParameter("id"));
       BrigadesDAO dao =new BrigadesDAO();
        dao.removeBrigade(id);
        return "/controller?command=viewBrigade";
    }

}