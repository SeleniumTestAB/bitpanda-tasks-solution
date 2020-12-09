package com.example.api.task.solution.requests.map;

import com.example.api.task.solution.endpoints.MapEndpoint;
import com.example.api.task.solution.models.map.Map;
import org.apache.http.HttpStatus;

import java.util.List;

public class GetMapsRequest extends MapEndpoint<GetMapsRequest, List<Map>> {



    @Override
    protected List<Map> getModel() {
        return response.jsonPath().getList("data", Map.class);
    }

    @Override
    public GetMapsRequest sendRequest() {
        response = getServiceApi().getMaps();
        return this;
    }

    @Override
    protected int getSuccessStatusCode() {
        return HttpStatus.SC_OK;
    }
}
