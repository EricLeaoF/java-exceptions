package com.java.exceptions.application;

import com.java.exceptions.entities.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Room number: ");
        int roomNumber = sc.nextInt();
        System.out.println("Check-in date (DD/MM/YYYY): ");
        LocalDate checkIn = LocalDate.parse(sc.next(), dateFormat);
        System.out.println("Check-out date (DD/MM/YYYY): ");
        LocalDate checkOut = LocalDate.parse(sc.next(), dateFormat);

        if (checkIn.isAfter(checkOut)) {
           System.out.println("Error in reservation: check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);

            System.out.println(reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");

            System.out.println("Check-in date (DD/MM/YYYY):");
            checkIn = LocalDate.parse(sc.next(), dateFormat);
            System.out.println("Check-out date (DD/MM/YYYY): ");
            checkOut = LocalDate.parse(sc.next(), dateFormat);

            String error = reservation.updateDates(checkIn, checkOut);
            if (error != null) {
                System.out.println("Error in reservation: " + error);
            } else {
                System.out.println(reservation);
            }

        }

        sc.close();

    }

}
