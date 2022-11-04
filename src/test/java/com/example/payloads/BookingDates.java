package com.example.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class BookingDates {

    private LocalDate checkin;
    private LocalDate checkout;
}
