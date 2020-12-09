package com.example.api.task.solution.requests.map;

import com.example.api.task.solution.endpoints.MapEndpoint;
import com.example.api.task.solution.models.map.Map;
import com.example.api.task.solution.models.map.MapEditable;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.http.HttpStatus;
@Accessors(chain = true)
public class PostCreateMapRequest extends MapEndpoint<PostCreateMapRequest, Map> {
    @Setter
    private MapEditable mapEditable;



    @Override
    protected Map getModel() {
        return response.jsonPath().getObject("data", Map.class);
    }

    @Override
    public PostCreateMapRequest sendRequest() {
        response = getServiceApi().createMap(mapEditable);
        return this;
    }

    @Override
    protected int getSuccessStatusCode() {
        return HttpStatus.SC_OK;
    }
}
