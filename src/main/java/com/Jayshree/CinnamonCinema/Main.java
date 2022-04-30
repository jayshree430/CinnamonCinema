package com.Jayshree.CinnamonCinema;

import com.sun.source.tree.LambdaExpressionTree;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args){
        Random random = new Random();
        List<Seat> totalAllocatedSeats = new ArrayList<>();
        int input;
        Booking booking = new Booking();
        int counter = 1;
        List<Seat> seatList = new ArrayList<>();
        final int max = 3;
        final int min = 1;
        System.out.println("Welcome to Cinnamon Cinema\n");
        System.out.println("The program will allocate seats based on a random" +
                " integer “number of seats” between 1 and 3 until all the seats in the Cinema are filled\n");
        System.out.println("The allocation will start from Row A and will end with Row C. Each row has 5 seats.");

        while (booking.getSeatList().size() < 15) {
            /** Randomly allocating input values **/
            input = random.nextInt(min,max+1) ;

            String message = booking.allocateSeat(input);
            System.out.println("Seat Requested : " + input + ". " + message);
        }

        System.out.println("All the Seats in Cinema Theater are booked.");
    }
}
