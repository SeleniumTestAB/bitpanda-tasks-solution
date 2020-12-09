package com.example.api.task.solution.models.map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MapEditable {
    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    private String title;
    private String description;
    private String visibility;
    private String picture;
    @JsonProperty(value = "map_settings")
    private MapSettings mapSettings;


}
