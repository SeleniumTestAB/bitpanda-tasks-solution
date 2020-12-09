package com.example.api.task.solution.models.spot;

import com.example.api.task.solution.models.authenticate.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Spot {
    private int id;
    @JsonProperty("map_id")
    private int mapId;
    @JsonProperty("user_id")
    private int userId;
    private String title;
    private String description;
    @JsonProperty("time_zone")
    private String timeZone;
    @JsonProperty("picture_url")
    private String pictureUrl;
    @JsonDeserialize(using = NumberDeserializers.BigDecimalDeserializer.class)
    private BigDecimal lat;
    @JsonDeserialize(using = NumberDeserializers.BigDecimalDeserializer.class)
    private BigDecimal lon;
    private String status;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    private User user;
    private SpotCounts counts;
}
