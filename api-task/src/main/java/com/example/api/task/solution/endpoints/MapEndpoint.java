package com.example.api.task.solution.endpoints;

import com.example.api.task.solution.services.MapService;
import com.example.api.task.solution.services.RestService;

public abstract class MapEndpoint<E, M> extends BaseEndpoint<E, M> implements RestService<MapService> {
    @Override
    public MapService getServiceApi() {
        return new MapService();
    }
}
