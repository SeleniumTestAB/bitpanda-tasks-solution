package com.example.api.task.solution.spot;

import com.example.api.task.solution.TestHelper;
import com.example.api.task.solution.config.GlobalVariablesConfig;
import com.example.api.task.solution.models.spot.Spot;
import com.example.api.task.solution.models.spot.SpotEditable;
import com.example.api.task.solution.requests.spot.GetSpotsOnMapRequest;
import com.example.api.task.solution.requests.spot.PostCreateSpotOnMapRequest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SpotCreationTest {
    private HashMap<SpotEditable, Spot> spotRelationMap = new HashMap<>();
    private List<SpotEditable> spotsToCreateList = TestHelper.getListOfSpotsToCreateFromJSON(TestHelper.SPOT_REQUESTS_PATH() + "spots_to_create.json");

    @Test(groups = {"spots_creation"})
    public void userShouldBeAbleToCreateSpotsOnMap() {
        spotsToCreateList.forEach(spot -> {
            Spot createdSpot = new PostCreateSpotOnMapRequest().spotToCreate(spot)
                    .setMapId(GlobalVariablesConfig.getCreatedMapId())
                    .sendRequest()
                    .assertRequestSuccess()
                    .getResponseModel();
            spotRelationMap.put(spot, createdSpot);
        });
        int createdSpotCount = new GetSpotsOnMapRequest().setMapId(GlobalVariablesConfig.getCreatedMapId())
                .sendRequest().assertRequestSuccess().getResponseModel().size();
        assertThat(spotRelationMap.entrySet().size()).isEqualTo(createdSpotCount);
    }

    @Test(groups = {"spots_creation"}, dependsOnMethods = "userShouldBeAbleToCreateSpotsOnMap")
    public void createdSpotsShouldHaveProperTitle() {
        spotRelationMap.forEach((key, value) -> assertThat(key.getTitle()).isEqualTo(value.getTitle()));
    }

    @Test(groups = {"spots_creation"}, dependsOnMethods = "userShouldBeAbleToCreateSpotsOnMap")
    public void createdSpotsShouldHaveProperDescription() {
        spotRelationMap.forEach((key, value) -> assertThat(key.getDescription()).isEqualTo(value.getDescription()));
    }

    @Test(groups = {"spots_creation"}, dependsOnMethods = "userShouldBeAbleToCreateSpotsOnMap")
    public void createdSpotsShouldHaveProperCoordinates() {
        spotRelationMap.forEach((key, value) -> {
            assertThat(key.getLat()).isEqualByComparingTo(value.getLat());
            assertThat(key.getLon()).isEqualByComparingTo(value.getLon());
        });
    }

}
