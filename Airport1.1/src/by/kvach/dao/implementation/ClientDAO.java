package by.kvach.dao.implementation;

import by.kvach.dao.DatabaseConnection;
import by.kvach.dao.IClientDAO;
import by.kvach.db.Fields;
import by.kvach.entity.Users;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO implements IClientDAO {
    private final String INSERT_NEW_USERS = "insert into users(login, password,first_name, last_name,role_id) values(?, ?, ?, ?, 0)";


    @Override
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

    @Override
    public Users checkLogin(String enterLogin, String enterPass, HttpServletRequest req){
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
    @Override
    public List<Users> getUsers() {
        List<Users> users = new ArrayList<>();
        String sql = "SELECT * FROM users;";
        try (Connection conn = DatabaseConnection.getConnection()) {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        Users user = extractUser(rs);
                        users.add(user);
                    }
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
                   }
        return users;
    }
    @Override
    public boolean removeUser(Integer id) {
        String sql = "delete from users where user_id=?;";
        boolean isRemoved = false;
        try (Connection conn = DatabaseConnection.getConnection()) {
            try (PreparedStatement st = conn.prepareStatement(sql)) {
                st.setInt(1, id);
                int count = st.executeUpdate();
                if (count == 1) {
                    isRemoved = true;
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
                   }
        return isRemoved;
    }


    private Users extractUser(ResultSet rs) throws SQLException {
        Users user = new Users();
        user.setUserId(rs.getInt(Fields.USERS_USER_ID));
        user.setLogin(rs.getString(Fields.USERS_LOGIN));
        user.setPassword(rs.getString(Fields.USERS_PASSWORD));
        user.setFirstName(rs.getString(Fields.USERS_FIRST_NAME));
        user.setLastName(rs.getString(Fields.USERS_LAST_NAME));
        //user.setRoleId(rs.getInt(Fields.USERS_ROLE_ID));
        return user;
    }
}
