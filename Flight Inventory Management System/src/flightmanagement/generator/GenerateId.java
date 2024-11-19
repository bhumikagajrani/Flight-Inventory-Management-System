package flightmanagement.generator;

import java.util.UUID;

public class GenerateId {

    public static String generateBookingId() {
        return UUID.randomUUID().toString();
    }
}
