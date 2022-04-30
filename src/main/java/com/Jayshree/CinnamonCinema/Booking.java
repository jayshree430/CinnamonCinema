package com.Jayshree.CinnamonCinema;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private final int maxRowCapacity = Row.values().length;
    private final int maxSeatCapacity = SeatNumber.values().length;
    private int counter = 0;

    public boolean seatAvailable(int input){
        return counter+input <= (maxRowCapacity * maxSeatCapacity);
    }

}
