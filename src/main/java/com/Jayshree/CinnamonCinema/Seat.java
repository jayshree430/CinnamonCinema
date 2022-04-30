package com.Jayshree.CinnamonCinema;

import java.awt.image.renderable.RenderableImage;

public class Seat {
    Row row;
    SeatNumber seatNumber;

    public Seat(Row row, SeatNumber seatNumber){
        this.row = row;
        this.seatNumber = seatNumber;
    }

    public Row getRow(){
        return row;
    }
    public SeatNumber getSeatNumber(){
        return seatNumber;
    }

}
