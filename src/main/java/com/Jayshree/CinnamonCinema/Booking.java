package com.Jayshree.CinnamonCinema;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private final int maxRowCapacity = Row.values().length;
    private final int maxSeatCapacity = SeatNumber.values().length;
    private int counter = 0;
    private List<Seat> seatList = new ArrayList<>();
    private int rowCount = 0;

    public boolean seatAvailable(int input){
        return counter+input <= (maxRowCapacity * maxSeatCapacity);
    }

    public List<Seat> getSeatList(){
        return seatList;
    }

    public String allocateSeat(int input){

        if (seatAvailable(input)){
            for (int i = 0; i < input; i++) {

                if (counter == 0) {
                    seatList.add(new Seat(Row.A, SeatNumber.ONE));
                } else {
                    int columnCount = counter % maxSeatCapacity;
                    if (columnCount == 0) {
                        rowCount++;
                    }
                    seatList.add(new Seat(Row.values()[rowCount], SeatNumber.values()[columnCount]));
                }
                counter++;
            }
            return "Seat allocated : " + input;
        }else {
            return "No more seat available";
        }

    }

}
