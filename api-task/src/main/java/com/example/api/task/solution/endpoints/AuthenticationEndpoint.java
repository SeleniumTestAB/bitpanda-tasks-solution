package com.example.api.task.solution.endpoints;

import com.example.api.task.solution.services.AuthenticationService;
import com.example.api.task.solution.services.RestService;

public abstract class AuthenticationEndpoint<E, M> extends BaseEndpoint<E, M> implements RestService<AuthenticationService> {
    @Override
    public AuthenticationService getServiceApi() {
        return new AuthenticationService();
    }
}
