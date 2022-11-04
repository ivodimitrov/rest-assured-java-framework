package com.example.requests;

import com.example.payloads.Booking;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookingApi extends BaseApi {

    private static final String apiUrl = baseUrl + "booking/";

    public static Response getBookingSummary(int roomId) {
        return given()
                .get(apiUrl + "summary?roomid=" + roomId);
    }

    public static Response postBooking(Booking payload) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(apiUrl);
    }

    public static Response deleteBooking(int bookingId, String tokenValue) {
        return given()
                .header("Cookie", "token=" + tokenValue)
                .delete(apiUrl + bookingId);
    }
}
