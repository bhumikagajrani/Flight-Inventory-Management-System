package flightmanagement.base;

public class Seat {

    private String seatNo;
    private boolean isbooked;

    public Seat(String seatNo) {
        this.seatNo = seatNo;
        this.isbooked = false;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public boolean isbooked() {
        return isbooked;
    }

    public void bookingseat() {
        this.isbooked = true;
    }

}
