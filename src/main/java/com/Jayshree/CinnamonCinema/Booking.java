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
        /*** Checking if there is space to allocate requested seats *****/
        return counter+input <= (maxRowCapacity * maxSeatCapacity);
    }

    public List<Seat> getSeatList(){
        return seatList;
    }

    public String allocateSeat(int input){
        try {

            /*** Checking if the input is between 1 & 3 ****/
            if (input >3 || input <1){
                return "Input must be between 1 - 3";
            }
            if (seatAvailable(input)) {
                for (int i = 0; i < input; i++) {

                    if (counter == 0) {
                        seatList.add(new Seat(Row.A, SeatNumber.ONE));
                    } else {
                        int columnCount = counter % maxSeatCapacity;
                        if (columnCount == 0) {
                         /****If the counter has reached the maximum seat number(5) then changing the row ****/
                            rowCount++;
                        }
                        seatList.add(new Seat(Row.values()[rowCount], SeatNumber.values()[columnCount]));
                    }
                    counter++;
                }
            } else {
                /*** returning the message if allocation of the seat is not possible***/
                return "Seat allocation not possible";
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return "Seat allocated : " + input;
    }

}
