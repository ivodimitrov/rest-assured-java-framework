package examples;

import io.restassured.http.ContentType;
import models.Location;
import models.LocationRecord;
import models.Places;
import models.PlacesRecord;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.samePropertyValuesAs;

public class ZippoTests {

    @Test
    public void getLocation() {
        var response = given()
                .get("https://api.zippopotam.us/us/90210");

        response
                .prettyPrint();

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("'post code'", equalTo("90210"))
                .body("country", equalTo("United States"))
                .body("'country abbreviation'", equalTo("US"))
                .body("places[0].'place name'", equalTo("Beverly Hills"))
                .body("places[0].longitude", equalTo("-118.4065"))
                .body("places[0].state", equalTo("California"))
                .body("places[0].'state abbreviation'", equalTo("CA"))
                .body("places[0].latitude", equalTo("34.0901"));
    }

    @Test
    public void getDeserializedLocation() {
        var expectedLocation = new Location(
                "90210",
                "United States",
                "US",
                List.of(new Places(
                        "Beverly Hills",
                        "-118.4065",
                        "California",
                        "CA",
                        "34.0901")));

        var actualLocation = given()
                .get("https://api.zippopotam.us/us/90210")
                .as(Location.class);

        Assert.assertEquals(
                "United States",
                actualLocation.getCountry());

//        Assert.assertEquals(
//                "Beverly Hills",
//                actualLocation.getPlaces().get(0).getPlaceName());

        assertThat(actualLocation, samePropertyValuesAs(expectedLocation));
    }

    @Test
    public void testLocationWithRecords() {
        var expectedLocation = new LocationRecord(
                "90210",
                "United State",
                "US",
                List.of(new PlacesRecord(
                        "Beverly Hills",
                        "-118.4065",
                        "California",
                        "CA",
                        "34.0901")));

        var actualLocation = given()
                .get("https://api.zippopotam.us/us/90210")
                .as(LocationRecord.class);

        assertThat(actualLocation, samePropertyValuesAs(expectedLocation));
    }
}
