package com.java.exceptions.application;

import com.java.exceptions.entities.Reservation;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        try {

            Scanner sc = new Scanner(System.in);
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            System.out.println("Room number: ");
            int roomNumber = sc.nextInt();
            System.out.println("Check-in date (DD/MM/YYYY): ");
            LocalDate checkIn = LocalDate.parse(sc.next(), dateFormat);
            System.out.println("Check-out date (DD/MM/YYYY): ");
            LocalDate checkOut = LocalDate.parse(sc.next(), dateFormat);

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);

            System.out.println(reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");

            System.out.println("Check-in date (DD/MM/YYYY):");
            checkIn = LocalDate.parse(sc.next(), dateFormat);
            System.out.println("Check-out date (DD/MM/YYYY): ");
            checkOut = LocalDate.parse(sc.next(), dateFormat);

            reservation.updateDates(checkIn, checkOut);

            sc.close();

        } catch (IllegalArgumentException e) {
            System.out.println("Error " + e.getMessage());
        } catch (DateTimeParseException e) {
            System.out.println("Error parsing dates " + e.getMessage());
        }

    }

}
