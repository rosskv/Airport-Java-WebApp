package by.kvach.dao;

import by.kvach.entity.Flights;

import java.util.List;

/**
 * Created by manager on 15.12.2016.
 */
public interface IFlightsDAO {
    boolean  addFlight( String brigadeId, String name, String fromPort, String toPort, String dateFlight, String timeFlight);
    List<Flights> getFlights();
    boolean removeFlights (Integer id);
}
