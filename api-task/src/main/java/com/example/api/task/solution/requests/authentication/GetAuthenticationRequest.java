package com.example.api.task.solution.requests.authentication;

import com.example.api.task.solution.endpoints.AuthenticationEndpoint;
import com.example.api.task.solution.models.authenticate.UserFullProfile;
import org.apache.http.HttpStatus;

public class GetAuthenticationRequest extends AuthenticationEndpoint<GetAuthenticationRequest, UserFullProfile> {



    @Override
    protected UserFullProfile getModel() {
        return response.jsonPath().getObject("data", UserFullProfile.class);
    }

    @Override
    public GetAuthenticationRequest sendRequest() {
        response = getServiceApi().authenticate();
        return this;
    }

    @Override
    protected int getSuccessStatusCode() {
        return HttpStatus.SC_OK;
    }
}
