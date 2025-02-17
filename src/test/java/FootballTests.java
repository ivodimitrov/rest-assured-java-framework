import config.FootballConfig;
import config.FootballEndpoints;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class FootballTests extends FootballConfig {

    @Test
    public void getDetailsOfOneArea() {
        given()
                .queryParam("areas", 2076)
                .when()
                .get("/areas");
    }

    @Test
    public void getDetailsOfMultipleAreas() {
        String areaIds = "2076,2077,2080";

        given()
                .urlEncodingEnabled(false)
                .queryParam("areas", areaIds)
                .when()
                .get("/areas");
    }

    @Test
    public void getDateFounded() {
        given()
                .when()
                .get(FootballEndpoints.TEAM_57)
                .then()
                .body("founded", equalTo(1886));
    }

    @Test
    public void getFirstTeamName() {
        given()
                .when()
                .get(FootballEndpoints.COMPETITIONS_2021_TEAMS)
                .then()
                .body("teams.name[1]", equalTo("Aston Villa FC"));
    }
}
