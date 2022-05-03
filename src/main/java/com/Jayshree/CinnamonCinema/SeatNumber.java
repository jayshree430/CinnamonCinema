package com.Jayshree.CinnamonCinema;

public enum SeatNumber {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private final int position;
    SeatNumber(int position){
        this.position = position;
    }
    public int getPosition(){
        return position;
    }
}


