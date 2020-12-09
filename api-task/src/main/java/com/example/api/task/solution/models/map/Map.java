package com.example.api.task.solution.models.map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Map {
    private int id;
    private String title;
    private String description;
    private String visibility;
    @JsonProperty(value = "picture_url")
    private String pictureUrl;
    @JsonProperty(value = "logo_picture")
    private String logoPicture;
    @JsonProperty(value = "owner_id")
    private int ownerId;
    @JsonProperty(value = "created_at")
    private String createdAt;
    @JsonProperty(value = "updated_at")
    private String updatedAt;
    @JsonProperty(value = "map_settings")
    private MapSettings mapSettings;
    private MapCounts counts;
}
