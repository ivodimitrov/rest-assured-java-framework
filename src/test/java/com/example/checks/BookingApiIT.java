package com.example.checks;

import com.example.payloads.Auth;
import com.example.payloads.Booking;
import com.example.payloads.BookingDates;
import com.example.payloads.BookingResponse;
import com.example.requests.AuthApi;
import com.example.requests.BookingApi;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;

public class BookingApiIT {

    private final Faker faker = new Faker();
    private Response response;

    @BeforeMethod
    public Response createBooking() {
        BookingDates dates = new BookingDates(
                LocalDate.of(2021, 1, 1),
                LocalDate.of(2021, 1, 3)
        );

        Booking payload = new Booking(
                faker.number().numberBetween(1000000, 2000000),
                faker.name().firstName(),
                faker.name().lastName(),
                true,
                dates,
                "Breakfast"
        );

        response = BookingApi.postBooking(payload);

        System.out.println();
        response.prettyPrint();
        System.out.println();

        return response;
    }

    @Test
    public void getBookingSummaryShouldReturn200() {
        Map<String, Integer> booking = response.jsonPath().getMap("booking");
        int roomId = booking.get("roomid");

        Response response = BookingApi.getBookingSummary(roomId);

        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void postBookingReturns201() {
        assertEquals(201, response.getStatusCode());
    }

    @Test
    public void deleteBookingReturns202() {
        BookingResponse createdBookingResponse = response.as(BookingResponse.class);

        Auth auth = new Auth("admin", "password");
        Response authResponse = AuthApi.postAuth(auth);
        String authToken = authResponse.getCookie("token");

        Response deleteResponse = BookingApi.deleteBooking(createdBookingResponse.getBookingid(), authToken);

        assertEquals(202, deleteResponse.getStatusCode());
    }
}
