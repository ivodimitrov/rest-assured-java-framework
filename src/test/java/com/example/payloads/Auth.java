package com.example.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Auth {

    private final String username;
    private final String password;
}
