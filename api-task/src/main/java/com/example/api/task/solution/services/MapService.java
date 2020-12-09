package com.example.api.task.solution.services;

import com.example.api.task.solution.models.map.MapEditable;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MapService extends BaseService {
    @Override
    protected RequestSpecification getBaseSpec() {
        return super.getBaseSpec().request().header(getAuthenticationHeader());
    }

    public Response createMap(MapEditable mapEditable) {
        return getBaseSpec().body(mapEditable).post("/maps");
    }

    public Response deleteMap(int mapId) {
        return getBaseSpec().pathParam("id", mapId)
                .delete("/maps/{id}");
    }

    public Response getMaps() {
        return getBaseSpec().get("/maps");
    }


}
