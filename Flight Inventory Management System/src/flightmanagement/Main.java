package flightmanagement;

import flightmanagement.base.Fare;
import flightmanagement.base.Flight;
import flightmanagement.base.Seat;
import flightmanagement.base.User;
import flightmanagement.feature.BookService;
import flightmanagement.feature.FlightService;
import flightmanagement.feature.UserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        FlightService flightService = FlightService.getInstance();
        BookService bookingservice = BookService.getInstance();
        UserService userService = UserService.getInstance();

        List<Seat> seatlist = new ArrayList<>();
        seatlist.add(new Seat("1b"));
        seatlist.add(new Seat("2c"));

        Fare fare = new Fare("F1",1000.0, seatlist);
        List<Fare> fareslist = new ArrayList<>();
        fareslist.add(fare);

        Flight flight = new Flight("123", "6E" ,"DEL" ,"BLR", 2,  10.0,fareslist);
        flightService.addFlight(flight);
        List<Flight> availableflights = flightService.searchFlight("DEL","BLR",2,1);
        for(Flight f : availableflights){
            System.out.println("Available Flights:"+f.getFlightno());
        }

        List<Seat> bookingseatlist1 = new ArrayList<>();
        bookingseatlist1.add(new Seat("1b"));

        User user1 = userService.addUser("u1","Vinit",1000.0);
        System.out.println("User name:"+ user1.getName()+", Funds available:"+user1.getFunds());
        String bookingid1 = bookingservice.bookFlight("u1","DEL","BLR","123","6E",2,"F1",bookingseatlist1);
        System.out.println("Booking flight id for user "+user1.getName()+": "+bookingid1);

        User user2 = userService.addUser("u2","Sumit",1000.0);
        System.out.println("User name:"+ user2.getName()+", Funds available:"+user2.getFunds());
        String bookingid2 = bookingservice.bookFlight("u2","DEL","BLR","123","6E",2,"F1",bookingseatlist1);
        System.out.println(bookingid2);

        User user3 = userService.addUser("u3","Amit",100.0);
        System.out.println("User name:"+ user3.getName()+", Funds available:"+user3.getFunds());
        List<Seat> bookingseatlist2 = new ArrayList<>();
        bookingseatlist2.add(new Seat("2c"));
        String bookingid3 = bookingservice.bookFlight("u3","DEL","BLR","123","6E",2,"F1",bookingseatlist2);
        System.out.println(bookingid3);

        User user4 = userService.addUser("u4","Namit",5000.0);
        System.out.println("User name:"+ user4.getName()+", Funds available:"+user4.getFunds());
        String bookingid4 = bookingservice.bookFlight("u4","DEL","BLR","123","6E",2,"F2",bookingseatlist2);
        System.out.println(bookingid4);
    }
}