package by.kvach.entity;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by manager on 12.12.2016.
 */
public class Flights {

    private  int flightId;
    private String name;
    private String fromPort;
    private String toPort;
    private Date dateFlight;
    private Time timeFlight;
    private Integer brigade;
    private boolean flown;

    public Flights() {
    }

    public Flights(int flightId, String name, String fromPort, String toPort, Date dateFlight, Time timeFlight, Integer brigade, boolean flown) {
        this.flightId = flightId;
        this.name = name;
        this.fromPort = fromPort;
        this.toPort = toPort;
        this.dateFlight = dateFlight;
        this.timeFlight = timeFlight;
        this.brigade = brigade;
        this.flown = flown;
    }
//переделать гетер и сеттер для ббригады

    public Integer getBrigade() {
        return brigade;
    }

    public void setBrigade(Integer brigadeId) {
        this.brigade = brigadeId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFromPort() {
        return fromPort;
    }

    public void setFromPort(String fromPort) {
        this.fromPort = fromPort;
    }

    public String getToPort() {
        return toPort;
    }

    public void setToPort(String toPort) {
        this.toPort = toPort;
    }

    public Date getDateFlight() {
        return dateFlight;
    }

    public void setDateFlight(Date dateFlight) {
        this.dateFlight = dateFlight;
    }

    public Time getTimeFlight() {
        return timeFlight;
    }

    public void setTimeFlight(Time timeFlight) {
        this.timeFlight = timeFlight;
    }



    public boolean isFlown() {
        return flown;
    }

    public void setFlown(boolean flown) {
        this.flown = flown;
    }

    @Override
    public String toString() {
        return "Flights{" +
                "flightId=" + flightId +
                ", name='" + name + '\'' +
                ", fromPort='" + fromPort + '\'' +
                ", toPort='" + toPort + '\'' +
                ", dateFlight=" + dateFlight +
                ", timeFlight=" + timeFlight +
                ", brigadeId=" + brigade +
                ", flown=" + flown +
                '}';
    }
}
