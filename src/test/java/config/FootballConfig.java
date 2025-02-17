package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.BeforeClass;
import com.project.utils.PropertyReader;


public class FootballConfig {

    @BeforeClass
    public static void setup() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(PropertyReader.getProperty("base.url"))
                .setBasePath("/v4")
                .addHeader("X-Auth-Token", PropertyReader.getProperty("authToken"))
                .addHeader("X-Response-Control", "minified")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
}
