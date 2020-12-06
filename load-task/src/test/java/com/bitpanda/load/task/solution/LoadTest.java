package com.bitpanda.load.task.solution;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;


public class LoadTest {


    @Test
    public void getToHomePageTest1() {
        RestAssured.given()
                .baseUri("https://orangehrm-demo-6x.orangehrmlive.com")
                .port(443)
                .filter(new AllureRestAssured())
                .when()
                .get("/auth/login")
                .then().statusCode(200);

    }


}
