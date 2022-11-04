package com.example.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Auth {

    @JsonProperty
    private final String username;
    @JsonProperty
    private final String password;

    public Auth(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
