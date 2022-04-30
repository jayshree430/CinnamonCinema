package com.Jayshree.CinnamonCinema;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private final int maxRowCapacity = Row.values().length;
    private final int maxSeatCapacity = SeatNumber.values().length;
    private int counter = 0;
    private List<Seat> seatList = new ArrayList<>();

    public boolean seatAvailable(int input){
        return counter+input <= (maxRowCapacity * maxSeatCapacity);
    }

    public List<Seat> getSeatList(){
        return seatList;
    }

    public String allocateSeat(int input){

        if (seatAvailable(input)){
            if (input == 1)
                seatList.add(new Seat(Row.A, SeatNumber.ONE));
            else {
                seatList.add(new Seat(Row.A, SeatNumber.ONE));
                seatList.add(new Seat(Row.A, SeatNumber.TWO));
            }
            return "Seat allocated : " + input;
        }else {
            return "No more seat available";
        }

    }

}
