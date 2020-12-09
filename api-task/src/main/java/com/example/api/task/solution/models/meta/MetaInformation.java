package com.example.api.task.solution.models.meta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaInformation {
    private int code;
    @JsonProperty("error_message")
    private String errorMessage;
    @JsonProperty("error_type")
    private String errorType;
}
