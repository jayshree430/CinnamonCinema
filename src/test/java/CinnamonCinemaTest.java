import com.Jayshree.CinnamonCinema.Booking;
import com.Jayshree.CinnamonCinema.Row;
import com.Jayshree.CinnamonCinema.Seat;
import com.Jayshree.CinnamonCinema.SeatNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        assertEquals("- Seat allocated : A1", message);
    }

    @Test
    public void checkTwoSeatsAreAllocated(){
        String message = booking.allocateSeat(2);
        assertEquals("- Seat allocated : A1 A2", message);
    }

    @Test
    public void checkThreeSeatsAreAllocated() {
        String message = booking.allocateSeat(3);
        assertEquals("- Seat allocated : A1 A2 A3", message);

        List<Seat> seatList = booking.getSeatList();
        assertEquals(3, seatList.size());
        assertEquals(Row.A, seatList.get(0).getRow());
        assertEquals(SeatNumber.THREE, seatList.get(2).getSeatNumber());
    }

    @Test
    public void checkSeatAllocationInSameRow(){
        String message = booking.allocateSeat(3);
        assertEquals("- Seat allocated : A1 A2 A3", message);

        message = booking.allocateSeat(2);
        assertEquals("- Seat allocated : A4 A5", message);

        List<Seat> seatList = booking.getSeatList();
        assertEquals(5, seatList.size());
        assertEquals(Row.A, seatList.get(0).getRow());
        assertEquals(SeatNumber.FIVE, seatList.get(4).getSeatNumber());

    }
    @Test
    public void checkRequestedSeatIsBetween1And3(){
        String message = booking.allocateSeat(5);
        assertEquals("Input must be between 1 - 3", message);
    }

    @Test
    public void checkSeatAllocationInDifferentRow(){
        String message = booking.allocateSeat(3);
        assertEquals("- Seat allocated : A1 A2 A3", message);

        message = booking.allocateSeat(2);
        assertEquals("- Seat allocated : A4 A5", message);

        message = booking.allocateSeat(3);
        assertEquals("- Seat allocated : B1 B2 B3", message);

        message = booking.allocateSeat(3);
        assertEquals("- Seat allocated : B4 B5 C1", message);

        List<Seat> seatList = booking.getSeatList();
        assertEquals(11, seatList.size());
        assertEquals(Row.B, seatList.get(6).getRow());
        assertEquals(SeatNumber.TWO, seatList.get(6).getSeatNumber());

        assertEquals(Row.C, seatList.get(10).getRow());
        assertEquals(SeatNumber.ONE, seatList.get(10).getSeatNumber());

    }

    @Test
    public void checkRequestedSeatCannotBeAllocated(){

        String message = booking.allocateSeat(3);
        assertEquals("- Seat allocated : A1 A2 A3", message);

        message = booking.allocateSeat(2);
        assertEquals("- Seat allocated : A4 A5", message);

        message = booking.allocateSeat(3);
        assertEquals("- Seat allocated : B1 B2 B3", message);

        message = booking.allocateSeat(3);
        assertEquals("- Seat allocated : B4 B5 C1", message);

        message = booking.allocateSeat(2);
        assertEquals("- Seat allocated : C2 C3", message);

        message = booking.allocateSeat(3);
        assertEquals("- Seat allocation not possible", message);

        message = booking.allocateSeat(1);
        assertEquals("- Seat allocated : C4", message);

    }

}
