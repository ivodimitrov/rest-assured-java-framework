package examples;

import com.tngtech.java.junit.dataprovider.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@RunWith(DataProviderRunner.class)
public class dataDrivenTests {

    @DataProvider
    public static Object[][] zipCodesAndPlaces() {
        return new Object[][]{
                {"us", "90210", "Beverly Hills"},
                {"us", "12345", "Schenectady"},
                {"ca", "B2R", "Waverley"},
                {"bg", "1000", "София / Sofija"},
                {"bg", "5800", "Плевен / Pleven"}
        };
    }

    @Test
    @UseDataProvider("zipCodesAndPlaces")
    public void requestZipCodesFromCollection_checkPlaceNameInResponseBody_expectSpecifiedPlaceName(String countryCode, String zipCode, String expectedPlaceName) {

        given().
                pathParam("countryCode", countryCode).pathParam("zipCode", zipCode).
                when().
                get("http://zippopotam.us/{countryCode}/{zipCode}").
                then().
                assertThat().
                body("places[0].'place name'", equalTo(expectedPlaceName));
    }
}
