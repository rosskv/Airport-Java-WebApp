package by.kvach.dao;

import by.kvach.entity.Users;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IClientDAO {
    boolean registrateClient(String login, String password, String fio,String fio1);
    List<Users> getUsers();
    Users checkLogin(String enterLogin, String enterPass, HttpServletRequest req);
    boolean removeUser (Integer id);
}
