package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record LocationRecord(
        @JsonProperty("post code") String postCode,
        String country,
        @JsonProperty("country abbreviation") String countryAbbreviation,
        List<PlacesRecord> places) {
}
