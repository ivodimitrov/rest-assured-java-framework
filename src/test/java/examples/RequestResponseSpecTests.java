package examples;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;

public class RequestResponseSpecTests {

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    @BeforeClass
    public static void createRequestResponseSpecification() {

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://api.zippopotam.us")
                .setContentType(ContentType.JSON)
                .addFilter(new RequestLoggingFilter(LogDetail.ALL))
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL))
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(SC_OK)
                .expectContentType(ContentType.JSON)
                .build();
    }

    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills_withRequestSpec() {

        given().
                spec(requestSpec).
                when().
                get("us/90210").
                then().
                assertThat().
                statusCode(SC_OK);
    }

    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills_withResponseSpec() {

        given().
                spec(requestSpec).
                when().
                get("us/90210").
                then().
                spec(responseSpec).
                and().
                assertThat().
                body("places[0].'place name'", equalTo("Beverly Hills"));
    }

    @Test
    public void requestUsZipCode90210_extractPlaceNameFromResponseBody_assertEqualToBeverlyHills() {

        String placeName =
                given().
                        spec(requestSpec).
                        when().
                        get("us/90210").
                        then().
                        extract().
                        path("places[0].'place name'");

        Assert.assertEquals("Beverly Hills", placeName);
    }
}
