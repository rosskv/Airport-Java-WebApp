package by.kvach.command;

import by.kvach.ConfigurationManager;
import by.kvach.LoginLogic;
import by.kvach.MessageManager;
import by.kvach.dao.IClientDAO;
import by.kvach.dao.implementation.ClientDAO;

import javax.servlet.http.HttpServletRequest;

public class SigninCommand implements ActionCommand {
    private static final String ID = "userId";
    private static final String FIRSTNAME = "fio";
    private static final String LASTNAME = "fio1";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String REPEAT_PASSWORD = "passwordRepeat";
    private static final String ERROR_IN_PASSWORD = "errorInPass";
    private static final String ERROR_IN_LOGIN = "errorInLogin";
    private static final String IS_ADMIN = "roleId";
    private static final String ERROR_IN_SIGNIN = "errorSIGNIN";

    @Override
    public String execute(HttpServletRequest req) {
        String page = ConfigurationManager.getProperty("path.page.signin");;
        String fio = req.getParameter(FIRSTNAME);
        String fio1 = req.getParameter(LASTNAME);
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        String repeatPassword = req.getParameter(REPEAT_PASSWORD);

        //Client client = new ClientDAO().checkLogin(login, password, req);
        // rebuild here

        if (password != null && password.equals(repeatPassword)){
            if (LoginLogic.checkLogin(login, password, req) == null){
                IClientDAO client = new ClientDAO();
                if (client.registrateClient(login, password, fio, fio1)){
                    page = ConfigurationManager.getProperty("path.page.success");
                }
                else {
                    req.setAttribute(ERROR_IN_SIGNIN, "Error in signin");
                }
            }
            else {
                req.setAttribute(ERROR_IN_LOGIN, MessageManager.getProperty("message.onlyloginerror"));
            }
        }
        else {
            req.setAttribute(ERROR_IN_PASSWORD, MessageManager.getProperty("message.onlypassworderror"));
        }
        return page;
    }
}
