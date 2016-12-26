package by.kvach;

import by.kvach.dao.DatabaseConnection;
import by.kvach.entity.Users;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;

public class LoginLogic {

    private final String INSERT_NEW_USERS = "insert into users(login, password,first_name, last_name,role_id) values(?, ?, ?, ?, 0)";
    public boolean registrateClient( String login, String password, String fio,String fio1) {
        Connection connection = null;
        PreparedStatement ps = null;

        try{
            connection = DatabaseConnection.getConnection();
            ps = connection.prepareStatement(INSERT_NEW_USERS);
            ps.setString(1, login);
            ps.setString(2, password);
            ps.setString(3, fio);
            ps.setString(4, fio1);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if (ps != null)
                    ps.close();
                if(connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public static Users checkLogin(String enterLogin, String enterPass, HttpServletRequest req){
        Connection connectionn = null;
        ResultSet rs = null;
        Statement statement = null;
        String SQL_SELECT = String.format("select user_id, password, first_name, last_name, role_id from users where login='%s'", enterLogin);
        Users client = null;
        try {
            connectionn = DatabaseConnection.getConnection();
            statement = connectionn.createStatement();
            rs = statement.executeQuery(SQL_SELECT);
            int id = 0;
            String password = null;
            String fname = null;
            String lname = null;
            boolean role = false;
            while (rs.next()){
                id = rs.getInt(1);
                password = rs.getString(2);
                fname = rs.getString(3);
                lname = rs.getString(4);
                role = rs.getBoolean(5);
                if (password.equals(enterPass)){
                    client = new Users(id, enterLogin, fname , role, lname, enterPass);
                    return client;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try{
                if (rs != null)
                    rs.close();
                if (statement != null)
                    statement.close();
                if (connectionn != null)
                    connectionn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return client;
    }
}
