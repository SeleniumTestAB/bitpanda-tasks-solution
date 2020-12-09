package com.example.api.task.solution.map;

import com.example.api.task.solution.TestHelper;
import com.example.api.task.solution.models.map.MapEditable;
import com.example.api.task.solution.models.meta.MetaInformation;
import com.example.api.task.solution.requests.map.PostCreateMapRequest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NegativeMapCreationTest {
    private final MapEditable mapEditable = TestHelper.getMapToCreateFromJSON(TestHelper.MAP_REQUESTS_PATH() + "create_map_negative.json");
    private MetaInformation meta;

    @Test(groups = {"map_creation_negative"})
    public void userShouldBeAbleToCreateMap() {
        meta = new PostCreateMapRequest().setMapEditable(mapEditable)
                .sendRequest()
                .assertRequestSuccess()
                .getMetaFromResponse();
    }


    @Test(groups = {"map_creation_negative"}, dependsOnMethods = "userShouldBeAbleToCreateMap")
    public void responseShouldHaveStatusCode400(){
        assertThat(meta.getCode()).isNotNull();
        assertThat(meta.getCode()).isEqualTo(400);
    }

    @Test(groups = {"map_creation_negative"}, dependsOnMethods = "userShouldBeAbleToCreateMap")
    public void responseShouldHaveErrorMessage() {
        assertThat(meta.getErrorMessage()).isNotBlank()
                .isInstanceOf(String.class);
    }

    @Test(groups = {"map_creation_negative"}, dependsOnMethods = "userShouldBeAbleToCreateMap")
    public void verificationOfErrorMessageContent() {
        assertThat(meta.getErrorMessage()).isEqualTo("[\"Title is too short (minimum is 2 characters)\", \"Title is too long (maximum is 256 characters)\"]");
    }
}
