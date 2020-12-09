package com.example.api.task.solution.map;

import com.example.api.task.solution.TestHelper;
import com.example.api.task.solution.config.GlobalVariablesConfig;
import com.example.api.task.solution.models.map.Map;
import com.example.api.task.solution.models.map.MapEditable;
import com.example.api.task.solution.requests.map.PostCreateMapRequest;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositiveMapCreationTest {
    private final MapEditable mapEditable = TestHelper.getMapToCreateFromJSON(TestHelper.MAP_REQUESTS_PATH() + "create_map_positive.json");
    private Map createdMap;

    @Test(priority = 1, groups = {"map_creation_positive"})
    public void userShouldBeAbleToCreateMap() {
        createdMap = new PostCreateMapRequest().setMapEditable(mapEditable)
                .sendRequest()
                .assertRequestSuccess()
                .getResponseModel();
    }

    @Test(groups = {"map_creation_positive"}, dependsOnMethods = "userShouldBeAbleToCreateMap")
    public void createdMapShouldHaveId() {
        assertThat(createdMap.getId()).isNotNull();
    }

    @Test(groups = {"map_creation_positive"}, dependsOnMethods = "userShouldBeAbleToCreateMap")
    public void createMapShouldHaveProperTitle() {
        assertThat(createdMap.getTitle()).isEqualTo(mapEditable.getTitle());
    }


    @Test(groups = {"map_creation_positive"}, dependsOnMethods = "userShouldBeAbleToCreateMap")
    public void createMapShouldHaveProperDescription() {
        assertThat(createdMap.getDescription()).isEqualTo(mapEditable.getDescription());
    }


    @AfterGroups("map_creation_positive")
    public void assignCreatedMapIdToGlobalVariables() {
        GlobalVariablesConfig.setCreatedMapId(createdMap.getId());
    }

}
