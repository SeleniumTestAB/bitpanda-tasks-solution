package com.example.api.task.solution.models.map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MapCounts {
    private int subscriptions;
    private int spots;
    private int comments;
    private int impressions;
    private int respots;
    private int attachments;
}
