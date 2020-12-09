package com.example.api.task.solution.spot;

import com.example.api.task.solution.models.spot.Spot;
import com.example.api.task.solution.requests.spot.GetSpotsFromAllMapsRequest;
import org.testng.annotations.Test;

import java.util.List;

public class GetSpotsFromAllMapsTest {
    private List<Spot> allSpotsList;
    @Test
    public void userShouldBeAbleToGetSpotsFromAllOwnedMaps() {
        allSpotsList = new GetSpotsFromAllMapsRequest().sendRequest()
                .assertRequestSuccess()
                .getResponseModel();
    }
}
