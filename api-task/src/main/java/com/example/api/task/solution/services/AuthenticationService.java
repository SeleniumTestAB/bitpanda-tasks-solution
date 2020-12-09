package com.example.api.task.solution.services;

import io.restassured.response.Response;

public class AuthenticationService extends BaseService {
    private final String USER = System.getProperty("API_USER");
    private final String PASSWORD = System.getProperty("API_PASSWORD");

    public Response authenticate() {
        return getBaseSpec().auth().preemptive().basic(USER, PASSWORD).get("/authentication");
    }

}
