package flightmanagement.base;

import java.util.List;

public class Fare {

    private String fareType;
    private double price;
    private List<Seat> availableSeats;

    public Fare(String fareType, double price, List<Seat> availableSeats) {
        this.fareType = fareType;
        this.price = price;
        this.availableSeats=availableSeats;
    }

    public String getFareType() {
        return fareType;
    }

    public void setFareType(String fareType) {
        this.fareType = fareType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Seat> getAvailableSeat() {
        return availableSeats;
    }

    public void setAvailableSeats(List<Seat> availableSeats) {
        this.availableSeats = availableSeats;
    }

}
