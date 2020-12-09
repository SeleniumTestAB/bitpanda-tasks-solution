package com.example.api.task.solution.requests.map;

import com.example.api.task.solution.endpoints.MapEndpoint;
import com.example.api.task.solution.models.map.Map;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.http.HttpStatus;

public class DeleteMapRequest extends MapEndpoint<DeleteMapRequest, Map> {
    @Accessors(chain = true)
    @Setter
    private int mapId;


    @Override
    protected Map getModel() {
        return response.jsonPath().getObject("data", Map.class);
    }

    @Override
    public DeleteMapRequest sendRequest() {
        response = getServiceApi().deleteMap(mapId);
        return this;
    }

    @Override
    protected int getSuccessStatusCode() {
        return HttpStatus.SC_OK;
    }
}
