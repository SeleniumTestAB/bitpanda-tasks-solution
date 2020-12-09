package com.example.api.task.solution.requests.spot;

import com.example.api.task.solution.endpoints.SpotEndpoint;
import com.example.api.task.solution.models.spot.Spot;
import org.apache.http.HttpStatus;

import java.util.List;

public class GetSpotsOnMapRequest extends SpotEndpoint<GetSpotsOnMapRequest, List<Spot>> {
    @Override
    protected List<Spot> getModel() {
        return response.jsonPath().getList("data", Spot.class);
    }

    @Override
    public GetSpotsOnMapRequest sendRequest() {
        response = getServiceApi().getSpotsOnGivenMap(mapId);
        return this;
    }

    @Override
    protected int getSuccessStatusCode() {
        return HttpStatus.SC_OK;
    }
}
