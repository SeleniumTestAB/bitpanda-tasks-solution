package com.example.api.task.solution.map;

import com.example.api.task.solution.config.GlobalVariablesConfig;
import com.example.api.task.solution.models.map.Map;
import com.example.api.task.solution.requests.map.DeleteMapRequest;
import com.example.api.task.solution.requests.map.GetMapsRequest;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MapDeleteTest {
    private Map deletedMap;
    List<Map> userMapListAfterDeletion;
    int userMapCountBeforeDeletion;
    int userMapCountAfterDeletion;

    @Test(priority = 1, groups = {"map_delete"})
    public void userShouldBeAbleToDeleteMap() {
        userMapCountBeforeDeletion = new GetMapsRequest().sendRequest()
                .assertRequestSuccess()
                .getResponseModel().size();
        deletedMap = new DeleteMapRequest().setMapId(GlobalVariablesConfig.getCreatedMapId())
                .sendRequest()
                .assertRequestSuccess()
                .getResponseModel();

        userMapListAfterDeletion = new GetMapsRequest().sendRequest()
                .assertRequestSuccess()
                .getResponseModel();
        userMapCountAfterDeletion = userMapListAfterDeletion.size();
        assertThat(userMapCountBeforeDeletion).isGreaterThan(userMapCountAfterDeletion);
        assertThat(userMapCountAfterDeletion).isEqualTo(userMapCountBeforeDeletion - 1);

    }

    @Test(groups = {"map_delete"}, dependsOnMethods = "userShouldBeAbleToDeleteMap")
    public void userMapListShouldNotContainDeletedMap() {
        assertThat(userMapListAfterDeletion.stream().allMatch(userMap -> userMap.getId() != deletedMap.getId())).isTrue();
    }
}
