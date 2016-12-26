package by.kvach.dao.implementation;

import by.kvach.dao.DatabaseConnection;
import by.kvach.dao.IBrigadesDAO;
import by.kvach.db.Fields;
import by.kvach.entity.Brigades;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by manager on 15.12.2016.
 */
public class BrigadesDAO implements IBrigadesDAO {

    private final String INSERT_NEW_BRIGADE = "insert into brigades( name) values(?)";
    private final String FIND_ID = "select * from brigades where brigade_id= ?;";

    @Override
    public boolean addBrigade(String name)
    {
        Connection connection = null;
        PreparedStatement ps = null;

        try{
            connection = DatabaseConnection.getConnection();
            ps = connection.prepareStatement(INSERT_NEW_BRIGADE);
            ps.setString(1,  name);
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
    public List<Brigades> getBrigades() {
        List<Brigades> brigades = new ArrayList<>();
        String sql = "SELECT * FROM brigades;";
        try (Connection conn = DatabaseConnection.getConnection()) {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        Brigades brigade = extractBrigade(rs);
                        brigades.add(brigade);
                    }
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return brigades;
    }
    @Override
    public boolean removeBrigade(Integer id) {
        String sql = "delete from brigades where brigade_id=?;";
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

    @Override
    public Brigades getBrigadesById(int id_b) {
        Brigades brigades = null;

        try {
            Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_ID);
            preparedStatement.setInt(1, id_b);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()){ return brigades;}
            brigades =extractBrigade(resultSet);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return brigades;
    }

    private Brigades extractBrigade(ResultSet rs) throws SQLException {
        Brigades brigade = new Brigades();
        brigade.setBrigdeId(rs.getInt(Fields.BRIGADES_BRIGADE_ID));
        brigade.setName(rs.getString(Fields.BRIGADES_NAME));
        return brigade;
    }
}
