package com.example.api.task.solution.models.authenticate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private int id;
    private String name;
    @JsonProperty("screen_name")
    private String screenName;
    private String url;
    private String location;
    @JsonProperty("picture_url")
    private String pictureUrl;
    @JsonProperty("header_picture")
    private String headerPicture;
    private String about;
    private Map<String, Integer> counts;
}
