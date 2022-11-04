package com.example.payloads;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonIgnoreType
@AllArgsConstructor
@Getter
public class Booking {

    private int roomid;
    private String firstname;
    private String lastname;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;
}
