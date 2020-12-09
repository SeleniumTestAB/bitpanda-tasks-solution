package com.example.api.task.solution.models.spot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpotCounts {
    private int respot;
    private int attachments;
    private  int comments;
}
