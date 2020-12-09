package com.example.api.task.solution.services;

import com.example.api.task.solution.models.spot.SpotEditable;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SpotService extends BaseService {
    @Override
    protected RequestSpecification getBaseSpec() {
        return super.getBaseSpec().request().header(getAuthenticationHeader());
    }


    public Response createSpotOnMap(SpotEditable spotToCreate, int mapId) {
        return getBaseSpec().contentType("multipart/form-data")
                .formParam("spot[title]", spotToCreate.getTitle())
                .formParam("spot[description]", spotToCreate.getDescription())
                .formParam("spot[picture]", spotToCreate.getPicture())
                .formParam("spot[lat]", spotToCreate.getLat())
                .formParam("spot[lon]", spotToCreate.getLon())
                .pathParam("id", mapId)
                .post("/maps/{id}/spots");
    }


    public Response updateSpot(SpotEditable spotToCreate, int spotId) {
        return getBaseSpec().contentType("multipart/form-data")
                .formParam("spot[title]", spotToCreate.getTitle())
                .formParam("spot[lat]", spotToCreate.getLat())
                .formParam("spot[lon]", spotToCreate.getLon())
                .pathParam("id", spotId)
                .patch("/spots/{id}");
    }


    public Response getSpotsOnGivenMap(int mapId) {
        return getBaseSpec().pathParam("id", mapId)
                .get("/maps/{id}/spots");
    }
}
