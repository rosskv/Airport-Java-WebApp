package by.kvach.command;

import by.kvach.dao.implementation.EmployeesDAO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by manager on 17.12.2016.
 */
public class RemoveEmployeesIntoBrigadeCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request)
    {
        Integer id = Integer.parseInt(request.getParameter("id"));
        EmployeesDAO dao =new EmployeesDAO();
        dao.removeEmployeesIntoBrigade(id);
        return "/controller?command=viewEmployees";
    }

}