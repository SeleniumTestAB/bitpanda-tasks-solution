package com.example.api.task.solution.authenticate;

import com.example.api.task.solution.config.GlobalVariablesConfig;
import com.example.api.task.solution.models.authenticate.UserFullProfile;
import com.example.api.task.solution.requests.authentication.GetAuthenticationRequest;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthenticationTest {
    private UserFullProfile userFullProfile;

    @Test(priority = 1, groups = {"authentication"})
    public void userShouldAuthenticate() {
        userFullProfile = new GetAuthenticationRequest().sendRequest()
                .assertRequestSuccess()
                .getResponseModel();

    }

    @Test(dependsOnMethods = {"userShouldAuthenticate"}, groups = {"authentication"})
    public void userShouldReceiveAuthenticationToken() {
        assertThat(userFullProfile.getAuthToken()).isNotNull();
        assertThat(userFullProfile.getAuthToken()).isNotEmpty();
        assertThat(userFullProfile.getAuthToken()).isInstanceOf(String.class);

    }

    @AfterGroups( {"authentication"})
    public void assignAuthTokenToGlobalVariables(){
        GlobalVariablesConfig.setAuthToken( userFullProfile.getAuthToken());
    }


}
