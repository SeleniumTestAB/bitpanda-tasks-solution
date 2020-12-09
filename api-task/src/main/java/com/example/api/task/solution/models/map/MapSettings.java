package com.example.api.task.solution.models.map;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MapSettings {
    @JsonProperty(value = "editor_access")
    private List<String> editorAccess;
    @JsonProperty(value = "visitor_access")
    private List<String> visitorAccess;
    @JsonProperty(value = "respotting_to_this_map")
    private boolean respottingToThisMap;
}
