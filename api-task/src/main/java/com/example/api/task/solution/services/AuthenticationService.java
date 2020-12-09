package com.example.api.task.solution.services;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthenticationService extends BaseService {
    private final String USER = System.getProperty("API_USER");
    private final String PASSWORD = System.getProperty("API_PASSWORD");

    public Response authenticate() {
        log.info(USER);
        return getBaseSpec().auth().preemptive().basic(USER, PASSWORD).get("/authentication");
    }

}
