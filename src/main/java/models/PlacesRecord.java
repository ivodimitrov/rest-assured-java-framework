package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PlacesRecord(
        @JsonProperty("place name") String placeName,
        @JsonProperty("longitude") String longitude,
        @JsonProperty("state") String state,
        @JsonProperty("state abbreviation") String stateAbbreviation,
        @JsonProperty("latitude") String latitude) {
}
