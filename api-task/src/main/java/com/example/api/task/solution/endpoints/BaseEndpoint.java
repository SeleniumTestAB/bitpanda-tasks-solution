package com.example.api.task.solution.endpoints;

import com.example.api.task.solution.models.meta.MetaInformation;
import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class BaseEndpoint<E, M> {
    protected Response response;


    protected abstract M getModel();

    public abstract E sendRequest();

    protected abstract int getSuccessStatusCode();

    public M getResponseModel() {
        assertThatResponseIsNotNull();

        return getModel();

    }

    public MetaInformation getMetaFromResponse() {
        return response.jsonPath().getObject("meta", MetaInformation.class);
    }

    public E assertRequestSuccess() {
        return assertStatusCode(getSuccessStatusCode());
    }

    public E assertStatusCode(int statusCode) {
        assertThatResponseIsNotNull();
        assertThat(response.getStatusCode()).as("Status code").isEqualTo(statusCode);
        return (E) this;
    }

    protected void assertThatResponseIsNotNull() {
        assertThat(response).as("Request response").isNotNull();
    }

}
