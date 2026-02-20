package com.java.exceptions.model.entities;

import com.java.exceptions.model.exceptions.DomainException;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {

    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation() {

    }

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainException {
        if (checkIn.isAfter(checkOut)) {
            throw new DomainException("Error in reservation: check-out date must be after check-in date");
        }

        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public long duration() {
        Duration diff = Duration.between(getCheckIn().atStartOfDay(), getCheckOut().atStartOfDay());

        return diff.toDays();
    }

    public void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException {

        LocalDate now = LocalDate.now();

        if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
            throw new DomainException("Invalid checkIn or checkOut. You need to specify dates higher than today");
        }
        if (checkIn.isAfter(checkOut)) {
            throw new DomainException("Error in reservation: check-out date must be after check-in date");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;

    }

    @Override
    public String toString() {
        return "Reservation: Room " + roomNumber + ", check-in: " + dateFormat.format(getCheckIn()) + ", check-out: " + dateFormat.format(getCheckOut()) + ", " + duration() + " nights";
    }
}
