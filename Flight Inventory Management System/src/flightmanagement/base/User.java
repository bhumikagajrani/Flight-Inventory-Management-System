package flightmanagement.base;
import java.util.*;

public class User {

    private String userID;
    private String name;
    private double funds;
    private List<String> bookings;

    public User(String userID, String name, double funds) {
        this.userID = userID;
        this.name = name;
        this.funds = funds;
        this.bookings = new ArrayList<>();
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFunds() {
        return funds;
    }

    public boolean deductFunds(double amount) {
        if(funds>=amount) {
            funds -= amount;
            return true;
        }
        return false;
    }

    public void addBooking(String bookingid) {
        bookings.add(bookingid);
    }
}
