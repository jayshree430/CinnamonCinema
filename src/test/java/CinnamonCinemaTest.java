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

    @Test
    public void checkSingleSeatAllocation(){
        String message = booking.allocateSeat(1);
        assertEquals("Seat allocated : 1", message);
    }

    @Test
    public void checkTwoSeatsAreAllocated(){
        String message = booking.allocateSeat(2);
        assertEquals("Seat allocated : 2", message);
    }

}
