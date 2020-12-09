package com.example.api.task.solution.services;

import com.example.api.task.solution.config.GlobalVariablesConfig;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

public abstract class BaseService {

    protected RequestSpecification getBaseSpec() {

        return RestAssured.with().baseUri("https://uebermaps.com/api/v2").config(RestAssured.config()
                .encoderConfig(EncoderConfig.encoderConfig().encodeContentTypeAs("multipart/form-data", ContentType.JSON)))
                .filter(new AllureRestAssured().setRequestTemplate("my-http-request.ftl")).response().log().all()
                .request().contentType(ContentType.JSON);
    }


    protected Header getAuthenticationHeader() {
       return new Header("X-AUTH-TOKEN", GlobalVariablesConfig.getAuthToken());
    }
}
