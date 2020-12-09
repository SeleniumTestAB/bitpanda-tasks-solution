package com.example.api.task.solution.requests.spot;

import com.example.api.task.solution.endpoints.SpotEndpoint;
import com.example.api.task.solution.models.spot.Spot;
import com.example.api.task.solution.models.spot.SpotEditable;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.http.HttpStatus;

public class PostCreateSpotOnMapRequest extends SpotEndpoint<PostCreateSpotOnMapRequest, Spot> {
    @Setter
    @Accessors(fluent = true)
    private SpotEditable spotToCreate;

    @Override
    protected Spot getModel() {
        return response.jsonPath().getObject("data", Spot.class);
    }

    @Override
    public PostCreateSpotOnMapRequest sendRequest() {
        response = getServiceApi().createSpotOnMap(spotToCreate, mapId);
        return this;
    }

    @Override
    protected int getSuccessStatusCode() {
        return HttpStatus.SC_OK;
    }
}
