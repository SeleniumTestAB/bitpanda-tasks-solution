package com.example.api.task.solution.spot;

import com.example.api.task.solution.TestHelper;
import com.example.api.task.solution.config.GlobalVariablesConfig;
import com.example.api.task.solution.models.spot.Spot;
import com.example.api.task.solution.models.spot.SpotEditable;
import com.example.api.task.solution.requests.spot.GetSpotsOnMapRequest;
import com.example.api.task.solution.requests.spot.PatchUpdateSpotRequest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpotUpdateTest {
    private Spot spotToUpdate;
    private Spot spotAfterUpdate;
    private SpotEditable update = TestHelper.getSpotInfoForUpdateFromJSON(TestHelper.SPOT_REQUESTS_PATH() + "spot_for_update.json");

    @BeforeGroups("spot_update")
    public void findSpotForUpdate() {
        spotToUpdate = new GetSpotsOnMapRequest().setMapId(GlobalVariablesConfig.getCreatedMapId())
                .sendRequest().getResponseModel().get(0);
    }

    @Test(groups = {"spot_update"})
    public void userShouldBeAbleToUpdateSpot() {
        spotAfterUpdate = new PatchUpdateSpotRequest().spotToUpdate(update).spotId(spotToUpdate.getId())
                .sendRequest()
                .assertRequestSuccess()
                .getResponseModel();
    }


    @Test(groups = {"spot_update"}, dependsOnMethods = "userShouldBeAbleToUpdateSpot")
    public void spotShouldHaveUpdatedTitle() {
        assertThat(spotToUpdate.getTitle()).isNotEqualTo(spotAfterUpdate.getTitle());
        assertThat(update.getTitle()).isEqualTo(spotAfterUpdate.getTitle());
    }

    @Test(groups = {"spot_update"}, dependsOnMethods = "userShouldBeAbleToUpdateSpot")
    public void spotShouldNotHaveUpdatedDescription() {
        assertThat(spotToUpdate.getDescription()).isEqualTo(spotAfterUpdate.getDescription());
        assertThat(update.getDescription()).isNotEqualTo(spotAfterUpdate.getDescription());
    }

    @Test(groups = {"spot_update"}, dependsOnMethods = "userShouldBeAbleToUpdateSpot")
    public void spotShouldHaveUpdatedCoordinates() {
        assertThat(spotToUpdate.getLon()).isNotEqualByComparingTo(spotAfterUpdate.getLon());
        assertThat(spotToUpdate.getLat()).isNotEqualByComparingTo(spotAfterUpdate.getLat());
        assertThat(update.getLon()).isEqualByComparingTo(spotAfterUpdate.getLon());
        assertThat(update.getLat()).isEqualByComparingTo(spotAfterUpdate.getLat());
    }

}
