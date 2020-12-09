package com.example.api.task.solution.requests.spot;

import com.example.api.task.solution.endpoints.SpotEndpoint;
import com.example.api.task.solution.models.spot.Spot;
import com.example.api.task.solution.models.spot.SpotEditable;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.http.HttpStatus;

public class PatchUpdateSpotRequest extends SpotEndpoint<PatchUpdateSpotRequest, Spot> {
    @Setter
    @Accessors(fluent = true)
    private SpotEditable spotToUpdate;

    @Setter
    @Accessors(fluent = true)
    private int spotId;

    @Override
    protected Spot getModel() {
        return response.jsonPath().getObject("data", Spot.class);
    }

    @Override
    public PatchUpdateSpotRequest sendRequest() {
        response = getServiceApi().updateSpot(spotToUpdate, spotId);
        return this;
    }

    @Override
    protected int getSuccessStatusCode() {
        return HttpStatus.SC_OK;
    }
}
