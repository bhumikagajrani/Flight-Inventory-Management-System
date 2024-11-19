package flightmanagement.base;
import java.util.ArrayList;
import java.util.List;

public class Flight {

    private String flightno;
    private String airline;
    private String from;
    private String to;
    private int departdate;
    private double departtime;
    private List<Fare> fares;

    public Flight(String flightno, String airline, String from, String to, int departdate, double departtime, List<Fare> fares) {
        this.flightno = flightno;
        this.airline = airline;
        this.from = from;
        this.to = to;
        this.departdate = departdate;
        this.departtime = departtime;
        this.fares = fares;
    }

    public String getFlightno() {
        return flightno;
    }

    public void setFlightno(String flightno) {
        this.flightno = flightno;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getDepartdate() {
        return departdate;
    }

    public void setDepartdate(int departdate) {
        this.departdate = departdate;
    }

    public double getDeparttime() {
        return departtime;
    }

    public void setDeparttime(double departtime) {
        this.departtime = departtime;
    }

    public List<Fare> getFares() {
        return fares;
    }

    public void setFares(List<Fare> fares) {
        this.fares = fares;
    }

    public List<Seat> getAvailableSeat(String faretype) {
        for(Fare fare : fares) {
            if(fare.getFareType().equals(faretype)) {
                return fare.getAvailableSeat();
            }
        }
        return null;
    }
}
