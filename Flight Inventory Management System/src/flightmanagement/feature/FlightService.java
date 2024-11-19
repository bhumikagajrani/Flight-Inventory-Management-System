package flightmanagement.feature;

import java.util.*;
import flightmanagement.base.Fare;
import flightmanagement.base.Flight;

public class FlightService {

    private static FlightService flightService;
    private List<Flight> flights;

    private FlightService() {
        flights = new ArrayList<>();
    }

    public static FlightService getInstance() {
        if (flightService == null) {
            flightService = new FlightService();
        }
        return flightService;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public List<Flight> searchFlight(String from, String to, int departdate, int paxcount) {
        List<Flight> searchresult = new ArrayList<>();
        for(Flight flight : flights) {
            if(flight.getFrom().equals(from) && flight.getTo().equals(to) && flight.getDepartdate()==departdate) {
                for(Fare fare:flight.getFares()) {
                    if(fare.getAvailableSeat().size()>=paxcount) {
                        searchresult.add(flight);
                        break;
                    }
                }
            }
        }
        return searchresult;
    }
}
