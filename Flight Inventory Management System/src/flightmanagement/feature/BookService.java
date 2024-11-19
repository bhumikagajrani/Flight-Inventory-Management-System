package flightmanagement.feature;

import flightmanagement.base.Fare;
import flightmanagement.base.Flight;
import flightmanagement.base.User;
import flightmanagement.base.Seat;
import flightmanagement.generator.GenerateId;
import java.util.*;

public class BookService {

    private static BookService bookService;
    private Map<String, Map<String, Object>> booking;

    private BookService() {
        booking = new HashMap<>();
    }

    public static BookService getInstance() {
        if (bookService == null) {
            bookService = new BookService();
        }
        return bookService;
    }

    public String bookFlight(String userid, String from, String to, String flightno, String airline, int departdate, String fareType, List<Seat> seatlist) {

        UserService userService = UserService.getInstance();
        User user = userService.getUser(userid);

        if (user == null) {
            return "User not found";
        }

        FlightService flightService = FlightService.getInstance();
        List<Flight> availableFlights = flightService.searchFlight(from, to, departdate, 0);
        Flight selectflight = availableFlights.stream().filter(
                flight -> flight.getFlightno().equals(flightno) && flight.getAirline().equals(airline)
        ).findFirst().orElse(null);

        if (selectflight == null) {
            return "Flight not found";
        }

        Fare selectfare = selectflight.getFares().stream().filter(fare -> fare.getFareType().equals(fareType)).findFirst().orElse(null);

        if (selectfare == null) {
            return "Required fare type not available";
        }

        List<Seat> availableseats = selectfare.getAvailableSeat();

        // Check if all requested seats are available
        for (Seat seat : seatlist) {
            boolean availableseat = availableseats.stream().anyMatch(seatavail -> seatavail.getSeatNo().equals(seat.getSeatNo()) && !seatavail.isbooked());
            if (!availableseat) {
                return "Seats are already booked";
            }
        }

        double totalamount = seatlist.size() * selectfare.getPrice();
        if (!user.deductFunds(totalamount)) {
            return "Funds are insufficient";
        }

        // Mark the seats as booked
        for (Seat seat : seatlist) {
            // Find the corresponding seat in the available seats list and mark it as booked
            availableseats.stream()
                    .filter(seatavail -> seatavail.getSeatNo().equals(seat.getSeatNo()))
                    .forEach(Seat::bookingseat);
        }

        String bookingId = GenerateId.generateBookingId();
        user.addBooking(bookingId);
        booking.put(bookingId, Map.of("userid", user.getUserID(), "flightno", selectflight.getFlightno(), "fareType", fareType, "seats", seatlist));
        return bookingId;
    }
}