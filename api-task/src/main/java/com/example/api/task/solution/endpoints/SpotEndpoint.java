package com.example.api.task.solution.endpoints;

import com.example.api.task.solution.services.RestService;
import com.example.api.task.solution.services.SpotService;
import lombok.Setter;
import lombok.experimental.Accessors;

public abstract class SpotEndpoint<E, M> extends BaseEndpoint<E, M> implements RestService<SpotService> {
    @Setter
    @Accessors(chain = true)
    protected int mapId;


    @Override
    public SpotService getServiceApi() {
        return new SpotService();
    }
}
