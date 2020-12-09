package com.example.api.task.solution;

import com.example.api.task.solution.config.ResourceReader;
import com.example.api.task.solution.models.map.MapEditable;
import com.example.api.task.solution.models.spot.SpotEditable;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.experimental.Accessors;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class TestHelper {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Getter
    @Accessors(fluent = true)
    private final String MAP_REQUESTS_PATH = "requests/map/";
    @Getter
    @Accessors(fluent = true)
    private final String SPOT_REQUESTS_PATH = "/requests/spot/";

    @SneakyThrows
    public MapEditable getMapToCreateFromJSON(String jsonFile) {
        return objectMapper.readValue(ResourceReader.loadFileFromTestResources(TestHelper.class, jsonFile), MapEditable.class);
    }

    @SneakyThrows
    public SpotEditable getSpotInfoForUpdateFromJSON(String jsonFile) {
        return objectMapper.readValue(ResourceReader.loadFileFromTestResources(TestHelper.class, jsonFile), SpotEditable.class);
    }

    @SneakyThrows
    public List<SpotEditable> getListOfSpotsToCreateFromJSON(String jsonFile) {
        return objectMapper.readValue(ResourceReader.loadFileFromTestResources(TestHelper.class, jsonFile), new TypeReference<>() {});
    }

}
