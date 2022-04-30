import com.Jayshree.CinnamonCinema.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CinnamonCinemaTest {

    Booking booking;

    @BeforeEach

    public void setup(){
        booking = new Booking();
    }

    @Test
    public void checkSeatAvailability(){
        boolean isSeatAvailable = booking.seatAvailable(1);
        assertTrue(isSeatAvailable);

        isSeatAvailable = booking.seatAvailable(5);
        assertTrue(isSeatAvailable);

        isSeatAvailable = booking.seatAvailable(15);
        assertTrue(isSeatAvailable);

        isSeatAvailable = booking.seatAvailable(16);
        assertFalse(isSeatAvailable);

    }

}
