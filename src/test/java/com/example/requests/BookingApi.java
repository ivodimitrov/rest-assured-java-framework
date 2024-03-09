package com.example.requests;

import com.example.payloads.Booking;
import com.example.payloads.BookingResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookingApi extends BaseApi {

    private static final String apiUrl = baseUrl + "booking/";

    public static Response getBookingSummary(int roomId) {
        Response response =
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .when()
                        .get(apiUrl + "summary?roomid=" + roomId)
                        .then()
                        .extract().response();

        System.out.println();
        response.prettyPrint();
        System.out.println();

        return response;
    }

    public static BookingResponse getBookingSummary1(int roomId) {
        Response response =
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .when()
                        .get(apiUrl + "summary?roomid=" + roomId)
                        .then()
                        .extract()
                        .response();

        System.out.println();
        response.prettyPrint();
        System.out.println();

        BookingResponse responseBody = response.as(BookingResponse.class);
        responseBody.setStatusCode(response.getStatusCode());

        return responseBody;
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
