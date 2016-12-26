package by.kvach.dao.implementation;

import by.kvach.dao.DatabaseConnection;
import by.kvach.dao.IFlightsDAO;
import by.kvach.db.Fields;
import by.kvach.entity.Flights;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by manager on 15.12.2016.
 */
public class FlightsDAO implements IFlightsDAO {
    private final String INSERT_NEW_FLIGHTS = "insert into flights(brigade_id, name , from_port, to_port, date_flight, time_flight, flown) values(?, ?, ?, ?, ?, ?, 0)";


    @Override
    public boolean addFlight( String brigadeId, String name, String fromPort, String toPort, String dateFlight, String timeFlight)
    {
        Connection connection = null;
        PreparedStatement ps = null;

        try{
            connection = DatabaseConnection.getConnection();
            ps = connection.prepareStatement(INSERT_NEW_FLIGHTS);
            ps.setString(1, brigadeId);
            ps.setString(2,  name);
            ps.setString(3, fromPort);
            ps.setString(4, toPort);
            ps.setString(5, dateFlight);
            ps.setString(6, timeFlight);
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
    public List<Flights> getFlights() {
        List<Flights> flights = new ArrayList<>();
        String sql = "SELECT * FROM flights";
        try (Connection conn = DatabaseConnection.getConnection()) {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        Flights f = extractFlight(rs);
                        flights.add(f);
                    }
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
              }
        return flights;
    }
    @Override
    public boolean removeFlights(Integer id) {
        String sql = "delete from flights where flight_id=?;";
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
    private Flights extractFlight(ResultSet rs) throws SQLException {
        Flights f = new Flights();
        f.setFlightId(rs.getInt(Fields.FLIGHTS_FLIGHT_ID));
        f.setName(rs.getString(Fields.FLIGHTS_NAME));
        f.setFromPort(rs.getString(Fields.FLIGHTS_FROM_PORT));
        f.setToPort(rs.getString(Fields.FLIGHTS_TO_PORT));
        f.setDateFlight(rs.getDate(Fields.FLIGHTS_DATE_FLIGHT));
        f.setTimeFlight(rs.getTime(Fields.FLIGHTS_TIME_FLIGHT));
        f.setBrigade(rs.getInt(Fields.FLIGHTS_BRIGADE_ID));
        f.setFlown(rs.getBoolean(Fields.FLIGHTS_STATUS_ID));

        return f;
    }

}
